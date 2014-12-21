package com.spring.mvc.poc.common.manager;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

//  Database Manager - managing of opening, closing of database
public class DabaBaseManager {
	
	private JdbcTemplate jdbcTemplate;
	private static DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public static JdbcTemplate getJDBCTemplate() throws SQLException{
		return new JdbcTemplate(dataSource);
	}
	
	public static void closeConnection(JdbcTemplate jdbcTemplate) throws SQLException{
		jdbcTemplate.getDataSource().getConnection().close();
	}
	
	public static void commitAndCloseConnection(JdbcTemplate jdbcTemplate) throws SQLException{
		jdbcTemplate.getDataSource().getConnection().commit();
		jdbcTemplate.getDataSource().getConnection().close();
	}
	
}
