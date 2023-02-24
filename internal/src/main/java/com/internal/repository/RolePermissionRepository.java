package com.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.entity.RolePermissions;

public interface RolePermissionRepository extends JpaRepository<RolePermissions, Integer> {

}
