package com.nuce.movie.repositories;

import com.nuce.movie.entity.Provider;
import com.nuce.movie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ProviderRepository extends JpaRepository<Provider,Integer> {


}
