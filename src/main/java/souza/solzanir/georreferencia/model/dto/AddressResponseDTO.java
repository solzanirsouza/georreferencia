package souza.solzanir.georreferencia.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressResponseDTO implements Serializable {

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
    private BigDecimal latitude;
    private BigDecimal longitude;

    public Long getId() {
        return id;
    }

    public AddressResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public AddressResponseDTO setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public AddressResponseDTO setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public AddressResponseDTO setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public AddressResponseDTO setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressResponseDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public AddressResponseDTO setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public AddressResponseDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public AddressResponseDTO setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public AddressResponseDTO setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
        return this;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public AddressResponseDTO setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
        return this;
    }
}