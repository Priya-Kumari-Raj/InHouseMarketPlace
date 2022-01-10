package com.cg.market.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.market.entities.Product;

@Entity
@Table(name = "Offer")
public class Offer {
	@Id
	@GeneratedValue
	private Integer offerId;
	@Column(name = "isavailable")
	private boolean isAvailable;
	@Column(name = "availableupto")
	private LocalDate availableUpto;
	@OneToOne
	@JoinColumn(name = "ProductId")
	private Product prod;

	public Offer() {
		super();
	}

	public Offer(Integer offerId, boolean isAvailable, LocalDate availableUpto, Product prod) {
		super();
		this.offerId = offerId;
		this.isAvailable = isAvailable;
		this.availableUpto = availableUpto;
		this.prod = prod;
	}

	public Offer(Integer offerId, boolean isAvailable, LocalDate availableUpto) {
		super();
		this.offerId = offerId;
		this.isAvailable = isAvailable;
		this.availableUpto = availableUpto;
	}

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", isAvailable=" + isAvailable + ", availableUpto=" + availableUpto
				+ ", prod=" + prod + "]";
	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public LocalDate getAvailableUpto() {
		return availableUpto;
	}

	public void setAvailableUpto(LocalDate availableUpto) {
		this.availableUpto = availableUpto;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}
}