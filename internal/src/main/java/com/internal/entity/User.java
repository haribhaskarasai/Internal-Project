package com.internal.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", updatable = false, nullable = false)
	private int userId;

	@Column(name = "mailId", nullable = false)
	private String mailId;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "middleInitial", nullable = false)
	private String middleInitial;
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

	
	@JsonManagedReference(value = "userDocument")
	@OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
	private List<Document> document;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "roleId",referencedColumnName = "roleId" )
	@JsonBackReference(value = "userRole")
	private Role role;
	
	@JsonManagedReference(value = "userTOAuditor")
    @OneToOne(cascade = CascadeType.ALL )
	private Auditor auditor;
	
	@JsonManagedReference(value = "userTOUserAddress")
    @OneToOne(mappedBy = "user")
	private UserAddress userAddress;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String mailId, String firstName, String lastName, String password, String middleInitial,
			boolean active, Date createdAt, Date updatedAt, String createdBy, String updatedBy, List<Document> document,
			Role role, Auditor auditor, UserAddress userAddress) {
		super();
		this.userId = userId;
		this.mailId = mailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.middleInitial = middleInitial;
		this.active = active;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.document = document;
		this.role = role;
		this.auditor = auditor;
		this.userAddress = userAddress;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
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

	public List<Document> getDocument() {
		return document;
	}

	public void setDocument(List<Document> document) {
		this.document = document;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Auditor getAuditor() {
		return auditor;
	}

	public void setAuditor(Auditor auditor) {
		this.auditor = auditor;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

}
