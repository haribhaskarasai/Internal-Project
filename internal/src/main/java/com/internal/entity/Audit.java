package com.internal.entity;

import java.time.LocalDate;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "audit")
public class Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditId", updatable = false, nullable = false)
	private int auditId;

	@Column(name = "auditType")
	private AuditType auditType;

	public enum AuditType {
		RSA, SALES, WARRANTY
	}

	@Column(name = "dateAssigned", nullable = false, length = 15)
	private LocalDate dateAssigned;

	@Column(name = "reason", nullable = false, length = 255)
	private String reason;

	@Column(name = "reportsLanguage")
	private ReportsLanguage reportsLanguage;

	public enum ReportsLanguage {
		ENGLISH, SPANISH, FRENCH
	}

	@Column(name = "noOfMonths", nullable = false, length = 2)
	private int noOfMonths;

	@Column(name = "comments", nullable = false, length = 500)
	private String comments;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "dealerCode", referencedColumnName = "dealerCode")
	@JsonBackReference(value = "dealerAudit")
	private Dealer dealer;

	@JsonManagedReference(value = "auditTOJunctionTable")
	@OneToMany(mappedBy = "audit", cascade = CascadeType.MERGE)
	private List<AuditAuditor> auditAuditors;

	public Audit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Audit(int auditId, AuditType auditType, LocalDate dateAssigned, String reason,
			ReportsLanguage reportsLanguage, int noOfMonths, String comments, Dealer dealer,
			List<AuditAuditor> auditAuditors) {
		super();
		this.auditId = auditId;
		this.auditType = auditType;
		this.dateAssigned = dateAssigned;
		this.reason = reason;
		this.reportsLanguage = reportsLanguage;
		this.noOfMonths = noOfMonths;
		this.comments = comments;
		this.dealer = dealer;
		this.auditAuditors = auditAuditors;
	}

	public int getAuditId() {
		return auditId;
	}

	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}

	public AuditType getAuditType() {
		return auditType;
	}

	public void setAuditType(AuditType auditType) {
		this.auditType = auditType;
	}

	public LocalDate getDateAssigned() {
		return dateAssigned;
	}

	public void setDateAssigned(LocalDate dateAssigned) {
		this.dateAssigned = dateAssigned;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ReportsLanguage getReportsLanguage() {
		return reportsLanguage;
	}

	public void setReportsLanguage(ReportsLanguage reportsLanguage) {
		this.reportsLanguage = reportsLanguage;
	}

	public int getNoOfMonths() {
		return noOfMonths;
	}

	public void setNoOfMonths(int noOfMonths) {
		this.noOfMonths = noOfMonths;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public List<AuditAuditor> getAuditAuditors() {
		return auditAuditors;
	}

	public void setAuditAuditors(List<AuditAuditor> auditAuditors) {
		this.auditAuditors = auditAuditors;
	}

}
