package com.service.skill.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "learning_material")
public class LearningMaterial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String contentType; // video, pdf, article, link we can keep anything
	private String url; // acutal file or link
	// many article or material can belong to one skill
	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;
	// same here many material can belong to same skill area
	@ManyToOne
	@JoinColumn(name = "area_id")
	private SkillArea area;
	
	private LocalDateTime createdAt = LocalDateTime.now();
}
