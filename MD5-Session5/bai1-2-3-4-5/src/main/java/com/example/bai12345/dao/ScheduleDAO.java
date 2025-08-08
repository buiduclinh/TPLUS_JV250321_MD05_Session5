package com.example.bai12345.dao;

import com.example.bai12345.model.Schedule;

import java.util.List;

public interface ScheduleDAO {
    List<Schedule> getSchedules();

    boolean addSchedule(Schedule schedule);

    boolean updateSchedule(Schedule schedule);

    boolean deleteSchedule(Schedule schedule);
}
