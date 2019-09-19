package com.build.user;

	import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/")
	public class UserController {
		
		@Autowired
		UserDao dao;
		
		@GetMapping("/user")
		public List<User> getUser() {
			List<User> foundUser = dao.findAll();
			return foundUser;
		}
		
		@GetMapping("/user/{id}")
		public ResponseEntity<User> getUsers(@PathVariable(value="id") Integer id) {
			User foundUser = dao.findById(id).orElse(null);
			
			if(foundUser == null) {
				return ResponseEntity.notFound().header("User not found", "Try again").build();
			}
			return ResponseEntity.ok(foundUser);
		}
		
	
		
		@PostMapping("/user")
		public ResponseEntity<User> postUsers(User user) {
			
			//Saving to Db using an instance of the repo interface.
			User createdUser = dao.save(user);
			
			//RespEntity crafts response to include correct status codes.
			return ResponseEntity.ok(createdUser);
		}

//		@PutMapping("/user/{id}")
//		public ResponseEntity<User> updateUser(@PathVariable(value="id") @RequestBody User user) {
//			User user = new User();
//			BeanUtils.copyProperties(user, user);
//			UserController userService = null;
//			userService.updateUser(user);
//			
//			User ob = new User();
//			BeanUtils.copyProperties(user, ob);
//			return new ResponseEntity<User>(ob, HttpStatus.OK);
////		}
//		public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer id,
//        @Valid @RequestBody User userDetails) {
//       User user = new userDetails.findById(id)
//       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
//
//       user.setId(userDetails.getId());
//       user.setLastName(userDetails.getLastName());
//       user.setFirstName(userDetails.getFirstName());
//       final User updatedUser = dao.save(user);
//       return ResponseEntity.ok(updatedUser);
//   }
		
		@DeleteMapping("/user/{id}")
		public ResponseEntity<User> deleteUsers(@PathVariable(value="id") Integer id) {
			User foundUser = dao.findById(id).orElse(null);
			
			if(foundUser == null) {
				return ResponseEntity.notFound().header("User not found","Try again por favor").build();
			}else {
				dao.delete(foundUser);
			}
			return ResponseEntity.ok().build();
		}

	}

