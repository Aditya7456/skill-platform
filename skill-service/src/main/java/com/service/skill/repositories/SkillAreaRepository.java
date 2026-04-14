package com.service.skill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.skill.model.SkillArea;

@Repository
public interface SkillAreaRepository extends JpaRepository<SkillArea, Long>{

}
