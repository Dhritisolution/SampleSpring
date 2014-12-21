package com.spring.mvc.poc.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.mvc.poc.exception.SpringCustomException;
import com.spring.mvc.poc.model.Registration;

// Defines DAO operations for the Registration model.
@Service
public interface RegisterationDAO {
	
	public int saveOrUpdate(Registration registeration)  throws SpringCustomException;
	
	public void delete(int id)  throws SpringCustomException;
	
	public Registration get(int registerationId)  throws SpringCustomException;
	
	public List<Registration> list()  throws SpringCustomException;
	
}
