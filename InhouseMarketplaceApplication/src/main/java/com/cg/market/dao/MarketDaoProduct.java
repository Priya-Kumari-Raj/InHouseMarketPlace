package com.cg.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.market.entities.Product;

public interface MarketDaoProduct extends JpaRepository<Product, Integer> {

}
