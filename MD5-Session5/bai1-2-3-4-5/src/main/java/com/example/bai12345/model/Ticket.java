package com.example.bai12345.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {
    private  int id;
    private int customerId;
    private  int scheduleId;
    private String seatName;
    private  Double totalMoney;
    private  LocalDate createdAt;
}
