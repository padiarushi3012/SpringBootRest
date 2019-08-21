package com.example.demo.assistant;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssistantResource {

	@Autowired
	private AssistantRepository assistantRepository;
	
	@GetMapping("/assistants")
	public List<Assistant> retrieveAllAssistants(){
		return assistantRepository.findAll();
	}
	
	@GetMapping("/assistants/{id}")
	public Assistant retrieveAssistant(@PathVariable Long id){
		Optional<Assistant> assistant = assistantRepository.findById(id);
			if(!assistant.isPresent()) {
				return null;
			}
		return assistant.get();
	}
	
	@DeleteMapping("/assistants/{id}")
	public void deleteAssistants(@PathVariable Long id) {
		assistantRepository.deleteById(id);
	}
	
	@PostMapping("/assistants")
	public Assistant createAssistant(@RequestBody Assistant assistant){
		Assistant savedAssistant;
		try {
		savedAssistant = assistantRepository.save(assistant);
		}
		catch(Exception e) {
			return null;
		}
		return savedAssistant;
	}
	
	@PutMapping("/assistants/{id}")
	public Assistant updateAssistant(@PathVariable Long id, @RequestBody Assistant assistant) {
		
		Optional<Assistant> assistantOptional = assistantRepository.findById(id);
		if(!assistantOptional.isPresent()) {
			return null;
		}
		
		assistant.setId(id);
		assistantRepository.save(assistant);
		
		return assistant;
	}
	
	
	
}
