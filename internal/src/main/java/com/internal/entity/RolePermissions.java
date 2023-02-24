package com.internal.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "rolePermissions")
public class RolePermissions {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name = "createdAt", nullable = false)
	private Date createdAt;
	@Column(name = "updatedAt", nullable = false)
	private Date updatedAt;
	@Column(name = "createdBy", nullable = false)
	private String createdBy;
	@Column(name = "updatedBy", nullable = false)
	private String updatedBy;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "roleId",referencedColumnName = "roleId" )
	@JsonBackReference(value = "roleToPermission")
	private Role role;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "permissionId",referencedColumnName = "permissionId" )
	@JsonBackReference(value = "permissionToRole")
	private Permission permission;

	public RolePermissions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RolePermissions(int id, Date createdAt, Date updatedAt, String createdBy, String updatedBy, Role role,
			Permission permission) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.role = role;
		this.permission = permission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}


	
}
