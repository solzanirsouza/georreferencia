package souza.solzanir.georreferencia.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleGeocodeResponseDTO implements Serializable {

    private List<GeocodeDTO> results;

    public List<GeocodeDTO> getResults() {
        return results;
    }

    public GoogleGeocodeResponseDTO setResults(List<GeocodeDTO> results) {
        this.results = results;
        return this;
    }
}
