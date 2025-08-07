package com.example.bai12345.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Schedule {
    private int id;
    private int movieId;
    private String movieTitle;
    private LocalDate showTime;
    private int screenRoomId;
    private int availableSeats;
    private String format;
}
