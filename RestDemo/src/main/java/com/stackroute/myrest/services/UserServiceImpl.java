package com.stackroute.myrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.myrest.exceptions.UserNotFoundException;
import com.stackroute.myrest.model.User;
import com.stackroute.myrest.repository.UserDao;

@Service("userservice")
public class UserServiceImpl implements UserService {
 
	 @Autowired
	UserDao userdao;
	 
	 public UserServiceImpl(UserDao udao)
	 {
		 this.userdao=udao;
	 }
	 
	public void myaddUser(User uobj) {
 
	userdao.addUser(uobj);	
	}

	public User myviewUser(String userid) throws UserNotFoundException {
	  
		User userobj= userdao.findbyId(userid);
		if (userobj==null)
			throw new UserNotFoundException("Userid not found");
		else
			return userobj;
	}

	public boolean mydelete(String userid) throws UserNotFoundException {
	 
     return userdao.delUser(userid);
	}

	public boolean mymodify(User uobj) throws UserNotFoundException {
	   
		boolean b=userdao.modifyUser(uobj);
		if (!b)
			throw new UserNotFoundException("id not found");
		else
		return b;
	}

	public List myViewall() {
		return userdao.getAllusers();
		 
	}

}
