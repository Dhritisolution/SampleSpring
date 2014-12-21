package com.spring.mvc.poc.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.mvc.poc.exception.SpringCustomException;
import com.spring.mvc.poc.model.Title;

// Defines DAO operations for Title views.
@Service
public interface TitleDAO {
	
	public List<Title> getTitles() throws SpringCustomException;
	
	public Title getTitle(String titleId) throws SpringCustomException;
	
}
