package com.robsonfrancadesouza.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robsonfrancadesouza.workshopmongo.domain.User;
import com.robsonfrancadesouza.workshopmongo.dto.UserDTO;
import com.robsonfrancadesouza.workshopmongo.repository.UserRepository;
import com.robsonfrancadesouza.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById (String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public User insert (User user) {
		return repo.insert(user);
	}
	
	public void delete (String id) {
			findById(id);
			repo.deleteById(id);
	}
	
	public User update (User user) {
		User newUser = findById(user.getId());
		updateData (newUser, user);
		return repo.save(newUser);
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		
	}

	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
//end
}
