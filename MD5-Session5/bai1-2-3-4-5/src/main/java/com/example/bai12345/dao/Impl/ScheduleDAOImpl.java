package com.example.bai12345.dao.Impl;

import com.example.bai12345.dao.ScheduleDAO;
import com.example.bai12345.model.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ScheduleDAOImpl implements ScheduleDAO {
    @Override
    public List<Schedule> getSchedules() {
        return List.of();
    }

    @Override
    public boolean addSchedule(Schedule schedule) {
        return false;
    }

    @Override
    public boolean updateSchedule(Schedule schedule) {
        return false;
    }

    @Override
    public boolean deleteSchedule(Schedule schedule) {
        return false;
    }
}
