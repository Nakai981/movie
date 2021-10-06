package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.Purchase;
import com.nuce.movie.repositories.PurchaseRepository;
import com.nuce.movie.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getAllPurchase(){
        return purchaseRepository.getAllPurchase();
    }

}
