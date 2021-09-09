package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.*;
import com.nuce.movie.repositories.EpisodeRepository;
import com.nuce.movie.repositories.MessageRepository;
import com.nuce.movie.repositories.MovieRepository;
import com.nuce.movie.services.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EpisodeServiceImpl implements EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private MovieRepository movieRepository;

    List<Episode> episodes;

    @Override
    public List<Episode> getAllByMovieId(int id){
        this.episodes= episodeRepository.getAllByMovieId(id);
        return this.episodes;
    }
    @Override
    public String onNext(int id){
        if(this.episodes.size() == 1) return null;
        int next = -1;
        for(int i=0; i < episodes.size(); i++){
            if(episodes.get(i).getId() == id) next = i;
        }
        if(next >= episodes.size()-1){
            return null;
        }
        return String.valueOf(episodes.get(next+1).getId());
    }
    @Override
    public String onPrevious(int id){
        if(this.episodes.size() == 1) return null;
        int next = -1;
        for(int i=0; i < episodes.size(); i++){
            if(episodes.get(i).getId() == id) next = i;
        }
        if(next <= 0){
            return null;
        }
        return String.valueOf(episodes.get(next-1).getId());
    }

    @Override
    public Episode getEpisodeByEpisodeId(int id){
        return episodeRepository.findById(id).get();
    }
    @Override
    public void countView(int id){
        Episode e = this.getEpisodeByEpisodeId(id);
        e.setEpisode_view(e.getEpisode_view()+1);
        episodeRepository.save(e);
    }

    //Admin


    @Override
    public void saveEpisode(int movie_id, int episode_id, String episode_name, int episode_view){
        Movie m = movieRepository.findById(movie_id).get();
        Episode e = new Episode();
        if(episode_id != 0){
            e.setId(episode_id);
        }
        e.setEpisode_view(episode_view);
        e.setEpisode_name(episode_name);
        e.setMovie(m);
        e.setStatus(true);
        episodeRepository.save(e);
    }
    @Override
    public void setStatus(int episode_id,boolean episode_status){
        Episode e = episodeRepository.findById(episode_id).get();

        if(episode_status == false)
            e.setStatus(true);
        else e.setStatus(false);
        episodeRepository.save(e);
    }

    @Override
    public void deleteEpisode(int episode_id){
        Episode e = this.getEpisodeByEpisodeId(episode_id);
        e.getMessages().removeAll(e.getMessages());
        episodeRepository.delete(e);
    }

}
