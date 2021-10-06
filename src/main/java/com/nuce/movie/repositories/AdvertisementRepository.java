package com.nuce.movie.repositories;

import com.nuce.movie.entity.Advertisement;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  AdvertisementRepository extends JpaRepository<Advertisement, Integer> {

    @Query("select ad from Advertisement ad where ad.location = ?1 and ad.status = true order by ad.id desc")
    Advertisement getAdvertisementByAdvertisementLocation(int location, PageRequest pageRequest);

}
