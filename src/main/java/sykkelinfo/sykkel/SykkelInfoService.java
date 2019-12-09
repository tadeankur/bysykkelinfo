package sykkelinfo.sykkel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sykkelinfo.stationinfo.Station;
import sykkelinfo.stationinfo.StationInfoRestClient;
import sykkelinfo.stationinfo.StationInformasjon;
import sykkelinfo.stationstatus.StationStatus;
import sykkelinfo.stationstatus.StationTilgjengelighetStatusRestClient;
import sykkelinfo.stationstatus.TilgjengelighetStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class SykkelInfoService {
    private final StationInfoRestClient stationInfoRestClient;
    private final StationTilgjengelighetStatusRestClient stationTilgjengelighetStatusRestClient;

    @Autowired
    public SykkelInfoService(StationInfoRestClient stationInfoRestClient,
                             StationTilgjengelighetStatusRestClient stationTilgjengelighetStatusRestClient) {
        this.stationInfoRestClient = stationInfoRestClient;
        this.stationTilgjengelighetStatusRestClient = stationTilgjengelighetStatusRestClient;
    }

    List<SykkelStativerStatusDto> hentSykkelStativStatus() {

        List<SykkelStativerStatusDto> sykkelStativerStatusDtos = new ArrayList<>();
        StationInformasjon stationInformation = stationInfoRestClient.getStationsInformasjon();
        StationStatus stationStatus = stationTilgjengelighetStatusRestClient.getStationStatus();
        stationInformation.data.stations.forEach(station -> stationStatus.data.stations.stream()
                .filter(tilgjengelighetStatus -> tilgjengelighetStatus.station_id.equals(station.station_id))
                .map(tilgjengelighetStatus -> toSySykkelStativerStatusDto(station, tilgjengelighetStatus))
                .findAny()
                .ifPresent(sykkelStativerStatusDto ->
                        sykkelStativerStatusDtos.add(sykkelStativerStatusDto)));

        return sykkelStativerStatusDtos;

    }

    private SykkelStativerStatusDto toSySykkelStativerStatusDto(Station station, TilgjengelighetStatus tilgjengelighetStatus) {
        return new SykkelStativerStatusDto(station.station_id, station.name,
                station.address, station.capacity, tilgjengelighetStatus.num_bikes_available);
    }
}
