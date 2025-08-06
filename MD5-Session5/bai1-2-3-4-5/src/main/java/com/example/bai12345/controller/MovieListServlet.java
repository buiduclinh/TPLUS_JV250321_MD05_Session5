package com.example.bai12345.controller;

import com.example.bai12345.dao.CustomerDAO;
import com.example.bai12345.dao.Impl.CustomerDAOImpl;
import com.example.bai12345.dao.Impl.MovieDAOImpl;
import com.example.bai12345.dao.MovieDAO;
import com.example.bai12345.model.Customer;
import com.example.bai12345.model.Movie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/MovieListServlet")
public class MovieListServlet extends HttpServlet {
    MovieDAO movieDAO;

    public MovieListServlet() {
        movieDAO = new MovieDAOImpl();
    }

    public void getAllMovies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Movie> movieList = movieDAO.getMovies();
        request.setAttribute("movieList", movieList);
        request.getRequestDispatcher("view/listMovie.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("getAllMovies")) {
            getAllMovies(request, response);
        } else if (action.equals("getMovie")) {
            String title = request.getParameter("title");
            Movie movie = movieDAO.getMovie(title);
            if (movie != null) {
                request.setAttribute("movie", movie);
                request.getRequestDispatcher("view/updateMovie.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("view/error.jsp").forward(request, response);
            }
        } else if (action.equals("deleteMovie")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Movie movie = movieDAO.getMovie(id);
            if (movie != null) {
                boolean result = movieDAO.deleteMovie(id);
                if (result) {
                    getAllMovies(request, response);
                } else {
                    request.getRequestDispatcher("view/error.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("view/error.jsp").forward(request, response);
            }
        } else if (action.equals("getMovieById")) {
            int movieId = Integer.parseInt(request.getParameter("id"));
            Movie movie = movieDAO.getMovie(movieId);
            if (movie != null) {
                request.setAttribute("movie", movie);
                request.getRequestDispatcher("view/updateMovie.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("view/error.jsp").forward(request, response);
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action không hợp lệ");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("addMovie")) {
            Movie movie = new Movie();
            movie.setTitle(request.getParameter("title"));
            movie.setDirector(request.getParameter("director"));
            movie.setGenre(request.getParameter("genre"));
            movie.setDescription(request.getParameter("description"));
            movie.setDuration(Integer.parseInt(request.getParameter("duration")));
            movie.setLanguage(request.getParameter("language"));
            boolean isAdd = movieDAO.addMovie(movie);
            if (isAdd) {
                getAllMovies(request, response);
            } else {
                request.getRequestDispatcher("view/error.jsp").forward(request, response);
            }
        } else if (action.equals("updateMovie")) {
            Movie movie = new Movie();
            request.setAttribute("movie", movie);
            movie.setId(Integer.parseInt(request.getParameter("id")));
            movie.setTitle(request.getParameter("title"));
            movie.setDirector(request.getParameter("director"));
            movie.setGenre(request.getParameter("genre"));
            movie.setDescription(request.getParameter("description"));
            movie.setDuration(Integer.parseInt(request.getParameter("duration")));
            movie.setLanguage(request.getParameter("language"));
            boolean isUpdate = movieDAO.updateMovie(movie);
            if (isUpdate) {
                getAllMovies(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action không hợp lệ");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action không hợp lệ");
        }
    }
}
