package souza.solzanir.georreferencia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import souza.solzanir.georreferencia.model.dto.AddressRequestDTO;
import souza.solzanir.georreferencia.model.dto.AddressResponseDTO;
import souza.solzanir.georreferencia.model.entity.AddressEntity;
import souza.solzanir.georreferencia.model.vo.GeocodeVO;
import souza.solzanir.georreferencia.repository.AddressRepository;
import souza.solzanir.georreferencia.service.component.GoogleComponent;
import souza.solzanir.georreferencia.util.conversors.AddressConverter;
import souza.solzanir.georreferencia.util.validators.FieldValidator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static org.apache.logging.log4j.util.Strings.isBlank;
import static souza.solzanir.georreferencia.util.conversors.AddressConverter.toDTO;
import static souza.solzanir.georreferencia.util.conversors.AddressConverter.toEntity;
import static souza.solzanir.georreferencia.util.validators.NumberValidator.nonValid;

@Service
public class AddressService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AddressRepository repository;

    @Autowired
    private GoogleComponent component;

    @Autowired
    private FieldValidator validator;

    public AddressResponseDTO save(AddressRequestDTO address) {
        logger.info(format("Saving a new address at street %s", address.getStreetName()));
        validator.validate(address);
        getGeocode(address);
        AddressEntity entity = repository.save(toEntity(address));
        return toDTO(entity);
    }

    public AddressResponseDTO getById(Long addressId) {
        logger.info(format("Looking for address by id %d", addressId));
        Optional<AddressEntity> entity = repository.findById(addressId);
        return entity.map(AddressConverter::toDTO).orElse(null);
    }

    public List<AddressResponseDTO> getByZipcode(Integer zipcode) {
        logger.info(format("Looking for all address by zipcode %d", zipcode));
        List<AddressEntity> addressList = repository.findAllByZipcode(zipcode);
        return addressList.stream().map(AddressConverter::toDTO).collect(toList());
    }

    public void delete(Long addressId) {
        logger.info(format("Deleting address by id %d", addressId));
        repository.deleteById(addressId);
    }

    private void getGeocode(AddressRequestDTO address) {

        if (isBlank(address.getLatitude()) || isBlank(address.getLongitude()) || invalidValues(address)) {
            GeocodeVO geocode = component.getGeocode(
                    address.getStreetName(),
                    address.getNumber(),
                    address.getCity(),
                    address.getState());

            address
                    .setLatitude(geocode.getLatitude().toString())
                    .setLongitude(geocode.getLongitude().toString());
        }
    }

    private boolean invalidValues(AddressRequestDTO address) {
        return nonValid(new BigDecimal(address.getLatitude()), false, true)
                || nonValid(new BigDecimal(address.getLongitude()), false, true);
    }
}