package com.siemens.springboottraining.repository;

import com.siemens.springboottraining.entity.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateRepository extends JpaRepository<Corporate, Long> {
}
