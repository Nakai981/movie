package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.Category;
import com.nuce.movie.entity.Nation;
import com.nuce.movie.entity.Server;
import com.nuce.movie.repositories.ServerRepository;
import com.nuce.movie.services.ServerService;
import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServerRepository serverRepository;

    @Override
    public List<Server> getAllByEpisodeId(int id){
        return serverRepository.getAllByEpisodeId(id);
    }

    @Override
    public Server getServerByServerId(List<Server> servers, int id){
        for(Server s: servers){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }
    @Override
    public String getServerBySEId(int server_id, int episode_id){
        return serverRepository.getServerBySEId(episode_id,server_id);
    }


//    ADMIN
    @Override
    public List<Server> getAllServer(){
        return serverRepository.findAll();
    }

    @Override
    public void setStatus(int id, boolean status){
        Server n = serverRepository.findById(id).get();
        if(status == false)
            n.setStatus(true);
        else n.setStatus(false);
        serverRepository.save(n);
    }
    @Override
    public void saveServer(int id, String name, String config){
        Server s = new Server();
        s.setServer_name(name);
        s.setServer_config(config);
        s.setStatus(true);

        if(id != 0){
            Server server = serverRepository.findById(id).get();
            server.setServer_name(name);
            server.setServer_name(name);
            server.setServer_config(config);
            server.setStatus(true);
            serverRepository.save(server);
        }else
            serverRepository.save(s);
    }

    @Override
    public Server getServerById(int id){
        return  serverRepository.findById(id).get();

    }

    @Override
    public void deleteServer(int id){
        Server c = this.getServerById(id);
        c.getMessages().removeAll(c.getMessages());
        serverRepository.delete(c);
    }

    @Override
    public List<Integer> getServerIdByEpisode(int id){
       return serverRepository.getServerByEpisode(id);
    }
}
