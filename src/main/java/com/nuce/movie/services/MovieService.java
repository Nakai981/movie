package com.nuce.movie.services;

import com.nuce.movie.entity.Movie;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface MovieService {


    //    Get list movie by sorting rate
    List<Movie> getAllByRate();

    //    Get list movie by episode new
    List<Movie> getAllByEpisodeNew();

    //    Get list movie by sorting view
    List<Movie> getAllByView();

    //    Get list movie by nation id
    List<Movie> getAllByNation(int id, PageRequest p);

    //    get list movie by nation id - movie_id
    List<Movie> getAllByNation(int id, int movie_id, PageRequest p);

    //    Get list movie by category
    List<Movie> getAllByCategories(int id, PageRequest pageRequest);


    List<Movie> getAllByMovieType(String name, PageRequest pageRequest);

    List<Movie> getAllByCNT(int category_id, int nation_id, String name, PageRequest pageRequest);

    List<Movie> getAllByUserId(int id, PageRequest pageRequest);

    int getCountMovie();

    int getMovieByEpisodeId(int id);

    // Admin
    List<Movie> getAllMovie();

    void saveMovie(int movie_id, String movie_name, String movie_image,
                   String movie_trailer, String movie_comment, String movie_year,
                   int movie_length, String movie_type, int movie_nation,
                   List<Integer> movie_category,int movie_total, String movie_introduce) throws Exception;

    void setStatus(int id, boolean status);

    List<Movie> getAllByMovieName(String name);

    Movie getMovieByMovieId(int id);

    void setNominate(int id, boolean status);
}
