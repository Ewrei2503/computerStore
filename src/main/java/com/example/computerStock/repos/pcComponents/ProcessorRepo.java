package com.example.computerStock.repos.pcComponents;

import com.example.computerStock.domain.pcComponents.Processor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessorRepo extends JpaRepository<Processor, Long> {
    Processor findProcessorById(Long id);
}
