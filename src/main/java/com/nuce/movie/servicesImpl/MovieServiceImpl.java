package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.*;
import com.nuce.movie.repositories.CategoryRepository;
import com.nuce.movie.repositories.MovieRepository;
import com.nuce.movie.repositories.NationRepository;
import com.nuce.movie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    NationRepository nationRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    DetailServiceImpl detailService;


//    Get list movie by sorting rate
    @Override
    public List<Movie> getAllByRate(){
        List<Movie> movies_nominated = movieRepository.getAllByRate(PageRequest.of(0,12));
        this.setPropertiesMovie(movies_nominated);
        return movies_nominated;
    }

//    Get list movie by episode new
    @Override
    public List<Movie> getAllByEpisodeNew(){
        List<Movie> movie_new = movieRepository.getAllByEpisodeNew(PageRequest.of(0,12));
        this.setPropertiesMovie(movie_new);
        return movie_new;
    }

//    Get list movie by sorting view
    @Override
    public List<Movie> getAllByView(){
        List<Movie> movie_view = movieRepository.getAllByView(PageRequest.of(0,6));
        this.setPropertiesMovie(movie_view);
        return movie_view;
    }

//    Get list movie by nation id
    @Override
    public List<Movie> getAllByNation(int id, PageRequest p){
        List<Movie> movie_nation = movieRepository.getAllByNationId(id,p);
        this.setPropertiesMovie(movie_nation);
        return movie_nation;
    }

//    get list movie by nation id - movie_id
    @Override
    public List<Movie> getAllByNation(int id, int movie_id, PageRequest p){
        List<Movie> movie_nation = movieRepository.getAllByNationId(id,p);
        for (int i = 0; i < movie_nation.size(); i++){
            if(movie_nation.get(i).getId() == movie_id) {
                movie_nation.remove(i);
            }
        }
        this.setPropertiesMovie(movie_nation);
        return movie_nation;
    }

//    Get list movie by category
    @Override
    public List<Movie> getAllByCategories(int id, PageRequest pageRequest){
        List<Movie> movie_category = movieRepository.getAllByCategories(id,pageRequest);
        this.setPropertiesMovie(movie_category);
        return movie_category;
    }

    @Override
    public List<Movie> getAllByMovieType(String name, PageRequest pageRequest){
        List<Movie> movie_type = movieRepository.getAllByMovieType(name, pageRequest);
        this.setPropertiesMovie(movie_type);
        return movie_type;
    }

    @Override
    public List<Movie> getAllByCNT(int category_id, int nation_id, String name, PageRequest pageRequest){
        List<Movie> movie_cnt = movieRepository.getAllByCTN(category_id,nation_id,name, pageRequest);
        this.setPropertiesMovie(movie_cnt);
        return movie_cnt;
    }
    @Override
    public List<Movie> getAllByUserId(int id, PageRequest pageRequest){
        List<Movie> movie_user_id = movieRepository.getAllByUserId(id, pageRequest);
        this.setPropertiesMovie(movie_user_id);
        return movie_user_id;
    }

    @Override
    public int getCountMovie(){
        return movieRepository.getCountMovie();
    }

    @Override
    public List<Movie> getAllByMovieName(String name){
        List<Movie> movies = movieRepository.getAllByMovieName(name, PageRequest.of(0,5));
        this.setPropertiesMovie(movies);
        return movies;
    }

    private void setPropertiesMovie(List<Movie> movies){
        for (Movie movie: movies){
            movie.setView(this.getViewByMovieId(movie.getId()));
            movie.setEpisode(this.getNumByMovieId(movie.getId()));
            movie.setRate(this.getRateByMovieId(movie.getId()));
        }
    }

    public String getRateByMovieId(int id){
        if(movieRepository.getRateByMovieId(id) == null){
            return "??";
        }
        return movieRepository.getRateByMovieId(id);
    }


    public String getViewByMovieId(int id){
        if(movieRepository.getViewByMovieId(id) == null){
            return "20";
        }
        return movieRepository.getViewByMovieId(id);
    }


    public String getNumByMovieId(int id){
        if(movieRepository.getNumByMovieId(id) == 0){
            return "??";
        }
        return String.valueOf(movieRepository.getNumByMovieId(id));
    }


    @Override
    public Movie getMovieByMovieId(int id){
        return movieRepository.findById(id).get();
    }

    @Override
    public int getMovieByEpisodeId(int id){
        return movieRepository.getMovieByEpisodeId(id);
    }


    // Admin
    @Override
    public List<Movie> getAllMovie(){
        List<Movie> movies = movieRepository.findAll();
        for(Movie m: movies){
            m.setNation_name(nationRepository.getNationByMovieId(m.getId()).getNation_name());
            m.setCategory_name(categoryRepository.getAllNameByMovieId(m.getId()));
            m.setNominate(detailService.getNominate(m.getId()));
        }
        return movies;
    }

    @Override
    public void saveMovie(int movie_id, String movie_name, String movie_image,
                          String movie_trailer, String movie_comment, String movie_year,
                          int movie_length, String movie_type, int movie_nation,
                          List<Integer> movie_category, int movie_total, String movie_introduce) throws Exception{

        Movie m = new Movie();

        if(movie_id != 0) {
            m.setId(movie_id);
        }
        m.setMovie_image(movie_image);
        m.setMovie_trailer(movie_trailer);
        m.setMovie_comment(movie_comment);
        m.setMovie_length(movie_length);
        m.setMovie_type(movie_type);
        m.setMovie_name(movie_name);
        m.setTotal_episodes(movie_total);
        m.setMovie_introduction(movie_introduce);

        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(movie_year);
        m.setRelease_year(date1);

        m.setStatus(true);

        Nation n = nationRepository.findById(movie_nation).get();
        m.setNation(n);

        List<Category> categories = new ArrayList<>();
        for(Integer i: movie_category){
            Category c = categoryRepository.findById(i).get();
            categories.add(c);
        }
        m.setCategories(categories);

        movieRepository.save(m);

    }
    @Override
    public void setStatus(int id, boolean status){
        Movie m = this.getMovieByMovieId(id);
        if(status == false){
            m.setStatus(true);
        }else m.setStatus(false);

        movieRepository.save(m);
    }
    @Override
    public void setNominate(int id, boolean status){
        Movie m = this.getMovieByMovieId(id);
        if(status == false){
            m.setNominate(true);
        }else m.setNominate(false);

        movieRepository.save(m);
    }


    public void setSessionEpisode(List<Integer> episode_id_list, int episode_id){
        boolean check_episode = true;
        for(Integer i : episode_id_list){
            if(i == episode_id) check_episode = false;
        }
        if(check_episode == true){
            episode_id_list.add(episode_id);
        }
    }

}
