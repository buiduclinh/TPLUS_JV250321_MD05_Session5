package com.example.bai12345.dao.Impl;

import com.example.bai12345.dao.MovieDAO;
import com.example.bai12345.model.Movie;
import com.example.bai12345.util.DBConn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl implements MovieDAO {
    @Override
    public List<Movie> getMovies() {
        String sql = "{CALL get_all_movies()}";
        List<Movie> movieList = new ArrayList<>();
        try (Connection connection = DBConn.getInstance().getConnection();
             CallableStatement callStmt = connection.prepareCall(sql);) {
            ResultSet resultSet = callStmt.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setDescription(resultSet.getString("description"));
                movie.setDuration(resultSet.getInt("duration"));
                movie.setLanguage(resultSet.getString("language"));
                movieList.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    @Override
    public Movie getMovie(int id) {
        String sql = "{CALL get_movie_by_id(?)}";
        try (Connection connection = DBConn.getInstance().getConnection();
             CallableStatement callStmt = connection.prepareCall(sql);) {
            callStmt.setInt(1, id);
            ResultSet resultSet = callStmt.executeQuery();
            if (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setDescription(resultSet.getString("description"));
                movie.setDuration(resultSet.getInt("duration"));
                movie.setLanguage(resultSet.getString("language"));
                return movie;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addMovie(Movie movie) {
        String sql = "{CALL add_movie(?,?,?,?,?,?)}";
        try (Connection connection = DBConn.getInstance().getConnection();
             CallableStatement callStmt = connection.prepareCall(sql);) {
            callStmt.setString(1, movie.getTitle());
            callStmt.setString(2, movie.getDirector());
            callStmt.setString(3, movie.getGenre());
            callStmt.setString(4, movie.getDescription());
            callStmt.setInt(5, movie.getDuration());
            callStmt.setString(6, movie.getLanguage());
            int row = callStmt.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateMovie(Movie movie) {
        String sql = "{CALL update_movie(?,?,?,?,?,?)}";
        try (Connection connection = DBConn.getInstance().getConnection();
             CallableStatement callStmt = connection.prepareCall(sql);) {
            callStmt.setInt(1, movie.getId());
            callStmt.setString(2, movie.getTitle());
            callStmt.setString(3, movie.getDirector());
            callStmt.setString(4, movie.getGenre());
            callStmt.setString(5, movie.getDescription());
            callStmt.setInt(6, movie.getDuration());
            callStmt.setString(7, movie.getLanguage());
            int row = callStmt.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMovie(int id) {
        String sql = "{CALL delete_movie(?)}";
        try (Connection connection = DBConn.getInstance().getConnection();
             CallableStatement callStmt = connection.prepareCall(sql);) {
            callStmt.setInt(1, id);
            int row = callStmt.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Movie getMovie(String title) {
        String sql = "{CALL get_movie_by_title(?)}";
        try (Connection connection = DBConn.getInstance().getConnection();
             CallableStatement callStmt = connection.prepareCall(sql);) {
            callStmt.setString(1, title);
            ResultSet resultSet = callStmt.executeQuery();
            if (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setDescription(resultSet.getString("description"));
                movie.setDuration(resultSet.getInt("duration"));
                movie.setLanguage(resultSet.getString("language"));
                return movie;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
