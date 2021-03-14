package souza.solzanir.georreferencia.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeometryDTO implements Serializable {

    private LocationDTO location;

    public LocationDTO getLocation() {
        return location;
    }

    public GeometryDTO setLocation(LocationDTO location) {
        this.location = location;
        return this;
    }
}