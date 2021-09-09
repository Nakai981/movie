package com.nuce.movie.repositories;

import com.nuce.movie.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedNativeQueries;
import java.util.List;

public interface ServerRepository extends JpaRepository<Server,Integer> {

    @Query("select s from Server s join s.messages m join m.episode e where s.status=true and e.status=true and e.id = ?1 ")
    List<Server> getAllByEpisodeId(int id);

    @Query("select m.link from Server s join s.messages m join m.episode e where s.status=true and e.status=true and e.id = ?1 and s.id = ?2")
    public String getServerBySEId(int episode_id, int  server_id);

    @Query("select s.id from Server s join s.messages m join m.episode e where e.id=?1")
    List<Integer> getServerByEpisode(int id);
}
