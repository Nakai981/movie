package com.nuce.movie.repositories;

import com.nuce.movie.entity.Movie;
import com.nuce.movie.entity.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NationRepository extends JpaRepository<Nation,Integer> {

    @Query("select n from Nation n where n.status = true")
    List<Nation> getALlByStatus();

    @Query("select n from Nation n join n.movies m where n.status = true and m.id = ?1 ")
    Nation getNationByMovieId(int id);

    @Query("select n.nation_name from Nation n where n.status = true and n.id = ?1")
    String getNameByNationId(int id);

}
