package sykkelinfo.stationinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {
    public String station_id;
    public String name;
    public String address;
    public int capacity;
}
