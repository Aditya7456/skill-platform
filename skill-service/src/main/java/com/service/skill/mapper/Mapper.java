package com.service.skill.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.service.skill.dto.SkillAreaResponseDto;
import com.service.skill.dto.SkillResponseDto;
import com.service.skill.model.Skill;
import com.service.skill.model.SkillArea;

public class Mapper {
	
	public static SkillAreaResponseDto skillAreaToSkillAreaResponseDto(SkillArea area) {

        SkillAreaResponseDto res = new SkillAreaResponseDto();
        res.setId(area.getId());
        res.setName(area.getName());
        res.setDescription(area.getDescription());
        res.setCreatedAt(area.getCreatedAt());

        return res;
    }
	
	 // -------------------------
    // Mapper (internal helper)
    // -------------------------
    public static SkillResponseDto skillToSkillResponseDto(Skill skill) {

        SkillResponseDto response = new SkillResponseDto();
        response.setId(skill.getId());
        response.setName(skill.getName());
        response.setDescription(skill.getDescription());
        response.setCreatedAt(skill.getCreatedAt());

        List<SkillAreaResponseDto> areaResponses = skill.getAreas()
                .stream()
                .map(val ->  Mapper.skillAreaToSkillAreaResponseDto(val))
                .collect(Collectors.toList());

        response.setAreas(areaResponses);

        return response;
    }
}
