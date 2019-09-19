package com.build.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityController {

	@Autowired
	CommunityDao dao;
	
	@GetMapping("/discussion")
	public List<Community> getDiscussion(){
		List<Community> foundDiscussions = dao.findAll();
		return foundDiscussions; 
	}
	
	@GetMapping("/discussion/{id}")
	public ResponseEntity<Community> getDiscussion(@PathVariable(value="id") Integer id){
		Community foundDiscussion = dao.findById(id).orElse(null);
		
		if(foundDiscussion == null) {
			return ResponseEntity.notFound().header("Discussion" , "discussion not found").build();
		}
		return ResponseEntity.ok(foundDiscussion);
	}
	
	@PostMapping("/discussion")
	public ResponseEntity<Community> postDiscussion(@RequestBody Community discussion){
		
		// Saving to DB using an instance of the repo interface.
	    Community createdDiscussion= dao.save(discussion);

	    // RespEntity crafts response to include correct status codes.
	    return ResponseEntity.ok(createdDiscussion);
	}
	
	@DeleteMapping("/discussion/{id}")
	public ResponseEntity<Community> deleteDiscussion(@PathVariable(value="id") Integer id) {
		Community foundDiscussion = dao.findById(id).orElse(null);
		
		if(foundDiscussion == null) {
			return ResponseEntity.notFound().header("Discussion", "discussion not found").build();
		}else {
			dao.delete(foundDiscussion);
		}
		return ResponseEntity.ok().build();
	}
	
}
