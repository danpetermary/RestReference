package com.stackroute.myrest.services;

import java.util.List;

import com.stackroute.myrest.exceptions.UserNotFoundException;
import com.stackroute.myrest.model.User;

public interface UserService {
 public void myaddUser(User uobj);
 public User myviewUser(String userid) throws UserNotFoundException;
 public boolean mydelete(String userid) throws UserNotFoundException;
 public boolean mymodify(User uobj) throws UserNotFoundException;
 public List myViewall();
}
