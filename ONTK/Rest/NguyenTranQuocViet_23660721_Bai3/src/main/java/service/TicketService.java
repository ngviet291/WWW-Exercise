package service;

import jakarta.enterprise.context.ApplicationScoped;
import model.Passenger;

import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class TicketService {
    private final List<Passenger> passengers = new ArrayList<>(List.of(
            new Passenger("Viet","123456","Giường nằm",List.of("Đà Nẵng- Huế")),
            new Passenger("VietNe","123456","Ghế ngồi",List.of("Hà Nội - Hải Phòng","TP.HCM - Đà Lạt")),
            new Passenger("VietDeptrai","123456","Ghế ngồi",List.of("TP.HCM - Đà Lạt"))
    ));
    public List<Passenger> getAll(){
        return passengers;
    }
    public Passenger getByName(String name){
        for (Passenger passenger : passengers){
            if(passenger.getPassengerName().equalsIgnoreCase(name)){
                return  passenger;
            }
        }
        return  null;
    }
    public Passenger updateByName(Passenger passenger){
        Passenger p= getByName(passenger.getPassengerName());
        if(p==null){
            return null;
        }
        p.setPassword(passenger.getPassword());
        p.setSeatType(passenger.getSeatType());
        p.setRoute(passenger.getRoute());
        return p;
    }
    public boolean delete(String passengerName){
        return passengers.removeIf(passenger -> passenger.getPassengerName().equalsIgnoreCase(passengerName));
    }

}
