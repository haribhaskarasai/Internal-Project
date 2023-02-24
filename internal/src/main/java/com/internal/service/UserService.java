package com.internal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.internal.entity.User;
import com.internal.entity.UserAddress;
import com.internal.exception.CustomException;
@Service
public interface UserService {
	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */
	public User createUser(User user) throws CustomException;

    /*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	public User readUserById(int userId) throws CustomException;
	public User readUserByMailIdAndPassword(String mailId,String password) throws CustomException;
	public  List<User>  readAllUsers() throws CustomException;
	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */

	public User updateUserById(User user) throws CustomException; // update
	
	
	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	
	public String deleteById(int userId) throws CustomException;
	
	public String deleteByMailIdAndPassword(String mailId,String password) throws CustomException;
	
	/*
	 * *********************************************************
	 * 
	 *                    User address service 
	 *                    
	 * *********************************************************
	 */

	public UserAddress updateUserAddressById(int userId,UserAddress userAddress) throws CustomException; // update
	
	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	
	public  List<UserAddress>  readAllUsersAddress() throws CustomException;

	
	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */

	public UserAddress createUserAddress(UserAddress userAddress) throws CustomException;
	 
	

	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	
	public String deleteByUserAddressId(int userAddressId) throws CustomException;

}
