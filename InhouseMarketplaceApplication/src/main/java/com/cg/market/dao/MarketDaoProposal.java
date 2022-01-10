package com.cg.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.market.entities.Proposal;

public interface MarketDaoProposal extends JpaRepository<Proposal, Integer> {

}
