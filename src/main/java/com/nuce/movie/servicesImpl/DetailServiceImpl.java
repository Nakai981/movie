package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.Movie;
import com.nuce.movie.entity.MovieDetail;
import com.nuce.movie.entity.User;
import com.nuce.movie.repositories.DetailRepository;
import com.nuce.movie.repositories.MovieRepository;
import com.nuce.movie.repositories.UserRepository;
import com.nuce.movie.services.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired private DetailRepository detailRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private MovieRepository movieRepository;

    @Override
    public void setFollow(int movie_id, int user_id){
        MovieDetail d = detailRepository.setFollow(movie_id,user_id);
        if(d== null){
            d = new MovieDetail();
            User u = userRepository.findById(user_id).get();
            Movie m = movieRepository.findById(movie_id).get();

            d.setRate(0);
            d.setFollow(true);
            d.setStatus(true);
            d.setUser(u);
            d.setMovie(m);
        }
        d.setFollow(true);
        detailRepository.save(d);

    }
    @Override
    public void cancelFollow(int movie_id, int user_id){
        MovieDetail d = detailRepository.setFollow(movie_id,user_id);
        d.setFollow(false);
        detailRepository.save(d);

    }
    @Override
    public boolean checkFollow(int movie_id, int user_id){
        MovieDetail d = detailRepository.checkFollow(movie_id,user_id);
        if(d != null) return true;
        return false;
    }

    @Override
    public void setNominate(int movie_id, int user_id){
        MovieDetail d = detailRepository.setFollow(movie_id,user_id);
        if(d== null){
            d = new MovieDetail();
            User u = userRepository.findById(user_id).get();
            Movie m = movieRepository.findById(movie_id).get();

            d.setRate(0);
            d.setFollow(true);
            d.setStatus(true);
            d.setUser(u);
            d.setMovie(m);
        }
        d.setNominations(true);
        detailRepository.save(d);

    }
    @Override
    public void cancelNominate(int movie_id, int user_id){
        MovieDetail d = detailRepository.setFollow(movie_id,user_id);
        d.setNominations(false);
        detailRepository.save(d);

    }
    @Override
    public boolean checkNominate(int movie_id, int user_id){
        MovieDetail d = detailRepository.checkNominate(movie_id,user_id);
        if(d != null) return true;
        return false;
    }
    @Override
    public boolean getNominate(int movie_id){
        MovieDetail d = detailRepository.getNominate(movie_id, PageRequest.of(0,1));
        if(d != null) return true;
        return false;
    }

    @Override
    public void rateFilm(int movie_id, int user_id, int rate){
        MovieDetail d = detailRepository.setFollow(movie_id,user_id);
        if(d== null){
            d = new MovieDetail();
            User u = userRepository.findById(user_id).get();
            Movie m = movieRepository.findById(movie_id).get();

            d.setRate(rate);
            d.setFollow(false);
            d.setStatus(true);
            d.setUser(u);
            d.setMovie(m);
        }else{
            if(d.getRate() == rate){
                d.setRate(0);
            }else{
                d.setRate(rate);
            }
        }

        detailRepository.save(d);


    }

    @Override
    public float getMovieDetail(int user_id, int movie_id){
        MovieDetail d =  detailRepository.getDetailByMUId(movie_id,user_id);
        if(d == null) return 0;
        return d.getRate();
    }


}
