package com.nuce.movie.controllers;

import com.nuce.movie.entity.Category;
import com.nuce.movie.entity.Movie;
import com.nuce.movie.repositories.CategoryRepository;
import com.nuce.movie.servicesImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AMovieController {

    @Autowired private MovieServiceImpl movieService;
    @Autowired private  NationServiceImpl nationService;
    @Autowired private CategoryServiceImpl categoryService;
    @Autowired private EpisodeServiceImpl episodeService;
    @Autowired private MessageServiceImpl messageService;
    @Autowired private ServerServiceImpl serverService;
    @Autowired private DetailServiceImpl detailService;

    @GetMapping("/admin/movie")
    public String getMovie(ModelMap modelMap){

        modelMap.addAttribute("movies",movieService.getAllMovie());
        modelMap.addAttribute("movie_sidebar", "table");
        modelMap.addAttribute("active", "movie");

        return "admin/movie";
    }
    @GetMapping("/admin/follow/nomination")
    public String followNomination(@RequestParam int id, HttpSession session){
        int user_id = (Integer)session.getAttribute("user_id");
        detailService.setNominate(id, user_id);
        movieService.setNominate(id,false);
        return "redirect:/admin/movie";
    }

    @GetMapping("/admin/cancel/nomination")
    public String cancelNomination( @RequestParam int id, HttpSession session){
        int user_id = (Integer)session.getAttribute("user_id");
        detailService.cancelNominate(id, user_id);
        movieService.setNominate(id,true);
        return "redirect:/admin/movie";
    }
    @GetMapping("/admin/movie/add")
    public String addMovie(ModelMap modelMap){


        modelMap.addAttribute("nations",nationService.getALlByStatus());
        modelMap.addAttribute("categories",categoryService.getAllByStatus());
        modelMap.addAttribute("movie",null);
        modelMap.addAttribute("movie_sidebar", "action-table");
        modelMap.addAttribute("active", "movie");
        return "admin/movie-add";
    }
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/admin/movie/save")
    public String saveUser(ModelMap modelMap,
                           @RequestParam int movie_id,
                           @RequestParam String movie_name,
                           @RequestParam String movie_image,
                           @RequestParam String movie_trailer,
                           @RequestParam String movie_comment,
                           @RequestParam String movie_year,
                           @RequestParam int movie_length,
                           @RequestParam String movie_type,
                           @RequestParam String movie_introduce,
                           @RequestParam int movie_nation,
                           @RequestParam int movie_total,
                           @RequestParam List<Integer> movie_category
    )throws Exception{

        movieService.saveMovie( movie_id,  movie_name,  movie_image,
                                movie_trailer,  movie_comment,  movie_year,
                                movie_length,  movie_type,  movie_nation,
                                 movie_category,  movie_total,  movie_introduce);

        if(movie_id != 0 ){
            return "redirect:/admin/movie";
        }
        return "redirect:/admin/movie/add";
    }

    @PostMapping("/admin/movie/status")
    public String setStatus(@RequestParam int movie_id, @RequestParam boolean movie_status){
        movieService.setStatus(movie_id,movie_status);
        return "redirect:/admin/movie";
    }

    @GetMapping("/admin/movie/edit")
    public String editStatus(ModelMap modelMap, @RequestParam int id){

        List<Category> categories = categoryService.getAllByStatus();
        List<Category> categories_select = categoryService.getAllByMovieId(id);
        for(Category c1 : categories){
            for (int i=0;i<categories_select.size();++i){
                if(c1.getId() == categories_select.get(i).getId()){
                    c1.setCheckbox(true);
                    categories_select.remove(i);
                }else{
                    c1.setCheckbox(false);
                }
            }

        }

        modelMap.addAttribute("nations",nationService.getALlByStatus());
        modelMap.addAttribute("categories",categories);
        modelMap.addAttribute("nation",nationService.getAllByMovieId(id));
        modelMap.addAttribute("movie",movieService.getMovieByMovieId(id));
        modelMap.addAttribute("movie_sidebar", "action-table");
        modelMap.addAttribute("active", "movie");
        return "admin/movie-add";
    }

    @GetMapping("/admin/movie/detail")
    public String getDetail(ModelMap modelMap, @RequestParam int id){

        modelMap.addAttribute("messages",null);
        modelMap.addAttribute("movie_id",id);
        modelMap.addAttribute("episode",null);
        modelMap.addAttribute("episodes",episodeService.getAllByMovieId(id));
        modelMap.addAttribute("movie_sidebar", "action-table");
        modelMap.addAttribute("active", "movie");
        return "admin/movie-detail";
    }

    @PostMapping("/admin/episode/save")
    public String saveNation(
            @RequestParam String episode_name,
            @RequestParam int episode_view,
            @RequestParam int episode_id,
            @RequestParam int movie_id
    ){
        episodeService.saveEpisode(movie_id,episode_id,episode_name,episode_view);
        return "redirect:/admin/movie/detail?id="+movie_id;
    }

    @PostMapping("/admin/episode/status")
    public String setStatusEpisode(@RequestParam int episode_id,
                                   @RequestParam boolean episode_status,@RequestParam int movie_id){
        episodeService.setStatus(episode_id,episode_status);
        return "redirect:/admin/movie/detail?id="+movie_id;
    }
    @GetMapping("/admin/episode/edit")
    public String editEpisode(ModelMap modelMap, @RequestParam int movie_id,@RequestParam int episode_id){

        modelMap.addAttribute("messages",null);
        modelMap.addAttribute("movie_id",movie_id);
        modelMap.addAttribute("episode",episodeService.getEpisodeByEpisodeId(episode_id));
        modelMap.addAttribute("episodes",episodeService.getAllByMovieId(movie_id));
        modelMap.addAttribute("movie_sidebar", "action-table");
        modelMap.addAttribute("active", "movie");
        return "admin/movie-detail";
    }

    @GetMapping("/admin/episode/delete")
    public String deleteNation(@RequestParam int movie_id, @RequestParam int episode_id){
        episodeService.deleteEpisode(episode_id);
        return "redirect:/admin/movie/detail?id="+movie_id;
    }

    @GetMapping("/admin/episode/server")
    public String getServer(ModelMap modelMap, @RequestParam int movie_id, @RequestParam int episode_id){

        modelMap.addAttribute("messages",messageService.getAllByEpisodeId(episode_id));
        modelMap.addAttribute("message",null);
        modelMap.addAttribute("servers",serverService.getAllServer());
        modelMap.addAttribute("movie_id",movie_id);
        modelMap.addAttribute("episode",episodeService.getEpisodeByEpisodeId(episode_id));
        modelMap.addAttribute("episodes",episodeService.getAllByMovieId(movie_id));
        modelMap.addAttribute("movie_sidebar", "action-table");
        modelMap.addAttribute("active", "movie");
        return "admin/movie-detail";
    }

    @PostMapping("/admin/episode/server/save")
    public String saveEpisodeServer(
            @RequestParam String episode_link,
            @RequestParam int episode_server,
            @RequestParam int movie_id,
            @RequestParam int message_id,
            @RequestParam int episode_id
    ){
        boolean check_selected = false;
        for(int i: serverService.getServerIdByEpisode(episode_id)){
            if(i == episode_server) check_selected = true;
        }
        if(!check_selected || message_id !=0)
        messageService.saveEpisodeServer(episode_server,episode_id,episode_link,message_id);
        return "redirect:/admin/episode/server?movie_id="+movie_id+"&episode_id="+episode_id;
    }
    @GetMapping("/admin/episode/server/edit")
    public String editServer(ModelMap modelMap, @RequestParam int movie_id,
                             @RequestParam int episode_id,
                             @RequestParam int message_id){

        modelMap.addAttribute("messages",messageService.getAllByEpisodeId(episode_id));
        modelMap.addAttribute("message",messageService.getMessageByMessageId(message_id));
        modelMap.addAttribute("servers",serverService.getAllServer());
        modelMap.addAttribute("server_list_select", serverService.getServerIdByEpisode(episode_id));
        modelMap.addAttribute("movie_id",movie_id);
        modelMap.addAttribute("episode",episodeService.getEpisodeByEpisodeId(episode_id));
        modelMap.addAttribute("episodes",episodeService.getAllByMovieId(movie_id));
        modelMap.addAttribute("movie_sidebar", "action-table");
        modelMap.addAttribute("active", "movie");

        return "admin/movie-detail";
    }

    @GetMapping("/admin/episode/server/delete")
    public String saveEpisodeServer(
            @RequestParam int movie_id,
            @RequestParam int episode_id,
            @RequestParam int message_id
    ){
        messageService.deleteMessage(message_id);
        return "redirect:/admin/episode/server?movie_id="+movie_id+"&episode_id="+episode_id;
    }

}
