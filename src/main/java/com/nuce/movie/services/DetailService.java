package com.nuce.movie.services;

import com.nuce.movie.entity.MovieDetail;

public interface DetailService {
    void setFollow(int movie_id, int name);

    void cancelFollow(int movie_id, int user_id);

    boolean checkFollow(int movie_id, int user_id);

    void rateFilm(int movie_id, int user_id, int rate);

    float getMovieDetail(int user_id, int movie_id);
}
