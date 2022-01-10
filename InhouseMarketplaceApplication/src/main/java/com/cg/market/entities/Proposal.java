package com.cg.market.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Proposal")
public class Proposal {
	@Id
	@GeneratedValue
	private Integer propId;
	@Column(name = "proposal")
	private String proposal;
	@Column(name = "amount")
	private double amount;
	@Column(name = "proposalDate")
	private LocalDate proposalDate;
	@Column(name = "isAccepted")
	private boolean isAccepted;
	@ManyToOne
	@JoinColumn(name = "empId")
	private Employee emp;
	@ManyToOne
	@JoinColumn(name = "prodId")
	private Product prod;

	public Proposal(Integer propId, String proposal, double amount, LocalDate proposalDate, boolean isAccepted,
			Employee emp, Product prod) {
		super();
		this.propId = propId;
		this.proposal = proposal;
		this.amount = amount;
		this.proposalDate = proposalDate;
		this.isAccepted = isAccepted;
		this.emp = emp;
		this.prod = prod;
	}

	public Proposal(String proposal, double amount, LocalDate proposalDate, Boolean isAccepted, Employee emp,
			Product prod) {
		super();
		this.proposal = proposal;
		this.amount = amount;
		this.proposalDate = proposalDate;
		this.isAccepted = isAccepted;
		this.emp = emp;
		this.prod = prod;
	}

	public Proposal(String proposal, double amount, boolean isAccepted) {
		super();
		this.proposal = proposal;
		this.amount = amount;
		this.isAccepted = isAccepted;
	}

	public Proposal() {
		super();
	}

	@Override
	public String toString() {
		return "Proposal [propId=" + propId + ", proposal=" + proposal + ", amount=" + amount + ", proposalDate="
				+ proposalDate + ", isAccepted=" + isAccepted + ", emp=" + emp + ", prod=" + prod + "]";
	}

	public Integer getPropId() {
		return propId;
	}

	public void setPropId(Integer propId) {
		this.propId = propId;
	}

	public String getProposal() {
		return proposal;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getProposalDate() {
		return proposalDate;
	}

	public void setProposalDate(LocalDate proposalDate) {
		this.proposalDate = proposalDate;
	}

	public Boolean getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

}
