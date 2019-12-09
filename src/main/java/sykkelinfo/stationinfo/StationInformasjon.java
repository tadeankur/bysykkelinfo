package sykkelinfo.stationinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationInformasjon {
    public String last_updated;
    public Data data;
}
