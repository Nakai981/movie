package com.nuce.movie.services;

import com.nuce.movie.entity.Advertisement;

import java.time.LocalDateTime;
import java.util.List;

public interface AdvertisementService {


    List<Advertisement> getAdvertisementByAdvertisementLocation();

    List<Advertisement> getAllAdvertisement();

    void saveAdvertisement(int id, String banner,String access, int location, String creat_at, String end_at, String coop);

    Advertisement getAdvertisementById(int id);

    void setStatus(int id, boolean status);

    void deleteAdvertisement(int id);
}
