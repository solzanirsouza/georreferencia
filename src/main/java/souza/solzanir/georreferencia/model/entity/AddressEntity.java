package souza.solzanir.georreferencia.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "address")
public class AddressEntity implements Serializable {

    @Id
    private Long id;
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

    public AddressEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public AddressEntity setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public AddressEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public AddressEntity setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public AddressEntity setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressEntity setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public AddressEntity setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public AddressEntity setCountry(String country) {
        this.country = country;
        return this;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public AddressEntity setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public AddressEntity setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
        return this;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public AddressEntity setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}