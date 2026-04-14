package com.service.skill.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SkillCreateRequestDto {
	@NotBlank(message = "skill name is mandatory")
	@Size(min = 3, max = 50, message= "skill name must be 3-50 characteres")
	private String name;
	@Size(max= 300, message = "Description max 300 characters")
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
