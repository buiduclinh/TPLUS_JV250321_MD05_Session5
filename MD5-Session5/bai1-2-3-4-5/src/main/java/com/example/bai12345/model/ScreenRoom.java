package com.example.bai12345.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ScreenRoom {
    private int id;
    private  String screenRoomName;
    private  int totalSeat;
}
