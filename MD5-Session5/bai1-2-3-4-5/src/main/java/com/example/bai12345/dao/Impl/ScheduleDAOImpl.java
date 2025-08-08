package com.example.bai12345.dao.Impl;

import com.example.bai12345.dao.ScheduleDAO;
import com.example.bai12345.model.Schedule;
import com.example.bai12345.util.DBConn;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {
    @Override
    public List<Schedule> getSchedules() {
        String sql = "{CALL get_all_schedule()}";
        List<Schedule> schedules = new ArrayList<>();
        try (Connection connection = DBConn.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql);) {
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getInt("id"));
                schedule.setMovieId(resultSet.getInt("movie_id"));
                schedule.setMovieTitle(resultSet.getString("movie_title"));
                schedule.setScreenRoomId(resultSet.getInt("screen_room_id"));
                schedule.setAvailableSeats(resultSet.getInt("available_seats"));
                schedule.setFormat(resultSet.getString("format"));
                schedule.setShowTime(LocalDate.parse(resultSet.getString("show_time")));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }

    @Override
    public boolean addSchedule(Schedule schedule) {
        String sql = "{CALL add_schedule(?,?,?,?,?)}";
        try (Connection connection = DBConn.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql);) {
            callableStatement.setInt(1, schedule.getMovieId());
            callableStatement.setDate(2, Date.valueOf(schedule.getShowTime()));
            callableStatement.setInt(3, schedule.getScreenRoomId());
            callableStatement.setInt(4, schedule.getAvailableSeats());
            callableStatement.setString(5, schedule.getFormat());

            int row = callableStatement.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateSchedule(Schedule schedule) {
        String sql = "{CALL update_schedule(?,?,?,?,?,?)}";
        try (Connection connection = DBConn.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql);) {
            callableStatement.setInt(1, schedule.getId());
            callableStatement.setInt(2, schedule.getMovieId());
            callableStatement.setDate(3, Date.valueOf(schedule.getShowTime()));
            callableStatement.setInt(4, schedule.getScreenRoomId());
            callableStatement.setInt(5, schedule.getAvailableSeats());
            callableStatement.setString(6, schedule.getFormat());
            int row = callableStatement.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteSchedule(Schedule schedule) {
        String sql = "{CALL delete_schedule(?)}";
        try (Connection connection = DBConn.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql);) {
            callableStatement.setInt(1, schedule.getId());
            int row = callableStatement.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
