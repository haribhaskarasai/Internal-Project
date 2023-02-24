package com.internal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.entity.User;
import com.internal.entity.UserAddress;
import com.internal.exception.CustomException;
import com.internal.repository.UserAddressRepository;
import com.internal.repository.UserRepository;
import com.internal.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserAddressRepository userAddressRepository;
	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */

	@Override
	public User createUser(User user) throws CustomException {
		if(userRepository.existsById(user.getUserId())){
			throw new CustomException("User already exits");
		}
		
		return userRepository.save(user);
	}
	
	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */

	@Override
	public User readUserById(int userId) throws CustomException {
		if(userRepository.existsById(userId)){
			return userRepository.findById(userId).get();
		}
		else {
			throw new CustomException("User does not exits");

		}
	}

	@Override
	public User readUserByMailIdAndPassword(String mailId, String password) throws CustomException {
		User userTemp=userRepository.findByMailId(mailId);
		if((userTemp!=null)&&(userTemp.getPassword().equals(password))) {
			return userTemp;
		}
		else {
			throw new CustomException("User does not exits");
		}
	}

	@Override
	public List<User> readAllUsers() throws CustomException {
		if(userRepository.findAll().isEmpty()){
			throw new CustomException("There are no users exits");
		}
		else {
			return userRepository.findAll();

		}
	}
	
	
	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */

	@Override
	public User updateUserById(User user) throws CustomException {
		if(userRepository.existsById(user.getUserId())){
			return userRepository.save(user);
		}
		else {
			throw new CustomException("User does not exits");

		}
	}
	
	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	
	@Override
	public String deleteById(int userId) throws CustomException {
		if(userRepository.existsById(userId)){
			userRepository.deleteById(userId);
			 return "User with " + userId +" deleted";
					 
			 
		}
		else {
			throw new CustomException("User does not exits");

		}
	}

	@Override
	public String deleteByMailIdAndPassword(String mailId, String password) throws CustomException {
		User userTemp=userRepository.findByMailId(mailId);
		if((userTemp!=null)&&(userTemp.getPassword().equals(password))) {
			userRepository.deleteById(userTemp.getUserId());
			return "User with " + mailId +" deleted";
		}
		else {
			throw new CustomException("User does not exits");
		}
	}



	@Override
	public UserAddress createUserAddress(UserAddress userAddress) throws CustomException {
		if(userAddressRepository.existsById(userAddress.getUser().getUserId())){
			throw new CustomException("UserAddress already exits");
		}
		
		return userAddressRepository.save(userAddress);
	}

	@Override
	public List<UserAddress> readAllUsersAddress() throws CustomException {
		if(userAddressRepository.findAll().isEmpty()){
			throw new CustomException("There is no userAddresses");
		}
		else {
			return userAddressRepository.findAll();

		}
	}
	
	
	@Override
	public UserAddress updateUserAddressById(int userId, UserAddress userAddress) throws CustomException {
		if(userAddressRepository.existsById(userId)){
			return userAddressRepository.save(userAddress);
		}
		else {
			throw new CustomException("User does not exits");

		}
	}

	@Override
	public String deleteByUserAddressId(int userAddressId) throws CustomException {
		if(userAddressRepository.existsById(userAddressId)){
			userAddressRepository.deleteById(userAddressId);
			 return "UserAddress with " + userAddressId +" deleted";
					 
			 
		}
		else {
			throw new CustomException("UserAddress does not exits");

		}
	}

	

}
