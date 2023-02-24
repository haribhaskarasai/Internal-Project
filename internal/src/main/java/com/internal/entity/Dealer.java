package com.internal.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "dealer")
public class Dealer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dealerCode", updatable = false, nullable = false)
	private int dealerCode; 	
	
	@Column(name = "dealerName", nullable = false , length = 34)
	private String dealerName;
	
	@Column(name = "businessCenter", nullable = false, length = 2)
	private String businessCenter;
	
	@Column(name = "dba", nullable = false, length = 68)
	private String dba;
	
	@Column(name = "dealerPrinciple", nullable = false , length = 60)
	private String dealerPrinciple	;
	
	@Column(name = "letterGreeting", nullable = false , length = 60)
	private 	String letterGreeting;
	
	@Column(name = "salesGroupSize", nullable = false)
	private char salesGroupSize;
	

    @OneToOne(mappedBy = "dealer")
	private DealerAddress dealerAddress;
	
	@JsonManagedReference(value = "dealerAudit")
	@OneToMany(mappedBy = "dealer", cascade = CascadeType.MERGE)
	private List<Audit> audits;

	public Dealer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dealer(int dealerCode, String dealerName, String businessCenter, String dba, String dealerPrinciple,
			String letterGreeting, char salesGroupSize, DealerAddress dealerAddress, List<Audit> audits) {
		super();
		this.dealerCode = dealerCode;
		this.dealerName = dealerName;
		this.businessCenter = businessCenter;
		this.dba = dba;
		this.dealerPrinciple = dealerPrinciple;
		this.letterGreeting = letterGreeting;
		this.salesGroupSize = salesGroupSize;
		this.dealerAddress = dealerAddress;
		this.audits = audits;
	}

	public int getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(int dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getBusinessCenter() {
		return businessCenter;
	}

	public void setBusinessCenter(String businessCenter) {
		this.businessCenter = businessCenter;
	}

	public String getDba() {
		return dba;
	}

	public void setDba(String dba) {
		this.dba = dba;
	}

	public String getDealerPrinciple() {
		return dealerPrinciple;
	}

	public void setDealerPrinciple(String dealerPrinciple) {
		this.dealerPrinciple = dealerPrinciple;
	}

	public String getLetterGreeting() {
		return letterGreeting;
	}

	public void setLetterGreeting(String letterGreeting) {
		this.letterGreeting = letterGreeting;
	}

	public char getSalesGroupSize() {
		return salesGroupSize;
	}

	public void setSalesGroupSize(char salesGroupSize) {
		this.salesGroupSize = salesGroupSize;
	}

	public DealerAddress getDealerAddress() {
		return dealerAddress;
	}

	public void setDealerAddress(DealerAddress dealerAddress) {
		this.dealerAddress = dealerAddress;
	}

	public List<Audit> getAudits() {
		return audits;
	}

	public void setAudits(List<Audit> audits) {
		this.audits = audits;
	}
	
	
}
