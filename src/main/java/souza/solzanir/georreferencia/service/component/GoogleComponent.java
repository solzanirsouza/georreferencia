package souza.solzanir.georreferencia.service.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import souza.solzanir.georreferencia.model.dto.GoogleGeocodeResponseDTO;
import souza.solzanir.georreferencia.model.vo.GeocodeVO;

@Component
public class GoogleComponent {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.config.google.base-url}")
    private String baseUrl;

    @Value("${spring.config.google.api-key}")
    private String apiKey;

    @Autowired
    private RestComponent component;

    public GeocodeVO getGeocode(String streetName, String number, String city, String state) {
        logger.info("Getting a geocode on Google API");
        String url = geoUrl(streetName, number, city, state);
        GoogleGeocodeResponseDTO googleGeocode = component.get(url, GoogleGeocodeResponseDTO.class);

        return new GeocodeVO()
                .setLatitude(googleGeocode.getResults().get(0).getGeometry().getLocation().getLat())
                .setLongitude(googleGeocode.getResults().get(0).getGeometry().getLocation().getLng());
    }

    private String geoUrl(String streetName, String number, String city, String state) {
        return baseUrl + "?address=" + number
                + "+" + getStringWithoutSpaces(streetName)
                + "," + getStringWithoutSpaces(city)
                + "," + getStringWithoutSpaces(state)
                + "&key=" + apiKey;
    }

    private String getStringWithoutSpaces(String text) {
        return text.replace(" ", "+");
    }
}
