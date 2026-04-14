package com.service.skill.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.skill.dto.SkillAreaRequestDto;
import com.service.skill.dto.SkillCreateRequestDto;
import com.service.skill.dto.SkillResponseDto;
import com.service.skill.services.SkillService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/skills")
@Tag(name = "Skill Management APIs", description = "APIs for managing skills and skill areas")
public class SkillController {
		
	private final SkillService skillService;
	
	private static final Logger logger = LoggerFactory.getLogger(SkillController.class);
	
	public SkillController(SkillService skillService) {
		this.skillService = skillService;
	}
	
	// for Creating the skill
	@Operation(summary = "create a skill with areas")
	@PostMapping
	public ResponseEntity<SkillResponseDto> createSkill(@Valid @RequestBody SkillCreateRequestDto request){
		SkillResponseDto response = skillService.createSkill(request);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	// -----------------------------
    // 2. Get Skill by ID
    // -----------------------------
    @GetMapping("/{id}")
    public ResponseEntity<SkillResponseDto> getSkillById(@PathVariable Long id) {

        SkillResponseDto response = skillService.getSkillById(id);
        logger.info("Skill fetched : {}", response);
        
        return ResponseEntity.ok(response);
    }

    // -----------------------------
    // 3. Get All Skills
    // -----------------------------
    @GetMapping
    public ResponseEntity<List<SkillResponseDto>> getAllSkills() {

        List<SkillResponseDto> response = skillService.getAllSkills();
        return ResponseEntity.ok(response);
    }

    // -----------------------------
    // 4. Add Areas to Skill 
    // -----------------------------
    @PostMapping("/{id}/areas")
    public ResponseEntity<SkillResponseDto> addAreasToSkill(
            @PathVariable Long id,
            @RequestBody List<SkillAreaRequestDto> areas) {

        SkillResponseDto response = skillService.addAreasToSkill(id, areas);
        return ResponseEntity.ok(response);
    }

    // -----------------------------
    // 5. Delete Skill By Id
    // -----------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSkill(@PathVariable Long id) {

        skillService.deleteSkill(id);
        return ResponseEntity.ok("Skill Deleted Successfully!");
    }
    
    // -----------------------------
    // 5. Update Skill By Id
    // -----------------------------
   @PutMapping("/{id}")
   public ResponseEntity<SkillResponseDto> updateSkill(@PathVariable Long id,@RequestBody SkillCreateRequestDto request){
	   SkillResponseDto response = skillService.updateSkillById(id, request);
	   return ResponseEntity.ok(response);
   }
   
   @GetMapping("/test")
   public String getTestResult() {
	   return "result";
   }
}
