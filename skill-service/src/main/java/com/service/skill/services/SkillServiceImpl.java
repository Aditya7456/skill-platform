package com.service.skill.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.skill.dto.SkillAreaRequestDto;
import com.service.skill.dto.SkillCreateRequestDto;
import com.service.skill.dto.SkillResponseDto;
import com.service.skill.exception.ResourceNotFoundException;
import com.service.skill.mapper.Mapper;
import com.service.skill.model.Skill;
import com.service.skill.model.SkillArea;
import com.service.skill.repositories.SkillRepository;

@Service
@Transactional
public class SkillServiceImpl implements SkillService{

	private final SkillRepository skillRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(SkillServiceImpl.class);
	
	SkillServiceImpl(SkillRepository skillRepository){
		this.skillRepository = skillRepository;
	}
	
	@Override
	public SkillResponseDto createSkill(SkillCreateRequestDto request) {
		Skill skill = new Skill();
        skill.setName(request.getName());
        skill.setDescription(request.getDescription());

        if (request.getAreas() != null) {
            for (SkillAreaRequestDto areaReq : request.getAreas()) {
                SkillArea area = new SkillArea();
                area.setName(areaReq.getName());
                area.setDescription(areaReq.getDescription());

                skill.addArea(area);
            }
        }

        Skill saved = skillRepository.save(skill);

        return Mapper.skillToSkillResponseDto(saved);
		
	}

	@Override
	public SkillResponseDto getSkillById(Long skillId) {
		// TODO Auto-generated method stub
		Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new RuntimeException("Skill not found with id :" + skillId));
		return Mapper.skillToSkillResponseDto(skill);	
	}

	@Override
	public List<SkillResponseDto> getAllSkills() {
		// TODO Auto-generated method stub
		return skillRepository.findAll()
							  .stream()
							  .map(Mapper::skillToSkillResponseDto)
							  .collect(Collectors.toList());
		
	}

	@Override
	public SkillResponseDto addAreasToSkill(Long skillId, List<SkillAreaRequestDto> areas) {
		Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new RuntimeException("No Skill Found with id :" + skillId));
		
		for(SkillAreaRequestDto areaReq : areas) {
			
			SkillArea area = new SkillArea();
			area.setName(areaReq.getName());
			area.setDescription(areaReq.getDescription());
			
			skill.addArea(area);
		}
		Skill updated = skillRepository.save(skill);
		return Mapper.skillToSkillResponseDto(updated);
	}

	@Override
	public void deleteSkill(Long skillId) {
		Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new ResourceNotFoundException("Skill not found with id : " + skillId));
		logger.info("deleting skill : {}",skill);
		skillRepository.delete(skill);
	}

	@Override
	public SkillResponseDto getSkillByName(String name) {
		Skill skill = skillRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("No Skills found with name :" + name));
		return Mapper.skillToSkillResponseDto(skill);
	}

	@Override
	public SkillResponseDto updateSkillById(Long skillId, SkillCreateRequestDto request) {
		Skill skill = skillRepository.findById(skillId).orElseThrow(()-> new ResourceNotFoundException("No Skill found with skill id :" + skillId));
		
		// Update basic field
		skill.setName(request.getName());
		skill.setDescription(request.getDescription());
		
		if(request.getAreas()!=null) {
			// we will remove existing areas
			// Step 1: Remove old areas properly
			for (SkillArea area : skill.getAreas()) {
			    area.setSkill(null);   // break relationship
			}
			skill.getAreas().clear();
			
			// now adding new areas
			for(SkillAreaRequestDto req :request.getAreas()) {
				SkillArea area = new SkillArea();
				
				area.setName(req.getName());
				area.setDescription(req.getDescription());
				skill.addArea(area);
			}
		}
		Skill updatedSkill = skillRepository.save(skill);
		return Mapper.skillToSkillResponseDto(updatedSkill);
	}

}
