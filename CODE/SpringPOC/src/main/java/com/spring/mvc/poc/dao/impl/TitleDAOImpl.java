package com.spring.mvc.poc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.spring.mvc.poc.common.manager.DabaBaseManager;
import com.spring.mvc.poc.dao.TitleDAO;
import com.spring.mvc.poc.exception.ErrorCodes;
import com.spring.mvc.poc.exception.SpringCustomException;
import com.spring.mvc.poc.model.Title;

public class TitleDAOImpl implements TitleDAO{
	
	// get all of titles
	@Override
	public List<Title> getTitles() throws SpringCustomException {
		String sql = "SELECT title_id, title FROM title_master";
		List<Title> titles = null;
		try {
			titles = DabaBaseManager.getJDBCTemplate().query(sql, new RowMapper<Title>() {

				public Title mapRow(ResultSet rs, int rowNum) throws SQLException {
					Title title = new Title();
					title.setTitleId(rs.getInt("title_id"));
					title.setTitleName(rs.getString("title"));
			         
					return title;
				}
				
			});
		} catch (DataAccessException e) {
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_ACCESS_ERROR,e);
		} catch (SQLException e) {
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_BASE_ERROR,e);
		}
		
		return titles;
	}
	
	// get title by title id
	@Override
	public Title getTitle(String titleId) throws SpringCustomException {
		
		String sql = "SELECT title_id, title FROM title_master where title_id = " + titleId;
		List<Title> titles = null;
		Title title =null;
		
		try {
			titles = DabaBaseManager.getJDBCTemplate().query(sql, new RowMapper<Title>() {

				public Title mapRow(ResultSet rs, int rowNum) throws SQLException {
					Title title = new Title();
					title.setTitleId(rs.getInt("title_id"));
					title.setTitleName(rs.getString("title"));
			         
					return title;
				}
			});
			
			if(titles != null && !titles.isEmpty()){
				title = titles.get(0);
			}
			
		} catch (DataAccessException e) {
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_ACCESS_ERROR,e);
		} catch (SQLException e) {
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_BASE_ERROR,e);
		}
		
		return title;
	}
}
