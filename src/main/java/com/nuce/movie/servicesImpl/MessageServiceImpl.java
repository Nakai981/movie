package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.Episode;
import com.nuce.movie.entity.Message;
import com.nuce.movie.entity.Server;
import com.nuce.movie.repositories.EpisodeRepository;
import com.nuce.movie.repositories.MessageRepository;
import com.nuce.movie.repositories.MovieRepository;
import com.nuce.movie.repositories.ServerRepository;
import com.nuce.movie.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    EpisodeRepository episodeRepository;
    @Autowired
    ServerRepository serverRepository;
    @Autowired
    MovieRepository movieRepository;
    @Override
    public void setStatus(int episode_id, int server_id){
        Message message = messageRepository.getMessageByESId(episode_id,server_id, PageRequest.of(0,1));

        message.setStatus(false);
        message.setMessage("Error");

        messageRepository.save(message);
    }
    @Override
    public boolean getStatus(int episode_id, int server_id){
        Message message = messageRepository.getMessageByESId(episode_id,server_id,PageRequest.of(0,1));
        return message.isStatus();
    }

    @Override
    public List<Message> getAllByEpisodeId(int id){
        return messageRepository.getAllByEpisodeId(id);
    }
    @Override
    public  void    saveEpisodeServer(int server_id, int episode_id, String link, int message_id){
        Message m = new Message();
        Episode e = episodeRepository.findById(episode_id).get();
        Server s = serverRepository.findById(server_id).get();
        m.setEpisode(e);
        m.setMessage("No Error");
        m.setServer(s);
        m.setLink(link);
        m.setStatus(true);
        if(message_id != 0){
            m.setId(message_id);
        }
        messageRepository.save(m);
    }

    @Override
    public Message getMessageByMessageId(int id){
        return messageRepository.findById(id).get();
    }

    @Override
    public void deleteMessage(int id){
        Message m = this.getMessageByMessageId(id);
         messageRepository.delete(m);
    }

    @Override
    public List<Message> getAllByStatus(){
        List<Message> messages = messageRepository.getAllByStatus();
        for(Message m: messages){
            m.setMovie_id(movieRepository.getMovieByEpisodeId(m.getEpisode().getId()));
        }
        return messages;
    }

    @Override
    public void setStatus(int id, boolean status){
        Message m = messageRepository.findById(id).get();
        if(status == true) m.setStatus(false);
        else m.setStatus(true);
        messageRepository.save(m);
    }
}
