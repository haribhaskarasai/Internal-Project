package com.internal.entity;

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
@Table(name = "auditAuditor")
public class AuditAuditor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditAuditorId", updatable = false, nullable = false)
	private int auditAuditorId;
	
	@Column(name = "workAllocation", nullable = false )
	private float workAllocation;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "auditId",referencedColumnName = "auditId" )
	@JsonBackReference(value = "auditTOJunctionTable")
	private Audit audit;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "auditorId",referencedColumnName = "auditorId" )
	@JsonBackReference(value = "auditorTOJunctionTable")
	private Auditor auditor;

	public AuditAuditor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuditAuditor(int auditAuditorId, float workAllocation, Audit audit, Auditor auditor) {
		super();
		this.auditAuditorId = auditAuditorId;
		this.workAllocation = workAllocation;
		this.audit = audit;
		this.auditor = auditor;
	}

	public int getAuditAuditorId() {
		return auditAuditorId;
	}

	public void setAuditAuditorId(int auditAuditorId) {
		this.auditAuditorId = auditAuditorId;
	}

	public float getWorkAllocation() {
		return workAllocation;
	}

	public void setWorkAllocation(float workAllocation) {
		this.workAllocation = workAllocation;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	public Auditor getAuditor() {
		return auditor;
	}

	public void setAuditor(Auditor auditor) {
		this.auditor = auditor;
	}
	
	
}
