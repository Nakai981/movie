package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.Movie;
import com.nuce.movie.entity.Nation;
import com.nuce.movie.entity.User;
import com.nuce.movie.repositories.MovieRepository;
import com.nuce.movie.repositories.NationRepository;
import com.nuce.movie.services.NationService;
import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl implements NationService {
    @Autowired
    private NationRepository nationRepository;
    @Autowired private MovieRepository movieRepository;

    @Override
    public List<Nation> getALlByStatus(){
        return nationRepository.getALlByStatus();
    }

    @Override
    public Nation getAllByMovieId(int id){
        return nationRepository.getNationByMovieId(id);
    }

    @Override
    public String getNameByNationId(int id){
        return nationRepository.getNameByNationId(id);
    }

//    ADMIN
    @Override
    public List<Nation> getAllNation(){
        return nationRepository.findAll();
    }

    @Override
    public void setStatus(int id, boolean status){
        Nation n = nationRepository.findById(id).get();
        if(status == false)
            n.setStatus(true);
        else n.setStatus(false);
        nationRepository.save(n);
    }
    @Override
    public void saveNation(int id, String name){
        Nation n = new Nation();
        n.setNation_name(name);
        n.setStatus(true);
        if(id != 0){
            Nation nation = nationRepository.findById(id).get();
            nation.setNation_name(name);
            nationRepository.save(nation);
        }else
        nationRepository.save(n);
    }

    @Override
    public Nation getNationById(int nation_id){
        return  nationRepository.findById(nation_id).get();

    }

    @Override
    public void deleteNation(int id){
        Nation n = this.getNationById(id);
        n.getMovies().removeAll(n.getMovies());

        nationRepository.delete(n);
    }

}
