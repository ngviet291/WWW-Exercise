package model;

import java.util.List;

public class Passenger {
    private String passengerName;
    private String password;
    private String seatType;
    private List<String> route;

    public Passenger() {
    }

    public Passenger(String passengerName, String password, String seatType, List<String> route) {
        this.passengerName = passengerName;
        this.password = password;
        this.seatType = seatType;
        this.route = route;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public List<String> getRoute() {
        return route;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }
}
