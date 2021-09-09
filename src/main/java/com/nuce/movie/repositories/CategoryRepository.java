package com.nuce.movie.repositories;

import com.nuce.movie.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query("select c from Category c where c.status=true")
    List<Category> getAllByStatus();

    @Query("select c from Category c join c.movies m where c.status = true and m.id= ?1 ")
    List<Category> getAllByMovieId(int id);

    @Query("select c.category_name from Category c where c.status= true and c.id = ?1")
    public String getNameByCategoryId(int id);

    @Query("select c.category_name from Category c join c.movies m where c.status = true and m.id= ?1 ")
    List<String> getAllNameByMovieId(int id);
}
