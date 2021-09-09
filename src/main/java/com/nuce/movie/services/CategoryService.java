package com.nuce.movie.services;

import com.nuce.movie.entity.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryService {

    List<Category> getAllByStatus();

    List<Category> getAllByMovieId(int id);

    String getNameByCategoryId(int id);

    List<Category> getAllCategory();

    void saveCategory(int id, String name);

    Category getCategoryById(int id);

    void setStatus(int id, boolean status);

    void deleteCategory(int id);
}
