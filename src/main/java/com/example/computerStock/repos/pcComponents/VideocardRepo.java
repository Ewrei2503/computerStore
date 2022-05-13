package com.example.computerStock.repos.pcComponents;

import com.example.computerStock.domain.pcComponents.Videocard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideocardRepo extends JpaRepository<Videocard, Long> {
    Videocard findVideocardByModelAndCompany(String model, String company);
}