package com.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
