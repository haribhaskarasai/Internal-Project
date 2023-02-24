package com.internal.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleId", updatable = false, nullable = false)
	private int roleId;
	@Column(name = "title", nullable = false ,length = 256)
	private String title;
	@Column(name = "description", nullable = false ,length = 256)
	private String description;
	@Column(name = "active", nullable = false )
	private boolean active;
	@Column(name = "createdAt", nullable = false)
	private Date createdAt;
	@Column(name = "updatedAt", nullable = false)
	private Date updatedAt;
	@Column(name = "createdBy", nullable = false)
	private String createdBy;
	@Column(name = "updatedBy", nullable = false)
	private String updatedBy;
	
	@JsonManagedReference(value = "userRole")
	@OneToMany(mappedBy = "role", cascade = CascadeType.MERGE)
	private List<User> user;
	
	@JsonManagedReference(value = "roleToPermission")
	@OneToMany(mappedBy = "role", cascade = CascadeType.MERGE)
	private List<RolePermissions> rolePermissions;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int roleId, String title, String description, boolean active, Date createdAt, Date updatedAt,
			String createdBy, String updatedBy, List<User> user, List<RolePermissions> rolePermissions) {
		super();
		this.roleId = roleId;
		this.title = title;
		this.description = description;
		this.active = active;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.user = user;
		this.rolePermissions = rolePermissions;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<RolePermissions> getRolePermissions() {
		return rolePermissions;
	}

	public void setRolePermissions(List<RolePermissions> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}


}
