package com.cg.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.market.dto.UserDetails;


@Repository
public interface UserRegisterDao extends JpaRepository<UserDetails, String> {

}
