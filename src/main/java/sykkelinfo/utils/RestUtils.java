package sykkelinfo.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Arrays;

public class RestUtils {


    public static HttpEntity<String> lagHttpHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Client-Identifier", "tade-bysykkelinfo");
        return new HttpEntity<>("parameters", headers);
    }
}
