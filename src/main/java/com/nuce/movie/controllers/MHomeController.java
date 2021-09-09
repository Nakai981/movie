package com.nuce.movie.controllers;

import com.nuce.movie.entity.Category;
import com.nuce.movie.entity.Movie;
import com.nuce.movie.entity.Nation;
import com.nuce.movie.services.EpisodeService;
import com.nuce.movie.servicesImpl.CategoryServiceImpl;
import com.nuce.movie.servicesImpl.MovieServiceImpl;
import com.nuce.movie.servicesImpl.NationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
public class MHomeController {


    @Autowired private NationServiceImpl nationService;
    @Autowired private CategoryServiceImpl categoryService;
    @Autowired private MovieServiceImpl movieService;
    @Autowired private EpisodeService episodeService;


    @GetMapping(path = {"/home","/"})
    public String getHome(ModelMap modelMap) {
        //Header
        modelMap.addAttribute("categories",categoryService.getAllByStatus());
        modelMap.addAttribute("nations",nationService.getALlByStatus());

        //Nominated
        modelMap.addAttribute("movies_nominated",movieService.getAllByRate());

        // Movie new
        modelMap.addAttribute("movie_new",movieService.getAllByEpisodeNew());

        // Movie view
        modelMap.addAttribute("movie_view",movieService.getAllByView());

        //  Movie_nation
        modelMap.addAttribute("movie_nation",movieService.getAllByNation(3, PageRequest.of(0,6)));

        //  Movie_category_live
        modelMap.addAttribute("movie_category_live",movieService.getAllByCategories(9, PageRequest.of(0,6)));

        //  Movie_category_anime
        modelMap.addAttribute("movie_category_anime",movieService.getAllByCategories(7, PageRequest.of(0,6)));



        return "page/home";
    }


    @GetMapping("/systems")
    public String getSystem(){
        Random rand = new Random();
        int ranNum = rand.nextInt(movieService.getCountMovie())+1;
        return  "redirect:/information/"+ranNum;
    }


    public boolean isListMovie(List<Movie> m){
        if( m == null){
            return true;
        }
        return false;
    }

}
