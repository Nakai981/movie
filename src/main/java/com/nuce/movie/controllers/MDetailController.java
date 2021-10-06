package com.nuce.movie.controllers;

import com.nuce.movie.entity.*;
import com.nuce.movie.services.DetailService;
import com.nuce.movie.services.EpisodeService;
import com.nuce.movie.services.ServerService;
import com.nuce.movie.services.UserService;
import com.nuce.movie.servicesImpl.CategoryServiceImpl;
import com.nuce.movie.servicesImpl.MessageServiceImpl;
import com.nuce.movie.servicesImpl.MovieServiceImpl;
import com.nuce.movie.servicesImpl.NationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;

@Controller
public class MDetailController {

    @Autowired private  NationServiceImpl nationService;
    @Autowired private  CategoryServiceImpl categoryService;
    @Autowired private  MovieServiceImpl movieService;
    @Autowired private  EpisodeService episodeService;
    @Autowired private ServerService serverService;
    @Autowired private MessageServiceImpl messageService;
    @Autowired private DetailService detailService;

    private List<Nation> nations;
    private List<Category> categories;
    private String rate_detail, view_detail, episode_detail;
    private Movie movie_detail;
    private Nation nation_detail;
    private List<Category> category_detail;
    private List<Episode> episodes_detail_list;
    private List<Movie> movie_nation;
    private List<Server> server_detail;


    @GetMapping("/information/{id}")
    public String getDetail(ModelMap modelMap,@PathVariable int id,  HttpSession session) {

        //Header
        getCategoryAndNation(modelMap);

        //Body
        this.getDetailMovie(id);

        if(episodes_detail_list.size() !=0 ){
            server_detail = serverService.getAllByEpisodeId(episodes_detail_list.get(0).getId());
        }else{
            server_detail = serverService.getAllByEpisodeId(0);
        }

        if(server_detail.size() == 0 || server_detail.get(0).getId() == 0){
            modelMap.addAttribute("server",0);
        }else{
            modelMap.addAttribute("server",1);
        }

        // Session - episode

            @SuppressWarnings("unchecked")
            HashMap<Integer, HashSet<Integer>> movie_session =(HashMap<Integer,HashSet<Integer>>) session.getAttribute("MOVIE_LIST");

            if(movie_session == null){
                movie_session = new HashMap<>();
            }

            HashSet<Integer> episode_hashmap = movie_session.get(id);
            if(movie_session.get(id) == null){
                episode_hashmap = new HashSet<>();
            }

            movie_session.put(id,episode_hashmap);

            session.setAttribute("MOVIE_LIST",movie_session);

            for(Integer i: movie_session.get(id)){
                for(Episode e: episodes_detail_list){
                    if(e.getId() == i){
                        e.setCheck_session(true);
                    }
                }
            }

        //follow
        String name = (String)session.getAttribute("name");
        if(name != null){
            int user_session_id = (int)session.getAttribute("user_id");

            boolean checkFollow= detailService.checkFollow(id,user_session_id);
            if(checkFollow){
                modelMap.addAttribute("follow","active");
            }else{
                modelMap.addAttribute("follow","non_active");
            }
            modelMap.addAttribute("follow_page",String.valueOf(id));
            modelMap.addAttribute("num_rate_user",detailService.getMovieDetail(user_session_id,id));

        }
//        Nomination
        if(name != null){
            String position = (String)session.getAttribute("position");
            if(position.equals("4")){
                int user_session_id = (int)session.getAttribute("user_id");
                boolean checkNominate = detailService.checkNominate(id,user_session_id);
                if(checkNominate){
                    modelMap.addAttribute("nomination","active");

                }else{
                    modelMap.addAttribute("nomination","non_active");
                }
                modelMap.addAttribute("nomination_page",String.valueOf(id));
            }

        }
        //Body

        modelMap.addAttribute("movie_detail",movie_detail);
        modelMap.addAttribute("rate",rate_detail);
        modelMap.addAttribute("view",view_detail);
        modelMap.addAttribute("episode",episode_detail);
        modelMap.addAttribute("nation",nation_detail);
        modelMap.addAttribute("category", category_detail);
        modelMap.addAttribute("episodes",episodes_detail_list);
        modelMap.addAttribute("movie_nation",movie_nation);
        modelMap.addAttribute("episode_id",0);
        return "page/film-infor";
    }

    @PostMapping("/information/follow/{user_id}/{movie_id}/{rate}")
    @ResponseBody
    public String rateFilm(@PathVariable int user_id, @PathVariable int rate, @PathVariable int movie_id){
        detailService.rateFilm(movie_id,user_id, rate);
        return "abv";
    }

    @PostMapping("/information/number/{movie_id}")
    @ResponseBody
    public String numberRateFilm(@PathVariable int movie_id){
        return movieService.getRateByMovieId(movie_id);
    }

    @GetMapping("/information/follow")
    public String followFilm(@RequestParam int user_id, @RequestParam int id, @RequestParam String page){
        detailService.setFollow(id, user_id);
        return "redirect:/information/"+page;
    }

    @GetMapping("/information/cancelfollow")
    public String cancelFollowFilm(@RequestParam int user_id, @RequestParam int id, @RequestParam String page){
        detailService.cancelFollow(id, user_id);
        return "redirect:/information/"+page;
    }

    @GetMapping("/information/nomination")
    public String followNomination(@RequestParam int user_id, @RequestParam int id, @RequestParam String page){
        detailService.setNominate(id, user_id);
        return "redirect:/information/"+page;
    }

    @GetMapping("/information/cancelnomination")
    public String cancelNomination(@RequestParam int user_id, @RequestParam int id, @RequestParam String page){
        detailService.cancelNominate(id, user_id);
        return "redirect:/information/"+page;
    }



    @RequestMapping("/information/{movie_id}/{episode_id}/{server_id}")
    public String getMovie(ModelMap modelMap,
                           @PathVariable int movie_id,
                           @PathVariable int episode_id,
                           @PathVariable int server_id,
                            HttpSession session
                           ) {

        //Header
        getCategoryAndNation(modelMap);
        this.getDetailMovie(movie_id);

        server_detail = serverService.getAllByEpisodeId(episode_id);
        if(server_id == 1){
            server_id = server_detail.get(0).getId();
        }
        if(server_detail.size() == 0 || server_detail.get(0).getId() == 0){
            modelMap.addAttribute("server",0);
        }else{
            modelMap.addAttribute("server",1);
            // Server by Episode
            modelMap.addAttribute("servers",server_detail);
            modelMap.addAttribute("server_id",server_id);

        }

        //Movie
        Boolean status = true;
        modelMap.addAttribute("status",status);
        modelMap.addAttribute("server_load",serverService.getServerByServerId(server_detail,server_id));
        modelMap.addAttribute("server_link",serverService.getServerBySEId(server_id,episode_id));
        modelMap.addAttribute("onNext",episodeService.onNext(episode_id));
        modelMap.addAttribute("onPrevious",episodeService.onPrevious(episode_id));

        // Session
        @SuppressWarnings("unchecked")
        HashMap<Integer, HashSet<Integer>> movie_session =(HashMap<Integer,HashSet<Integer>>) session.getAttribute("MOVIE_LIST");

        if(movie_session == null){
            movie_session = new HashMap<>();
        }

        HashSet<Integer> episode_hashmap = movie_session.get(movie_id);
        if(movie_session.get(movie_id) == null){
             episode_hashmap = new HashSet<>();
        }

        episode_hashmap.add(episode_id);
        movie_session.put(movie_id,episode_hashmap);

        session.setAttribute("MOVIE_LIST",movie_session);
        for(Integer i: movie_session.get(movie_id)){
            for(Episode e: episodes_detail_list){
                if(e.getId() == i){
                    e.setCheck_session(true);
                }
            }
        }


        //Set view
        episodeService.countView(episode_id);

        //follow
        String name = (String)session.getAttribute("name");
        if(name != null){
            int user_session_id = (int)session.getAttribute("user_id");
            boolean checkFollow= detailService.checkFollow(movie_id,user_session_id);
            if(checkFollow){
                modelMap.addAttribute("follow","active");

            }else{
                modelMap.addAttribute("follow","non_active");
            }
            String url = String.valueOf(movie_id)+"/"+String.valueOf(episode_id)+"/"+String.valueOf(server_id);
            modelMap.addAttribute("follow_page",url);
            modelMap.addAttribute("num_rate_user",detailService.getMovieDetail(user_session_id,movie_id));

        }
        if(name != null){
            String position = (String)session.getAttribute("position");
            if(position.equals("4")){
                int user_session_id = (int)session.getAttribute("user_id");
                boolean checkNominate = detailService.checkNominate(movie_id,user_session_id);
                if(checkNominate){
                    modelMap.addAttribute("nomination","active");

                }else{
                    modelMap.addAttribute("nomination","non_active");
                }
                String url = String.valueOf(movie_id)+"/"+String.valueOf(episode_id)+"/"+String.valueOf(server_id);
                modelMap.addAttribute("nomination_page",url);
            }

        }


        //Body
        modelMap.addAttribute("movie_detail",movie_detail);
        modelMap.addAttribute("rate",rate_detail);
        modelMap.addAttribute("view",view_detail);
        modelMap.addAttribute("episode",episode_detail);
        modelMap.addAttribute("nation",nation_detail);
        modelMap.addAttribute("category", category_detail);
        modelMap.addAttribute("episodes",episodes_detail_list);
        modelMap.addAttribute("movie_nation",movie_nation);
        modelMap.addAttribute("episode_id",episode_id);

        modelMap.addAttribute("message", messageService.getStatus(episode_id,server_id));
        return "page/film-infor";
    }

    public void getDetailMovie(int id){
        //Information Film
        movie_detail = movieService.getMovieByMovieId(id);

        // Rate Film
        rate_detail = movieService.getRateByMovieId(id);

        // View Film
        view_detail = movieService.getViewByMovieId(id);

        // Episode num film
        episode_detail = movieService.getNumByMovieId(id);

        // Nation
        nation_detail = nationService.getAllByMovieId(id);

        // Category
        category_detail = categoryService.getAllByMovieId(id);

        //EpisodeList
        episodes_detail_list = episodeService.getAllByMovieId(id);

        //Movie by nation
        movie_nation = movieService.getAllByNation(nation_detail.getId(),movie_detail.getId(),PageRequest.of(0,12));


    }

    @GetMapping("/information/error")
    public String hadlingError(@RequestParam String episodeId, @RequestParam String serverId){
        messageService.setStatus(Integer.valueOf(episodeId),Integer.valueOf(serverId));
        int movie_id = movieService.getMovieByEpisodeId(Integer.valueOf(episodeId));
        String movie_str = String.valueOf(movie_id);
        String str = "redirect:/information/"+movie_str+"/"+episodeId+"/"+serverId;
        return str;
    }

    public void getCategoryAndNation(ModelMap modelMap){

        this.categories = categoryService.getAllByStatus();
        this.nations = nationService.getALlByStatus();

        modelMap.addAttribute("categories",categories);
        modelMap.addAttribute("nations",nations);
    }

}
