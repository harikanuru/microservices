package com.photoapp.users.PhotoAppApiUsers.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photoapp.users.PhotoAppApiUsers.data.UserEntity;
import com.photoapp.users.PhotoAppApiUsers.models.CreateUserReponseModel;
import com.photoapp.users.PhotoAppApiUsers.models.CreateUserRequestModel;
import com.photoapp.users.PhotoAppApiUsers.service.UserInterface;
import com.photoapp.users.PhotoAppApiUsers.shared.UserDto;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private Environment env;
	ModelMapper mapper = new ModelMapper();

	@Autowired
	UserInterface userService;
	
	@GetMapping("/status/check")
	public String status() {
	
		return "Users Working : "+env.getProperty("local.server.port");
	}
	
	@PostMapping
	public ResponseEntity<CreateUserReponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userRequest) {
		
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = mapper.map(userRequest, UserDto.class);
		
		UserDto createdUser = userService.createUser(userDto);
		CreateUserReponseModel userResponse = mapper.map(createdUser, CreateUserReponseModel.class);

		return ResponseEntity.ok(userResponse).status(HttpStatus.CREATED).build();
	}
}
