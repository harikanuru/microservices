package com.photoapp.users.PhotoAppApiUsers.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.photoapp.users.PhotoAppApiUsers.data.UserEntity;
import com.photoapp.users.PhotoAppApiUsers.data.UserRepository;
import com.photoapp.users.PhotoAppApiUsers.shared.UserDto;

@Service
public class UserServiceImpl implements UserInterface{

	ModelMapper mapper = new ModelMapper();
	UserRepository userRepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}


	@Override
	public UserDto createUser(UserDto userDetails) {
		
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity user = mapper.map(userDetails, UserEntity.class);
		
		System.out.println(userRepository.save(user).getEncryptedPassword());
		
		Iterable<UserEntity> users = userRepository.findAll();
		users.iterator().hasNext();
		
		UserDto userDto = mapper.map(users, UserDto.class);

		
		return userDto;
	}

}
