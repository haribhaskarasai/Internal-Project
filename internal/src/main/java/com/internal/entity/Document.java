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
@Table(name = "document")
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;


	@Column(name = "country", nullable = false ,length = 256)
	private String country;
	
	@Column(name = "year", nullable = false , length = 4)
	private int year;
	
	@Column(name = "programCode", length = 10)
	private String programCode;
	
	@Column(name = "resourceType", nullable = false, length = 20)
	private String resourceType;
	
	@Column(name = "documentTitle", nullable = false ,length = 150)
	private String documentTitle;
	
	@Column(name = "category", nullable = false , length = 20)
	private String category;
	
	@Column(name = "document", length = 1999999999 )
	private byte[] document;
	
	@Column(name = "revisionDate", nullable = false)
	private Date revisionDate;
	
	@Column(name = "revisionStatus", nullable = false)
	private boolean revisionStatus;
	
	@Column(name = "documentStatus", nullable = false)
	private boolean documentStatus;
	
	@Column(name = "section", nullable = false)
	private String section;
	
	@Column(name = "description" , length = 250)
	private String description;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId",referencedColumnName = "userId" )
	@JsonBackReference(value = "userDocument")
	private User user;

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document(int id, String country, int year, String programCode, String resourceType, String documentTitle,
			String category, byte[] document, Date revisionDate, boolean revisionStatus, boolean documentStatus,
			String section, String description, User user) {
		super();
		this.id = id;
		this.country = country;
		this.year = year;
		this.programCode = programCode;
		this.resourceType = resourceType;
		this.documentTitle = documentTitle;
		this.category = category;
		this.document = document;
		this.revisionDate = revisionDate;
		this.revisionStatus = revisionStatus;
		this.documentStatus = documentStatus;
		this.section = section;
		this.description = description;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getDocumentTitle() {
		return documentTitle;
	}

	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public Date getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(Date revisionDate) {
		this.revisionDate = revisionDate;
	}

	public boolean isRevisionStatus() {
		return revisionStatus;
	}

	public void setRevisionStatus(boolean revisionStatus) {
		this.revisionStatus = revisionStatus;
	}

	public boolean isDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(boolean documentStatus) {
		this.documentStatus = documentStatus;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
