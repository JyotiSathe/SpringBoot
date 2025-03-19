package com.siemens.springboottraining.repository;

import com.siemens.springboottraining.entity.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualRepository extends JpaRepository<Individual, Long> {
}
