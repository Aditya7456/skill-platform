package com.service.skill.dto;

import java.time.LocalDateTime;
import java.util.List;

public class SkillResponseDto {
	private Long id;
    private String name;
    private String description;

    private List<SkillAreaResponseDto> areas;

    private LocalDateTime createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<SkillAreaResponseDto> getAreas() {
		return areas;
	}

	public void setAreas(List<SkillAreaResponseDto> areas) {
		this.areas = areas;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
    
}
