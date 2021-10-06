package com.nuce.movie.repositories;

import com.nuce.movie.entity.MovieDetail;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetailRepository extends JpaRepository<MovieDetail, Integer> {
    @Query("select d from MovieDetail d where d.movie.status= true and d.user.status=true and d.movie.id=?1 and d.user.id=?2")
    MovieDetail setFollow(int movie_id, int user_id);

    @Query("select d from MovieDetail d where d.follow = true and d.movie.id=?1 and d.user.id=?2")
    MovieDetail checkFollow(int movie_id, int user_id);

    @Query("select d from MovieDetail d where d.movie.id=?1 and d.user.id=?2")
    MovieDetail getDetailByMUId(int movie_id, int user_id);


    @Query("select d from MovieDetail d where d.nominations = true and d.movie.id=?1 and d.user.id=?2")
    MovieDetail checkNominate(int movie_id, int user_id);

    @Query("select d from MovieDetail d where d.nominations = true and d.movie.id=?1")
    MovieDetail getNominate(int movie_id, PageRequest pageRequest);
}
