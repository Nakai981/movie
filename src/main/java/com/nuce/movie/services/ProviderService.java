package com.nuce.movie.services;

import com.nuce.movie.entity.Provider;
import com.nuce.movie.entity.User;

import java.util.List;
import java.util.Set;

public interface ProviderService {

    List<Provider> getAllProvider();

    void editProvider(int id, String name);

    void deleteProvider(int id);

    void activeProvider(int id);

    void addProvider(String name, boolean status);
}
