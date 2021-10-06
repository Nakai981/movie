package com.nuce.movie.services;

import com.nuce.movie.entity.MovieDetail;

public interface DetailService {
    void setFollow(int movie_id, int name);

    void cancelFollow(int movie_id, int user_id);

    boolean checkFollow(int movie_id, int user_id);

    void setNominate(int movie_id, int user_id);

    void cancelNominate(int movie_id, int user_id);

    boolean checkNominate(int movie_id, int user_id);

    boolean getNominate(int movie_id);

    void rateFilm(int movie_id, int user_id, int rate);

    float getMovieDetail(int user_id, int movie_id);
}
