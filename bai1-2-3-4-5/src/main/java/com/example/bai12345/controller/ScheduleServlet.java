package com.example.bai12345.controller;

import com.example.bai12345.model.Schedule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/ScheduleServlet")
public class ScheduleServlet {
    @GetMapping
    public String getSchedules(Model model) {
        List<Schedule> schedules = List.of(new Schedule());
        model.addAttribute("schedules", schedules);
        return "listSchedules";
    }
}
