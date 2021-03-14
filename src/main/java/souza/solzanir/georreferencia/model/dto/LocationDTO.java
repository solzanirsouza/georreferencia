package souza.solzanir.georreferencia.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDTO implements Serializable {

    private BigDecimal lat;
    private BigDecimal lng;

    public BigDecimal getLat() {
        return lat;
    }

    public LocationDTO setLat(BigDecimal lat) {
        this.lat = lat;
        return this;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public LocationDTO setLng(BigDecimal lng) {
        this.lng = lng;
        return this;
    }
}