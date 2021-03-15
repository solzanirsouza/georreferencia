package souza.solzanir.georreferencia.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressRequestDTO implements Serializable {

    private Long id;
    private String complement;
    private String latitude;
    private String longitude;

    @JsonProperty("street_name")
    @NotBlank(message = "O valor do campo streetName é inválido")
    private String streetName;

    @NotBlank(message = "O valor do campo number é inválido")
    private String number;

    @NotBlank(message = "O valor do campo neighbourhood é inválido")
    private String neighbourhood;

    @NotBlank(message = "O valor do campo city é inválido")
    private String city;

    @NotBlank(message = "O valor do campo state é inválido")
    private String state;

    @NotBlank(message = "O valor do campo country é inválido")
    private String country;

    @NotNull(message = "O campo zipcode é obrigatório")
    @Min(value = 9999999, message = "O valor do campo zipcode é inválido")
    @Max(value = 99999999, message = "O valor do campo zipcode é inválido")
    private Integer zipcode;

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

    public String getLatitude() {
        return latitude;
    }

    public AddressRequestDTO setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public AddressRequestDTO setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }
}
