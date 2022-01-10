package com.cg.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.market.dto.UserDetails;

public interface ILoginDao extends JpaRepository<UserDetails, String> {

}
