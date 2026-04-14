package com.service.skill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningMaterial extends JpaRepository<LearningMaterial, Long>{

}
