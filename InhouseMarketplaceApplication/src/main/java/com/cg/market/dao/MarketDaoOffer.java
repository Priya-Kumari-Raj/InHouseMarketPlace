package com.cg.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.market.entities.Offer;

public interface MarketDaoOffer extends JpaRepository<Offer, Integer> {

}
