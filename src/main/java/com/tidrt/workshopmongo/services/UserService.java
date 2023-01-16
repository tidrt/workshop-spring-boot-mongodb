package com.tidrt.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tidrt.workshopmongo.domain.User;
import com.tidrt.workshopmongo.dto.UserDTO;
import com.tidrt.workshopmongo.repository.UserRepository;
import com.tidrt.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		// to do a research first, if do not find our id would throw an exception
		findById(id);
		repository.deleteById(id);
	}
	
	// create the fromDTO method here because we have and repository that can access the database
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
