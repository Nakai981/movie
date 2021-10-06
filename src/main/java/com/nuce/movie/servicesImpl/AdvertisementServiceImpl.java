package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.Advertisement;
import com.nuce.movie.entity.Category;
import com.nuce.movie.repositories.AdvertisementRepository;
import com.nuce.movie.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired private AdvertisementRepository advertisementRepository;

//    User

    @Override
    public List<Advertisement> getAdvertisementByAdvertisementLocation(){
        Advertisement ads1 = advertisementRepository.getAdvertisementByAdvertisementLocation(1, PageRequest.of(0,1));
        Advertisement ads2 = advertisementRepository.getAdvertisementByAdvertisementLocation(2, PageRequest.of(0,1));
        Advertisement ads3 = advertisementRepository.getAdvertisementByAdvertisementLocation(3, PageRequest.of(0,1));
        Advertisement ads4 =  advertisementRepository.getAdvertisementByAdvertisementLocation(4, PageRequest.of(0,1));

        List<Advertisement> adses = new ArrayList<>();
        adses.add(ads1);adses.add(ads2);adses.add(ads3);adses.add(ads4);
        return adses;
    }


//    Admin
    @Override
    public List<Advertisement> getAllAdvertisement(){
        return advertisementRepository.findAll();
    }

    @Override
    public void saveAdvertisement(int id, String access,String banner, int location, String creat_at, String end_at, String coop){
        Advertisement aa = new Advertisement();
        aa.setCooperation_company(coop);
        aa.setLocation(location);
        aa.setAccess(access);
        aa.setBanner(banner);
        aa.setCreated_at(this.covertStrToDate(creat_at));
        aa.setEnd_at(this.covertStrToDate(end_at));
        aa.setStatus(true);
        if (id !=0 ){
            aa.setId(id);
        }
        advertisementRepository.save(aa);
    }

    @Override
    public Advertisement getAdvertisementById(int id){
        return advertisementRepository.findById(id).get();
    }

    @Override
    public void setStatus(int id, boolean status){
        Advertisement aa = this.getAdvertisementById(id);
        if(status == true){
            aa.setStatus(false);
        }else aa.setStatus(true);
        advertisementRepository.save(aa);
    }

    @Override
    public void deleteAdvertisement(int id){
        Advertisement aa = this.getAdvertisementById(id);
        advertisementRepository.delete(aa);
    }

    public LocalDateTime covertStrToDate(String date){
        String date_split = null;
        if(date.length() == 15){
             date_split = date.substring(0,10) + " 0"+date.substring(11,15);

        }else{
             date_split = date.substring(0,10) + " "+date.substring(11,16);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(date_split, formatter);
    }
}
