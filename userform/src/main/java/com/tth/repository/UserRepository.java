package com.tth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tth.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findAll();
	public Optional<User> findById(int id);
	public void deleteById(int id);
	public List<User> findBycity(String city);

}
