package sykkelinfo.stationstatus;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static sykkelinfo.utils.RestUtils.lagHttpHeader;

@Service
public class StationTilgjengelighetStatusRestClient {
    private final String uri = "https://gbfs.urbansharing.com/oslobysykkel.no/station_status.json";

    public StationStatus getStationStatus() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<StationStatus> result = restTemplate.exchange(uri,
                HttpMethod.GET, lagHttpHeader(), StationStatus.class);

        return result.getBody();

    }


}
