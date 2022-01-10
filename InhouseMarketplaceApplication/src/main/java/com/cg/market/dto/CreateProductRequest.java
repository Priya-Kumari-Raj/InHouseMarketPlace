package com.cg.market.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cg.market.entities.Employee;

public class CreateProductRequest {
	private String title;
	private String description;
	private String category;
	private double price;
	private LocalDate date;
	private Employee emp;

	public CreateProductRequest() {
		super();
	}

	public CreateProductRequest(@NotBlank @Size(min = 2, max = 20) String title,
			@NotBlank @Size(min = 2, max = 20) String description, @NotBlank @Size(min = 2, max = 20) String category,
			double price, LocalDate date) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.date = date;
	}

	public CreateProductRequest(String title, String description, String category, double price, LocalDate date,
			Employee emp) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.date = date;
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "CreateProductRequest [title=" + title + ", description=" + description + ", category=" + category
				+ ", price=" + price + ", date=" + date + ", emp=" + emp + "]";
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}
