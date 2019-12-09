package sykkelinfo.stationinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    public List<Station> stations;
}
