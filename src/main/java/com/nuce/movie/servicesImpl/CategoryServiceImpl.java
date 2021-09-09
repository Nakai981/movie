package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.Category;
import com.nuce.movie.repositories.CategoryRepository;
import com.nuce.movie.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllByStatus(){
        return categoryRepository.getAllByStatus();
    }

    @Override
    public List<Category> getAllByMovieId(int id){
        return categoryRepository.getAllByMovieId(id);
    }

    @Override
    public String getNameByCategoryId(int id){
        return categoryRepository.getNameByCategoryId(id);
    }


    //Admin

    @Override
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(int id, String name){
        Category c = new Category();
        c.setCategory_name(name);
        c.setStatus(true);
        if (id !=0 ){
            c.setId(id);
        }
        categoryRepository.save(c);
    }
    @Override
    public Category getCategoryById(int id){
        return categoryRepository.findById(id).get();
    }

    @Override
    public void setStatus(int id, boolean status){
        Category c = this.getCategoryById(id);
        if(status == true){
            c.setStatus(false);
        }else c.setStatus(true);
        categoryRepository.save(c);
    }

    @Override
    public void deleteCategory(int id){
        Category c = this.getCategoryById(id);
        c.getMovies().removeAll(c.getMovies());
        categoryRepository.delete(c);
    }
}
