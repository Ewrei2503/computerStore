package com.example.computerStock.repos;

import com.example.computerStock.domain.Message;
import com.example.computerStock.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer> {
    List<Message> findByTagAndMessageFor(String tag, String messageFor);
    List<Message> findByMessageFor(String messageFor);
}
