package com.cg.market.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public String handleEmployeeNotFound(EmployeeNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(OfferNotFoundException.class)
	public String handleOfferNotFound(OfferNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public String handleProductNotFound(ProductNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProposalNotFoundException.class)
	public String handleProposalNotFound(ProposalNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RequirementNotFoundException.class)
	public String handleRequirementNotFound(RequirementNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	@ExceptionHandler(Exception.class)
	public String handleError(Exception e) {
		e.printStackTrace();
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public String handleEmployeeExists(EmployeeAlreadyExistsException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ProposalAlreadyExistsException.class)
	public String handleProposalExists(ProposalAlreadyExistsException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ProductAlreadyExistsException.class)
	public String handleProductExists(ProductAlreadyExistsException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(OfferAlreadyExistsException.class)
	public String handleOfferExists(OfferAlreadyExistsException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(RequirementAlreadyExistsException.class)
	public String handleRequirementExists(RequirementAlreadyExistsException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(NotLoggedInException.class)
	public String handleLogin(NotLoggedInException e) {
		return e.getMessage();
	}
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(AuthorizationException.class)
	public String handleLogin(AuthorizationException e) {
		return e.getMessage();
	}
}
