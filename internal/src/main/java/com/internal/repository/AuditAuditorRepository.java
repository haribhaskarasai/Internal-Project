package com.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.entity.AuditAuditor;

public interface AuditAuditorRepository extends JpaRepository<AuditAuditor , Integer> {

}
