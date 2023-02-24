package com.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.entity.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Integer> {

}
