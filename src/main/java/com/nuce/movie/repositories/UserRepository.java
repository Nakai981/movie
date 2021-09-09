package com.nuce.movie.repositories;

import com.nuce.movie.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.email = ?1 and u.status=true")
    public User getUserByEmail(String email);

    @Query("select u from User u order by u.id desc ")
    public List<User> getAllUser();

    @Query("select count(u.id) from User u")
    public int getCountByUserId();

    @Query("select u from User u where u.id=?1 and u.status = ?2 order by u.id desc")
    public List<User> getAllBySearch(int id,boolean status);

    @Query("select u from User u where u.email LIKE CONCAT('%',?1,'%') and u.status = ?2 order by u.id desc")
    public List<User> getAllByEmail(String email,boolean status, PageRequest pageRequest);

    @Query("select u from User u where u.fullname LIKE CONCAT('%',?1,'%') and u.status = ?2 order by u.id desc")
    public List<User> getAllByFullname( String fullname,boolean status,PageRequest pageRequest);

    @Query("select u from User u where u.status = ?1 order by u.id desc")
    public List<User> getAllByStatus(boolean status, PageRequest pageRequest);

}
