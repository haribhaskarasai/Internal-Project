package com.internal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.internal.entity.User;
import com.internal.entity.UserAddress;
import com.internal.repository.UserRepository;
import com.internal.service.DocumentService;
import com.internal.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */

	@PostMapping(value = "/createUser")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.ACCEPTED);

	}
	
	@PostMapping(value = "/createUserAddress")
	public ResponseEntity<UserAddress> createUserAddress(@Valid @RequestBody UserAddress userAddress) {

		return new ResponseEntity<UserAddress>(userService.createUserAddress(userAddress), HttpStatus.ACCEPTED);

	}

	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */

	@GetMapping(value = "/getUserById/{userId}")
	public ResponseEntity<User> getUserById(@Valid @PathVariable("userId") int userId) {
		return new ResponseEntity<User>(userService.readUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.readAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllUserAddresses")
	public ResponseEntity<List<UserAddress>> getAllUserAddresses() {
		return new ResponseEntity<List<UserAddress>>(userService.readAllUsersAddress(), HttpStatus.OK);
	}
	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */

	@DeleteMapping(value = "/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@Valid @PathVariable("userId") int userId) {
		return new ResponseEntity<String>(userService.deleteById(userId), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteUserAddress/{userAddresId}")
	public ResponseEntity<String> deleteUserAddress(@Valid @PathVariable("userAddresId") int userAddresId) {
		return new ResponseEntity<String>(userService.deleteByUserAddressId(userAddresId), HttpStatus.OK);
	}

	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */
	

	@PutMapping(value = "/updateUser/{user}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUserById(user), HttpStatus.ACCEPTED);

	}
	
	@PutMapping(value = "/updateUserAddress/{userId}")
	public ResponseEntity<UserAddress> updateUserAddress(@Valid @PathVariable("userId") int userId,@Valid @RequestBody UserAddress userAddress) {
		return new ResponseEntity<UserAddress>(userService.updateUserAddressById(userId,userAddress), HttpStatus.ACCEPTED);

	}

}
