package com.nuce.movie.repositories;

import com.nuce.movie.entity.Movie;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("select avg(md.rate) from Movie m join m.movieDetails md where m.id = ?1 and md.rate>0")
    String getRateByMovieId(int id);

    @Query("select sum(e.episode_view) from Movie m join m.episodes e where m.id= ?1")
    String getViewByMovieId(int id);

    @Query("select count(e.id) from Movie m join m.episodes e where m.id = ?1")
    int getNumByMovieId(int id);

    @Query("select m " +
            "from Movie m left join m.movieDetails md where m.status = true and md.nominations = true group by (m.id) order by md.id desc ")
    List<Movie> getAllByRate(PageRequest pageRequest);

    @Query("select m from Movie m left join m.episodes e where m.status = true group by (m.id) "+
            "order by max(e.id) desc ")
    List<Movie> getAllByEpisodeNew(PageRequest pageRequest);

    @Query("select m from Movie m left join m.episodes e where m.status = true group by (m.id) order by e.episode_view desc ")
    List<Movie> getAllByView(PageRequest pageRequest);

    @Query("select m from Nation n join n.movies m where n.id=?1 and n.status=true")
    List<Movie> getAllByNationId(int id, PageRequest pageRequest);

    @Query("select m from Movie m join m.categories c where m.status = true and c.id=?1 group by (m.id)")
    List<Movie> getAllByCategories(int id, PageRequest pageRequest);

    @Query("select m from Movie m where m.status = true and m.movie_type = ?1")
    List<Movie> getAllByMovieType(String name, PageRequest pageRequest);


    @Query("select m from Category c join c.movies m join m.nation n where m.status = true and c.id=?1 and n.id=?2 and m.movie_type=?3 group by (m.id)")
    List<Movie> getAllByCTN(int category_id, int nation_id, String name, PageRequest pageRequest);

    @Query("select count(m.id) from Movie m where m.status=true")
    int getCountMovie();

    @Query("select m.id from Movie m join m.episodes e where e.id = ?1")
    int getMovieByEpisodeId(int id);

    @Query("select m " +
            "from Movie m join m.movieDetails md where m.status = true and md.user.id=?1 and md.follow= true")
    List<Movie> getAllByUserId(int id,PageRequest pageRequest);

    @Query("select m from Movie m where m.status = true and m.movie_name LIKE CONCAT('%',?1,'%')")
    List<Movie> getAllByMovieName(String name,PageRequest pageRequest);
}
