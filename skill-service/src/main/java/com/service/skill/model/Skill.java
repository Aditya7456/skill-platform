package com.service.skill.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="skills")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(length = 1000)
	private String description;
	
	@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<SkillArea> areas =  new ArrayList<>();
	
	@Column(name="created_at")
	private LocalDateTime createdAt;

	public Skill(Long id, String name, String description, List<SkillArea> areas, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.areas = areas;
		this.createdAt = createdAt;
	}

	public Skill() {
		this.createdAt = LocalDateTime.now();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SkillArea> getAreas() {
		return areas;
	}

	public void setAreas(List<SkillArea> areas) {
		this.areas = areas;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", description=" + description + ", areas=" + areas
				+ ", createdAt=" + createdAt + "]";
	}	
	
	public void addArea(SkillArea area) {
	    areas.add(area);        // parent side
	    area.setSkill(this);    // child side (VERY IMPORTANT)
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
 