package com.stackroute.myrest.repository;

import java.util.List;

import com.stackroute.myrest.exceptions.UserNotFoundException;
import com.stackroute.myrest.model.User;

public interface UserDao {
public boolean addUser(User u);
public boolean delUser(String userid) throws UserNotFoundException;
public User findbyId(String userid) throws UserNotFoundException;
public List getAllusers();
public boolean modifyUser(User u) throws UserNotFoundException;
}
