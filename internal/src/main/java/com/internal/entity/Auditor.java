package com.internal.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "auditor")
public class Auditor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditorId", updatable = false, nullable = false)
	private int auditorId;
	
	@Column(name = "rsa", nullable = false)
	private int rsa;
	
	@Column(name = "sales", nullable = false)
	private int sales;
	
	@Column(name = "warranty",nullable = false)
	private int warranty;
	
	
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @JsonBackReference(value = "userTOAuditor")
	private User user;
	
	@JsonManagedReference(value = "auditorTOJunctionTable")
	@OneToMany(mappedBy = "auditor", cascade = CascadeType.MERGE)
	private List<AuditAuditor> auditAuditors;

	public Auditor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Auditor(int auditorId, int rsa, int sales, int warranty, User user, List<AuditAuditor> auditAuditors) {
		super();
		this.auditorId = auditorId;
		this.rsa = rsa;
		this.sales = sales;
		this.warranty = warranty;
		this.user = user;
		this.auditAuditors = auditAuditors;
	}

	public int getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(int auditorId) {
		this.auditorId = auditorId;
	}

	public int getRsa() {
		return rsa;
	}

	public void setRsa(int rsa) {
		this.rsa = rsa;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<AuditAuditor> getAuditAuditors() {
		return auditAuditors;
	}

	public void setAuditAuditors(List<AuditAuditor> auditAuditors) {
		this.auditAuditors = auditAuditors;
	}

	
}
