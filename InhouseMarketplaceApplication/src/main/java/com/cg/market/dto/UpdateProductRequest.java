package com.cg.market.dto;

import java.time.LocalDate;

import com.cg.market.entities.Employee;

public class UpdateProductRequest {

	private Integer prodId;
	private String title;
	private String description;
	private String category;
	private double price;
	private LocalDate date;
	private Employee emp;

	public UpdateProductRequest() {
		super();
	}

	public UpdateProductRequest(Integer prodId, String title, String description, String category, double price,
			LocalDate date) {
		super();
		this.prodId = prodId;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.date = date;
	}

	public UpdateProductRequest(Integer prodId, String title, String description, String category, double price,
			LocalDate date, Employee emp) {
		super();
		this.prodId = prodId;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.date = date;
		this.emp = emp;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "UpdateProductRequest [prodId=" + prodId + ", title=" + title + ", description=" + description
				+ ", category=" + category + ", price=" + price + ", date=" + date + "]";
	}

}
