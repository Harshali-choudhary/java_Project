package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.User;
import com.app.services.UserService;



@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService userSer;
	
	@PostMapping("insert")
	public ResponseEntity<String> Insert(@RequestBody User u) {
	    User user = userSer.Insert(u);
	    return ResponseEntity.ok("User Inserted Successfully " + user);
	}

	
	@GetMapping("getAll")
	public ResponseEntity<List<User>> GetAll()
	{
		List<User> list= userSer.GetAll();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("update")
	public ResponseEntity<String> Update(@RequestBody User user)
	{
		User u = userSer.Update(user);
		return ResponseEntity.ok("User Updated Successfully "+u);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<String> Delete(@RequestParam Long id)
	{
		userSer.Delete(id);
		return ResponseEntity.ok("User deleted successfully");
	}
}
