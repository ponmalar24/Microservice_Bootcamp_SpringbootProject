package com.tth.service;

import java.util.List;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tth.model.User;
import com.tth.repository.UserRepository;
import com.tth.common.exceptions.IdNotFoundException;

@Transactional
@Service
public class UserService {
	
@Autowired
UserRepository userRepo;
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User getUserById(int id) {
		return userRepo.findById(id).orElseThrow(IdNotFoundException::new);
	}
	
	public List<User> getUserBycity(String city) {
		return userRepo.findBycity(city);
	}

	public User addUserRecord(User user) {
		return userRepo.saveAndFlush(user);
	}
	
	public User updateUserRecord(User user) {
		getUserById(user.getId());
		return userRepo.saveAndFlush(user);
		
	}

	public boolean deleteUser(int id) {
		getUserById(id);
		userRepo.deleteById(id);
		return true;
		
	}

}
