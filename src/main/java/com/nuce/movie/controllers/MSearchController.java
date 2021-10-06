package com.nuce.movie.controllers;

import com.nuce.movie.entity.Advertisement;
import com.nuce.movie.entity.Category;
import com.nuce.movie.entity.Movie;
import com.nuce.movie.entity.Nation;
import com.nuce.movie.servicesImpl.CategoryServiceImpl;
import com.nuce.movie.servicesImpl.MovieServiceImpl;
import com.nuce.movie.servicesImpl.NationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MSearchController {
    @Autowired
    private NationServiceImpl nationService;
    @Autowired private CategoryServiceImpl categoryService;
    @Autowired private MovieServiceImpl movieService;

    private List<Nation> nations;
    private List<Category> categories;
    private List<Movie> movies;

    @GetMapping("/category/{id}")
    public String getCategory(ModelMap modelMap, @PathVariable int id){
        //Header
        if(isCategoryAndNation()){
            this.categories = categoryService.getAllByStatus();
            this.nations = nationService.getALlByStatus();
        }
        modelMap.addAttribute("categories",categories);
        modelMap.addAttribute("nations",nations);

        movies = movieService.getAllByCategories(id, PageRequest.of(0,8));
        modelMap.addAttribute("movies",movies);
        modelMap.addAttribute("filmStatus","category");
        modelMap.addAttribute("filmName",categoryService.getNameByCategoryId(id));

        return "page/film";
    }

    @GetMapping("/nation/{id}")
    public String getNation(ModelMap modelMap, @PathVariable int id){
        //Header
        if(isCategoryAndNation()){
            this.categories = categoryService.getAllByStatus();
            this.nations = nationService.getALlByStatus();
        }
        modelMap.addAttribute("categories",categories);
        modelMap.addAttribute("nations",nations);

        movies = movieService.getAllByNation(id, PageRequest.of(0,8));
        modelMap.addAttribute("movies",movies);
        modelMap.addAttribute("filmStatus","nation");
        modelMap.addAttribute("filmName",nationService.getNameByNationId(id));

        return "page/film";
    }

    @GetMapping("/type/{name}")
    public String getTypeMovie(ModelMap modelMap, @PathVariable String name){
        //Header
        if(isCategoryAndNation()){
            this.categories = categoryService.getAllByStatus();
            this.nations = nationService.getALlByStatus();
        }
        modelMap.addAttribute("categories",categories);
        modelMap.addAttribute("nations",nations);

        movies = movieService.getAllByMovieType(name, PageRequest.of(0,8));
        modelMap.addAttribute("movies",movies);
        modelMap.addAttribute("filmStatus","type");
        modelMap.addAttribute("filmName",name);

        return "page/film";
    }


    @GetMapping("/film/search")
    public String searchAdvanced(ModelMap modelMap, @RequestParam int nation, @RequestParam int category, @RequestParam String type){
        //Header
        if(isCategoryAndNation()){
            this.categories = categoryService.getAllByStatus();
            this.nations = nationService.getALlByStatus();
        }
        modelMap.addAttribute("categories",categories);
        modelMap.addAttribute("nations",nations);

        movies = movieService.getAllByCNT(category,nation,type, PageRequest.of(0,8));
        modelMap.addAttribute("movies",movies);

        modelMap.addAttribute("filmName",nationService.getNameByNationId(nation)
                +" "+categoryService.getNameByCategoryId(category)+" "+type);
        modelMap.addAttribute("filmStatus","all");

        return "page/film";
    }

    public boolean isCategoryAndNation(){
        if(nations == null && categories == null) return true;
        return false;
    }

    @GetMapping("/api/search/{name}")
    @ResponseBody
    public ResponseEntity<List<Movie>> getAdvertisementVideo(@PathVariable String name){
        return new ResponseEntity<>(movieService.getAllByMovieName(name), HttpStatus.OK);
    }




}
