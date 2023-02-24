package com.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.entity.Audit;


public interface AuditRepository  extends JpaRepository<Audit, Integer> {

}
