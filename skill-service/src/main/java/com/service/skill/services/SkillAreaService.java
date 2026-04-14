package com.service.skill.services;

import java.util.List;


import com.service.skill.dto.SkillAreaRequestDto;
import com.service.skill.dto.SkillAreaResponseDto;


public interface SkillAreaService {
	
	// to create the skill Areas using skill Id
	SkillAreaResponseDto createSkillArea(Long skillId, SkillAreaRequestDto request);
	// to get areas using skill Id
	List<SkillAreaResponseDto> getAreasBySkill(Long skillId);
	// to updateArea using area Id
	SkillAreaResponseDto updateArea(Long AreaId, SkillAreaRequestDto request);
	// to delete Areas using area Id
	void deleteArea(Long areaId);
}
