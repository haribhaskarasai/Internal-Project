package com.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.entity.DealerAddress;

public interface DealerAddressRepository extends JpaRepository<DealerAddress, Integer> {

}
