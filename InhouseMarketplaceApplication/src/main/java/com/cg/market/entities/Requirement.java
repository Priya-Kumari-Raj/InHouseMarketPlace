package com.cg.market.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Requirement")
public class Requirement {
	@Id
	@GeneratedValue
	private Integer reqId;
	@Column(name = "isFulfilled")
	private boolean isFulfilled;
	@Column(name = "fulfilledOn")
	private LocalDate fulfilledOn;
	@OneToOne
	@JoinColumn(name = "prodId")
	private Product prod;

	public Requirement() {
		super();
	}

	public Requirement(Integer reqId, boolean isFulfilled, LocalDate fulfilledOn, Product prod) {
		super();
		this.reqId = reqId;
		this.isFulfilled = isFulfilled;
		this.fulfilledOn = fulfilledOn;
		this.prod = prod;
	}

	@Override
	public String toString() {
		return "Requirement [reqId=" + reqId + ", isFulfilled=" + isFulfilled + ", fulfilledOn=" + fulfilledOn
				+ ", prod=" + prod + "]";
	}

	public Integer getReqId() {
		return reqId;
	}

	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}

	public boolean isFulfilled() {
		return isFulfilled;
	}

	public void setFulfilled(boolean isFulfilled) {
		this.isFulfilled = isFulfilled;
	}

	public LocalDate getFulfilledOn() {
		return fulfilledOn;
	}

	public void setFulfilledOn(LocalDate fulfilledOn) {
		this.fulfilledOn = fulfilledOn;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

}
