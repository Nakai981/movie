package com.nuce.movie.repositories;

import com.nuce.movie.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {
    @Query("select p from Purchase p where p.status = true")
    List<Purchase> getAllPurchase();

//    @Query("select  from Purchase p join p.purchaseDetails pd join pd.user u where u.status= true and p.id=?1")

}
