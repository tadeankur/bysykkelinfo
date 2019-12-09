package sykkelinfo.sykkel;

public class SykkelStativerStatusDto {
    private String station_id;
    private String name;
    private String address;
    private int capacity;
    private int num_bikes_available;

    SykkelStativerStatusDto(String station_id, String name, String address, int capacity, int num_bikes_available) {
        this.station_id = station_id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.num_bikes_available = num_bikes_available;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNum_bikes_available() {
        return num_bikes_available;
    }

    public void setNum_bikes_available(int num_bikes_available) {
        this.num_bikes_available = num_bikes_available;
    }

}
