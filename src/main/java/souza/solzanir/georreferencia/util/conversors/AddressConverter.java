package souza.solzanir.georreferencia.util.conversors;

import souza.solzanir.georreferencia.model.dto.AddressRequestDTO;
import souza.solzanir.georreferencia.model.dto.AddressResponseDTO;
import souza.solzanir.georreferencia.model.entity.AddressEntity;

public class AddressConverter {

    public static AddressEntity toEntity(AddressRequestDTO address) {
        return new AddressEntity()
                .setId(address.getId())
                .setStreetName(address.getStreetName())
                .setNumber(address.getNumber())
                .setComplement(address.getComplement())
                .setNeighbourhood(address.getNeighbourhood())
                .setCity(address.getCity())
                .setState(address.getState())
                .setCountry(address.getCountry())
                .setZipcode(address.getZipcode())
                .setLatitude(address.getLatitude())
                .setLongitude(address.getLongitude());
    }

    public static AddressResponseDTO toDTO(AddressEntity address) {
        return new AddressResponseDTO()
                .setId(address.getId())
                .setStreetName(address.getStreetName())
                .setNumber(address.getNumber())
                .setComplement(address.getComplement())
                .setNeighbourhood(address.getNeighbourhood())
                .setCity(address.getCity())
                .setState(address.getState())
                .setCountry(address.getCountry())
                .setZipcode(address.getZipcode())
                .setLatitude(address.getLatitude())
                .setLongitude(address.getLongitude());
    }
}
