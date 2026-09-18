package com.ngviet291.nguyentranquocviet_23660721_bai05.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Passenger {
    private String passengerName;
    private String password;
    private String seatType;
    private List<String> route;
}
