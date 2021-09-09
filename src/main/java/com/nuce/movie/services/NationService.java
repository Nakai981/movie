package com.nuce.movie.services;

import com.nuce.movie.entity.Movie;
import com.nuce.movie.entity.Nation;

import java.util.List;

public interface NationService {

    List<Nation> getALlByStatus();

    Nation getAllByMovieId(int id);

    List<Nation> getAllNation();

    void setStatus(int id, boolean status);

    String getNameByNationId(int id);

    void saveNation(int id, String name);

    Nation getNationById(int nation_id);

    void deleteNation(int id);
}
