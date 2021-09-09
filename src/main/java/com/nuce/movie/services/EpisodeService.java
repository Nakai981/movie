package com.nuce.movie.services;

import com.nuce.movie.entity.Episode;

import java.util.List;

public interface EpisodeService {
    List<Episode> getAllByMovieId(int id);

    String onNext(int id);

    String onPrevious(int id);

    Episode getEpisodeByEpisodeId(int id);

    void countView(int id);



    void saveEpisode(int movie_id, int episode_id, String episode_name, int episode_view);
    void setStatus(int episode_id,boolean episode_status);
    void deleteEpisode(int episode_id);
}
