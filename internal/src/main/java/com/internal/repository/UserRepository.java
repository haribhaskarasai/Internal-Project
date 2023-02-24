package com.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.internal.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  public  User findByMailId(String mailId);


}
