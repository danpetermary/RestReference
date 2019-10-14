package com.stackroute.myrest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.myrest.exceptions.UserNotFoundException;
import com.stackroute.myrest.model.User;

@Repository("userdao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessfact)
	{
		this.sessionFactory=sessfact;
		
	}
	
	
	public boolean addUser(User u) {
		 sessionFactory.getCurrentSession().save(u);
		 return true;
	}

	public boolean delUser(String userid) throws UserNotFoundException  {
		
		User user=findbyId(userid);
		
		sessionFactory.getCurrentSession().delete(user);
		
		return true;
	}

	public User findbyId(String userId) throws UserNotFoundException {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where userid='" + userId + "'").uniqueResult();
		
		
	}

	public List getAllusers() {
return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public boolean modifyUser(User u) throws UserNotFoundException {
		
		
		
		sessionFactory.getCurrentSession().update(u);		
		
		return true;
	}

}
