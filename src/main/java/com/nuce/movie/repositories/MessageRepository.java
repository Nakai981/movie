package com.nuce.movie.repositories;

import com.nuce.movie.entity.Message;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {

    @Query("select m from Message m where m.episode.id=?1 and m.server.id=?2 ")
    public Message getMessageByESId(int episode_id, int server_id, PageRequest pageRequest);


    @Query("select m from Message m where m.episode.id=?1 and m.episode.status = true and m.server.status = true")
    public List<Message> getAllByEpisodeId(int id);

    @Query("select m from Message m where m.status = false and m.server.status= true and m.episode.status=true")
    public List<Message> getAllByStatus();
}
