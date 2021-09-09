package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.Role;
import com.nuce.movie.entity.User;
import com.nuce.movie.repositories.ProviderRepository;
import com.nuce.movie.repositories.RoleRepository;
import com.nuce.movie.repositories.UserRepository;
import com.nuce.movie.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ProviderRepository providerRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getListUser(){
        List<User> users = userRepository.getAllUser();
        for (User u : users){
            List<String> roles = roleRepository.getAllNameByUserId(u.getId());
            u.setRole_name(roles);
        }
        return users;
    }

    @Override
    public void setStatus(int id, boolean status){
        User u = userRepository.findById(id).get();
        if(status == true) u.setStatus(false);
        else u.setStatus(true);
        userRepository.save(u);
    }

    @Override
    public void deleteUser(int id){
        User u = userRepository.findById(id).get();
        u.getRoles().removeAll(u.getRoles());
        userRepository.delete(u);
    }

    @Override
    public User getUserByUserId(int id){
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void saveUser(int id, String name, String birthday, Long phone,
                        boolean gender, String email, String password,
                        int provider_id, int role_id, boolean status) throws Exception{
        User u = new User();

        if(id != 0) {
            u.setId(id);
        }

        u.setFullname(name);
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        u.setBirthday(date1);

        u.setPhone(phone);
        u.setGender(gender);
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(password));
        u.setProvider(providerRepository.getById(provider_id));
        u.setStatus(status);

        List<Role> roles = new ArrayList<>();
        if(role_id == -1){
             roles = roleRepository.findAll();
        }else{
            roles.add(roleRepository.getById(role_id));
        }
        u.setRoles(roles);

        userRepository.save(u);

    }

    @Override
    public User getUserByEmail(String s){
        return userRepository.getUserByEmail(s);
    }

//
//    @Override
//    public int getNumberByTableUser(){
//        int count =  userRepository.getCountByUserId();
//        return ((int)count/4)+1;
//    }
//
//
//    @Override
//    public List<User> filterUser(String user_type, String user_search, int user_role, boolean user_status, int size){
//        List<User> userList = null;
//
//        // case user_search null
//        if(user_search.length() == 0 || user_search.equals("") || user_search == null){
//
//            userList = userRepository.getAllByStatus(user_status,PageRequest.of(size,4));
//            return this.filterRole(user_role,userList);
//
//        }
//
//
//        switch (user_type){
//            case "Fullname":
//                userList = userRepository.getAllByFullname(user_search,user_status,PageRequest.of(size,4));
//                this.filterRole(user_role,userList);
//                break;
//            case "Email":
//                userList = userRepository.getAllByEmail(user_search,user_status,PageRequest.of(size,4));
//                this.filterRole(user_role,userList);
//                break;
//            case "Id":
//                userList = userRepository.getAllBySearch(Integer.valueOf(user_search),user_status);
//                this.filterRole(user_role,userList);
//                break;
//        }
//
//        return userList;
//
//    }
//
//
//    private List<User> filterRole(int user_role, List<User> userList){
//        if(user_role == -1){
//            for (User u : userList){
//                List<String> roles = roleRepository.getAllNameByUserId(u.getId());
//                u.setRole_name(roles);
//            }
//            return userList;
//
//        }else{
//            List<User> filter_user = new ArrayList<>();
//            for (User u : userList){
//                List<String> roles = roleRepository.getAllNameByUserId(u.getId());
//                boolean check = false;
//                for(String r : roles){
//                    if(r.equals(roleRepository.getRoleNameByRoleID(user_role))){
//                        check = true;
//                    }
//                }
//                if(check == true ){
//                    u.setRole_name(roles);
//                    filter_user.add(u);
//                }
//            }
//            return filter_user;
//        }
//    }

}
