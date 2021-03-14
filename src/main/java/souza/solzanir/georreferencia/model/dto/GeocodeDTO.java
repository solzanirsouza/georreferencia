package souza.solzanir.georreferencia.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeDTO implements Serializable {

    private GeometryDTO geometry;

    public GeometryDTO getGeometry() {
        return geometry;
    }

    public GeocodeDTO setGeometry(GeometryDTO geometry) {
        this.geometry = geometry;
        return this;
    }
}