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
@Table(name = "Product")

public class Product {
	@Id
	@GeneratedValue
	private Integer prodId;
	@Column(name = "prodtitle")
	private String title;
	@Column(name = "proddescription")
	private String description;
	@Column(name = "prodcategory")
	private String category;
	@Column(name = "prodprice")
	private double price;
	@Column(name = "date")
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "empid")
	private Employee employee;

	public Product() {
		super();
	}

	public Product(Integer prodId, String title, String description, String category, double price, LocalDate date,
			Employee employee) {
		super();
		this.prodId = prodId;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.date = date;
		this.employee = employee;
	}

	public Product(String title, String description, String category, double price, LocalDate date, Employee employee) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.date = date;
		this.employee = employee;
	}

	public Product(String title, String description, String category, double price, LocalDate date) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.date = date;
	}

	public Product(Integer prodId, String title, String description, String category, double price, LocalDate date) {
		super();
		this.prodId = prodId;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.date = date;
	}

	public Product(String title, String description, String category, double price) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", title=" + title + ", description=" + description + ", category="
				+ category + ", price=" + price + ", date=" + date + ", employee=" + employee + "]";
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
