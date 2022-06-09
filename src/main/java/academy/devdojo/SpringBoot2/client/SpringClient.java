package academy.devdojo.SpringBoot2.client;

import academy.devdojo.SpringBoot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class, 1);

        log.info("getForEntity object:"+ entity);

        Anime anime = new RestTemplate().getForObject("http://localhost:8080/animes/1", Anime.class);

        log.info("getForObject object:"+anime);

        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/", Anime[].class);

        log.info("getForObject List:" + animes);

        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Anime>>() {
                });

        log.info("exchange List:"+ exchange.getBody());
    }
}
