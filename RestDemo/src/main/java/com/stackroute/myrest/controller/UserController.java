package com.stackroute.myrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.myrest.exceptions.UserNotFoundException;
import com.stackroute.myrest.model.User;
import com.stackroute.myrest.services.UserService;

@RestController

public class UserController {
  @Autowired
  UserService userservice;
  
  
  @PostMapping("/myapp/add")
  public ResponseEntity<?> addrec(@RequestBody User uobj)
  {
	  userservice.myaddUser(uobj);
	  return new ResponseEntity<String>("Successfully added",HttpStatus.OK);
	  
  }
  
  @GetMapping("/myapp/showuser/{userid}")
  
  public ResponseEntity<?> viewrec(@PathVariable("userid") String uid)
  {
	  User userobj;
	  try
	  {
	   userobj=userservice.myviewUser(uid);
	  }
	  catch(UserNotFoundException ue)
	  {
		  return new ResponseEntity<String>("Userid not found",HttpStatus.NOT_FOUND);
	  }
		  
	  return new ResponseEntity<User>(userobj,HttpStatus.ACCEPTED);
  }
  
	@DeleteMapping("/myapp/delete/{userid}")
	public ResponseEntity<?> delrec(@PathVariable("userid") String uid)
	{
		try
		{
			boolean b=userservice.mydelete(uid);
		}
		catch(UserNotFoundException ue)
		{
			return new ResponseEntity<String>("invalid user",HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<String>("Record deleted",HttpStatus.OK);
	}
	
	@PutMapping("/myapp/modify")
	
	public ResponseEntity<?> modify(@RequestBody User uobj)
	  {
		try
		{
		 boolean b=  userservice.mymodify(uobj);
		  return new ResponseEntity<String>("Successfully added",HttpStatus.OK);
		}
		catch(UserNotFoundException e)
		{
			return new ResponseEntity<String>("invalid user",HttpStatus.NOT_IMPLEMENTED);		
		}
	  }
}
