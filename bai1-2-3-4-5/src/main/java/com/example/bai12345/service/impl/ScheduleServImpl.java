package com.example.bai12345.service.impl;

import com.example.bai12345.dao.ScheduleDAO;
import com.example.bai12345.model.Schedule;
import com.example.bai12345.service.ScheduleIServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServImpl implements ScheduleIServ {
    @Autowired
    ScheduleDAO scheduleDAO;

    @Override
    public List<Schedule> getSchedules() {
        return scheduleDAO.getSchedules();
    }

    @Override
    public boolean addSchedule(Schedule schedule) {
        return scheduleDAO.addSchedule(schedule);
    }

    @Override
    public boolean updateSchedule(Schedule schedule) {
        return scheduleDAO.updateSchedule(schedule);
    }

    @Override
    public boolean deleteSchedule(Schedule schedule) {
        return scheduleDAO.deleteSchedule(schedule);
    }
}
