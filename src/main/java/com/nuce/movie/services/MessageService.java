package com.nuce.movie.services;

import com.nuce.movie.entity.Message;

import java.util.List;

public interface MessageService {
    void setStatus(int episode_id, int server_id);

    boolean getStatus(int episode_id, int server_id);

    List<Message> getAllByEpisodeId(int id);

    void    saveEpisodeServer(int server_id, int episode_id, String link, int message_id);

    Message getMessageByMessageId(int id);

    void deleteMessage(int id);

    List<Message> getAllByStatus();

    void setStatus(int id, boolean status);
}
