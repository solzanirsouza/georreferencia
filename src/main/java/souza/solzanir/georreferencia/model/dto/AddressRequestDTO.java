package souza.solzanir.georreferencia.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressRequestDTO implements Serializable {

    private Long id;
    @JsonProperty("street_name")
    private String streetName;
    private String number;
    private String complement;
    private String neighbourhood;
    private String city;
    private String state;
    private String country;
    private Integer zipcode;
    private Integer latitude;
    private Integer longitude;

    public Long getId() {
        return id;
    }

    public AddressRequestDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public AddressRequestDTO setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public AddressRequestDTO setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public AddressRequestDTO setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public AddressRequestDTO setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressRequestDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public AddressRequestDTO setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public AddressRequestDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public AddressRequestDTO setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public AddressRequestDTO setLatitude(Integer latitude) {
        this.latitude = latitude;
        return this;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public AddressRequestDTO setLongitude(Integer longitude) {
        this.longitude = longitude;
        return this;
    }
}
