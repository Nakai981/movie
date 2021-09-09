package com.nuce.movie.repositories;

import com.nuce.movie.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {

    @Query("select e from Episode e join e.movie m where m.status=true and m.id= ?1")
    List<Episode> getAllByMovieId(int id);

}
