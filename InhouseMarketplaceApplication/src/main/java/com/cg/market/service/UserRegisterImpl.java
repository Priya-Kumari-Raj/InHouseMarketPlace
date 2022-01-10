package com.cg.market.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.market.dao.UserRegisterDao;
import com.cg.market.dto.UserDetails;

import com.cg.market.exception.InvalidPasswordException;
import com.cg.market.exception.InvalidUserNameException;

@Service
@Transactional
public class UserRegisterImpl implements UserRegister {

	@Autowired
	private UserRegisterDao uDao;
	
	@Override
	public UserDetails register(UserDetails uDetails) {
		Optional<UserDetails> detailsOpt = uDao.findById(uDetails.getUsername());
		if(!detailsOpt.isPresent()) {
			throw new InvalidUserNameException("Invalid UserName");
		}
		UserDetails details = detailsOpt.get();
		if(!details.getPassword().equals(uDetails.getPassword())) {
			throw new InvalidPasswordException("Invalid Password"); 
		}
		uDetails = uDao.save(uDetails);
		return uDetails;
	}

	
}
