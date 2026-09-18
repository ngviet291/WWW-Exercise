package com.ngviet291.nguyentranquocviet_23660721_bai05.cdi;

import com.ngviet291.nguyentranquocviet_23660721_bai05.model.Passenger;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Getter
@Setter
public class TicketManager{
    private List<Passenger> passengers= new ArrayList<>(List.of(
            new Passenger("Viet", "viet37fc","Ghế ngồi",List.of("Hà Nội-Hải Phòng","TP.HCM- Đà Lạt")),
            new Passenger("Nam", "sadsa","Ghế ngồi",List.of("Hà Nội-Hải Phòng","TP.HCM- Đà Lạt"))
    ));
    public List<Passenger> getPassengers(){
        return passengers;
    }
    public boolean addPassenger(Passenger passenger){
        return passengers.add(passenger);
    }
}
