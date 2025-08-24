package com.example.ms_empleo.repository;

import com.example.ms_empleo.models.Empleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleoRepository extends JpaRepository<Empleo, Long> {
}