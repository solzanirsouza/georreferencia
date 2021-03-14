package souza.solzanir.georreferencia.service.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestComponent {

    @Autowired
    private RestTemplate restTemplate;

    public <T> T get(String url, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity(headers);
        String urlCompleta = url;
        return restTemplate.exchange(urlCompleta, HttpMethod.GET, request, responseType).getBody();
    }
}
