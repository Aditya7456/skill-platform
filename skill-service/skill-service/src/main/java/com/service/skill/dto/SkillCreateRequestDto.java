package com.service.skill.dto;

import java.util.List;

public class SkillCreateRequestDto {
	private String name;
	private String description;
	private List<SkillAreaRequestDto> areas;
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
	public List<SkillAreaRequestDto> getAreas() {
		return areas;
	}
	public void setAreas(List<SkillAreaRequestDto> areas) {
		this.areas = areas;
	}
	
	
}
