package com.nuce.movie.repositories;

import com.nuce.movie.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
}
