package com.cg.market.dto;

import java.time.LocalDate;

import com.cg.market.entities.Product;

public class CreateRequirementRequest {

	private Integer reqId;
	private boolean isFulfilled;
	private LocalDate fulfilledOn;
	private Product prod;

	public CreateRequirementRequest() {
		super();
	}

	public CreateRequirementRequest(Integer reqId, boolean isFulfilled, LocalDate fulfilledOn, Product prod) {
		super();
		this.reqId = reqId;
		this.isFulfilled = isFulfilled;
		this.fulfilledOn = fulfilledOn;
		this.prod = prod;
	}

	@Override
	public String toString() {
		return "CreateRequirementRequest [reqId=" + reqId + ", isFulfilled=" + isFulfilled + ", fulfilledOn="
				+ fulfilledOn + ", prod=" + prod + "]";
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
