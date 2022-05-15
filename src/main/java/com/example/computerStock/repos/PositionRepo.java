package com.example.computerStock.repos;

import com.example.computerStock.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PositionRepo extends JpaRepository<Position, Long> {

    List<Position> findByOrderId(Long id);

    @Transactional
    void removeById(Long id);

    @Transactional
    void deleteAllByOrder(Long id);
}
