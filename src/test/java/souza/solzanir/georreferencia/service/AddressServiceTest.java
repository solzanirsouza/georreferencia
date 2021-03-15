package souza.solzanir.georreferencia.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import souza.solzanir.georreferencia.model.dto.AddressRequestDTO;
import souza.solzanir.georreferencia.model.dto.AddressResponseDTO;
import souza.solzanir.georreferencia.model.entity.AddressEntity;
import souza.solzanir.georreferencia.model.vo.GeocodeVO;
import souza.solzanir.georreferencia.repository.AddressRepository;
import souza.solzanir.georreferencia.service.component.GoogleComponent;
import souza.solzanir.georreferencia.util.validators.FieldValidator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AddressServiceTest {

    @InjectMocks
    private AddressService service;

    @Mock
    private AddressRepository repository;

    @Mock
    private GoogleComponent component;

    @Mock
    private FieldValidator validator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createNewAddressWithGeocodeTest() {
        Long idAddress = 1L;

        AddressRequestDTO request = new AddressRequestDTO()
                .setStreetName("Rua Hum")
                .setLatitude("-12.3456789")
                .setLongitude("-98.7654321");

        AddressEntity entity = new AddressEntity()
                .setId(idAddress);

        when(repository.save(any())).thenReturn(entity);

        AddressResponseDTO response = assertDoesNotThrow(() -> service.save(request));
        assertNotNull(response);
        assertEquals(idAddress, response.getId());
    }

    @Test
    public void createNewAddressWithoutGeocodeTest() {
        Long idAddress = 1L;

        AddressRequestDTO request = new AddressRequestDTO()
                .setStreetName("Rua Hum")
                .setNumber("12A")
                .setCity("Limeira")
                .setState("São Paulo");

        GeocodeVO geocode = new GeocodeVO()
                .setLatitude(new BigDecimal(("-12.3456789")))
                .setLongitude(new BigDecimal("-98.7654321"));

        AddressEntity entity = new AddressEntity()
                .setId(idAddress);

        when(component.getGeocode(
                request.getStreetName(),
                request.getNumber(),
                request.getCity(),
                request.getState()))
                .thenReturn(geocode);

        when(repository.save(any())).thenReturn(entity);

        AddressResponseDTO response = assertDoesNotThrow(() -> service.save(request));
        assertNotNull(response);
        assertEquals(idAddress, response.getId());
    }

    @Test
    public void updateAddressWithGeocodeTest() {
        Long idAddress = 1L;

        AddressRequestDTO request = new AddressRequestDTO()
                .setId(idAddress)
                .setStreetName("Rua Hum")
                .setLatitude("-12.3456789")
                .setLongitude("-98.7654321");

        AddressEntity entity = new AddressEntity()
                .setId(idAddress);

        when(repository.save(any())).thenReturn(entity);

        AddressResponseDTO response = assertDoesNotThrow(() -> service.save(request));
        assertNotNull(response);
        assertEquals(idAddress, response.getId());
    }

    @Test
    public void getByIdTest() {
        Long idAddress = 1L;

        AddressEntity entity = new AddressEntity()
                .setId(idAddress)
                .setStreetName("Rua Hum")
                .setNumber("123B")
                .setComplement(null)
                .setNeighbourhood("Vila Cidade Nova")
                .setCity("Limeira")
                .setState("São Paulo")
                .setCountry("Brasil")
                .setZipcode(13480000)
                .setLatitude("-12.3456789")
                .setLongitude("-98.7654321");

        when(repository.findById(idAddress)).thenReturn(Optional.of(entity));

        AddressResponseDTO response = assertDoesNotThrow(() -> service.getById(idAddress));
        assertNotNull(response);
        assertEquals(entity.getId(), response.getId());
        assertEquals(entity.getStreetName(), response.getStreetName());
        assertEquals(entity.getNumber(), response.getNumber());
        assertEquals(entity.getComplement(), response.getComplement());
        assertEquals(entity.getNeighbourhood(), response.getNeighbourhood());
        assertEquals(entity.getCity(), response.getCity());
        assertEquals(entity.getState(), response.getState());
        assertEquals(entity.getCountry(), response.getCountry());
        assertEquals(entity.getZipcode(), response.getZipcode());
        assertEquals(entity.getLatitude(), response.getLatitude());
        assertEquals(entity.getLongitude(), response.getLongitude());
    }

    @Test
    public void getByZipcodeTest() {
        Integer zipcode = 13480000;

        AddressEntity entity = new AddressEntity()
                .setId(1L)
                .setStreetName("Rua Hum")
                .setNumber("123B")
                .setComplement(null)
                .setNeighbourhood("Vila Cidade Nova")
                .setCity("Limeira")
                .setState("São Paulo")
                .setCountry("Brasil")
                .setZipcode(zipcode)
                .setLatitude("-12.3456789")
                .setLongitude("-98.7654321");

        when(repository.findAllByZipcode(zipcode)).thenReturn(asList(entity));

        List<AddressResponseDTO> responseList = assertDoesNotThrow(() -> service.getByZipcode(zipcode));
        assertTrue(!responseList.isEmpty());

        AddressResponseDTO response = responseList.get(0);
        assertEquals(entity.getId(), response.getId());
        assertEquals(entity.getStreetName(), response.getStreetName());
        assertEquals(entity.getNumber(), response.getNumber());
        assertEquals(entity.getComplement(), response.getComplement());
        assertEquals(entity.getNeighbourhood(), response.getNeighbourhood());
        assertEquals(entity.getCity(), response.getCity());
        assertEquals(entity.getState(), response.getState());
        assertEquals(entity.getCountry(), response.getCountry());
        assertEquals(entity.getZipcode(), response.getZipcode());
        assertEquals(entity.getLatitude(), response.getLatitude());
        assertEquals(entity.getLongitude(), response.getLongitude());
    }

    @Test
    public void deleteTest() {
        assertDoesNotThrow(() -> service.delete(123L));
    }
}