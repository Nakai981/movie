package com.nuce.movie.services;

import com.nuce.movie.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface UserService {


    List<User> getListUser();

    void setStatus(int id, boolean status);

    void deleteUser(int id);

    User getUserByUserId(int id);

    @Transactional
    void saveUser(int id, String name, String birthday, Long phone,
                 boolean gender, String email, String password,
                 int provider_id, int role_id, boolean status) throws Exception;

    User getUserByEmail(String s);

    void updateUser(int id, String name, String birthday, String pass, boolean gender) throws Exception;

    void saveUser(User u);

//    int getNumberByTableUser();
//
//    List<User> filterUser(String user_type, String user_search, int user_role, boolean user_status, int size);
}
