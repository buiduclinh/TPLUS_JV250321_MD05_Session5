package com.example.bai12345.controller;

import com.example.bai12345.dao.ScheduleDAO;
import com.example.bai12345.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/ScheduleServlet")
public class ScheduleServlet {
    @Autowired
    ScheduleDAO scheduleDAO;

    @GetMapping
    public String getSchedules(Model model) {
        List<Schedule> schedules = scheduleDAO.getSchedules();
        model.addAttribute("schedules", schedules);
        return "listSchedule";
    }

    @GetMapping("/addSchedule")
    public String addSchedule(Model model) {
        model.addAttribute("schedule", new Schedule());
        return "addSchedule";
    }

    @PostMapping("/addSchedule")
    public String addSchedule(@ModelAttribute Schedule schedule) {
        scheduleDAO.addSchedule(schedule);
        return "redirect:/ScheduleServlet";
    }
}
