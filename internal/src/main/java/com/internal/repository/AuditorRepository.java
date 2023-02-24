package com.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.entity.Auditor;

public interface AuditorRepository extends JpaRepository<Auditor, Integer> {

}
