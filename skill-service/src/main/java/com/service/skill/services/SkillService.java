package com.service.skill.services;

import java.util.List;


import com.service.skill.dto.SkillAreaRequestDto;
import com.service.skill.dto.SkillCreateRequestDto;
import com.service.skill.dto.SkillResponseDto;

public interface SkillService {
	
	// to create the skill
	SkillResponseDto createSkill(SkillCreateRequestDto request);
	// to get the skill by skill id
	SkillResponseDto getSkillById(Long skillId);
	// to get the skill by skill name
	SkillResponseDto getSkillByName(String name);
	// to get all skills and their subAreas
	List<SkillResponseDto> getAllSkills();
	// to add the skill areas to the specific skill using skill id
	SkillResponseDto addAreasToSkill(Long skillId, List<SkillAreaRequestDto> areas);
	// to delete the skill
	void deleteSkill(Long skillId);
	// to update the skill by skill Id
	SkillResponseDto updateSkillById(Long skillId, SkillCreateRequestDto request);
	
}
