package com.example.bai12345.service;


import com.example.bai12345.model.Schedule;

import java.util.List;

public interface ScheduleIServ {
    List<Schedule> getSchedules();

    boolean addSchedule(Schedule schedule);

    boolean updateSchedule(Schedule schedule);

    boolean deleteSchedule(Schedule schedule);
}
