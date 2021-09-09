package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.Provider;
import com.nuce.movie.entity.User;
import com.nuce.movie.repositories.ProviderRepository;
import com.nuce.movie.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProviderServiceImpl implements ProviderService{
    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public List<Provider> getAllProvider(){
        return providerRepository.findAll();
    }
    @Override
    public void editProvider(int id, String name){
        Provider provider_update = providerRepository.getById(id);
        provider_update.setProvider_name(name);
        providerRepository.save(provider_update);
    }
    @Override
    public void deleteProvider(int id){
        Provider provider_delete = providerRepository.getById(id);
        provider_delete.setStatus(false);
        providerRepository.save(provider_delete);
    }

    @Override
    public void activeProvider(int id){
        Provider provider_delete = providerRepository.getById(id);
        provider_delete.setStatus(true);
        providerRepository.save(provider_delete);
    }

    @Override
    public void addProvider(String name, boolean status){
        Provider provider = new Provider();
        provider.setProvider_name(name);
        provider.setStatus(status);
        providerRepository.save(provider);
    }

}
