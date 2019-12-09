package sykkelinfo.stationinfo;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static sykkelinfo.utils.RestUtils.lagHttpHeader;

@Service
public class StationInfoRestClient {
    private final String uri = "https://gbfs.urbansharing.com/oslobysykkel.no/station_information.json";


    public StationInformasjon getStationsInformasjon() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<StationInformasjon> result = restTemplate.exchange(uri,
                HttpMethod.GET, lagHttpHeader(), StationInformasjon.class);
        return result.getBody();
    }

}
