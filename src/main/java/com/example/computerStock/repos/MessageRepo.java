package com.example.computerStock.repos;

import com.example.computerStock.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findByTagAndMessageFor(String tag, String messageFor);
    List<Message> findByMessageFor(String messageFor);

    @Transactional
    void removeMessageById(Long id);
}
