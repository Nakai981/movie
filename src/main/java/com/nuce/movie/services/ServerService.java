package com.nuce.movie.services;


import com.nuce.movie.entity.Server;

import java.util.List;

public interface ServerService {
    //
    List<Server> getAllByEpisodeId(int id);

    Server getServerByServerId(List<Server> servers, int id);

    String getServerBySEId(int server_id, int episode_id);

    List<Server> getAllServer();

    void setStatus(int id, boolean status);

    void saveServer(int id, String name, String config);

    Server getServerById(int id);

    void deleteServer(int id);

    List<Integer> getServerIdByEpisode(int id);

//    List<Server> getAllByEpisodeId(int id);
//
//    Server getServerByServerId(int id);
}
