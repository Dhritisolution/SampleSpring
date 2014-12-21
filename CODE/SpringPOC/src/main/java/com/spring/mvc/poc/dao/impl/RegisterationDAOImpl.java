package com.spring.mvc.poc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.spring.mvc.poc.common.manager.DabaBaseManager;
import com.spring.mvc.poc.dao.RegisterationDAO;
import com.spring.mvc.poc.exception.ErrorCodes;
import com.spring.mvc.poc.exception.SpringCustomException;
import com.spring.mvc.poc.model.Registration;

public class RegisterationDAOImpl implements RegisterationDAO {

	//save registration actual operation of insertion in database
	@Override
	public int saveOrUpdate(Registration register) throws SpringCustomException {

		int registrationId = 0; 

		try {
			// For update
			if (register.getRegisterationId() > 0) {
				registrationId =register.getRegisterationId();
				String sql = "UPDATE registration SET first_name=?, last_name=?, email_id=?,  "
						+ "mobile_number=? WHERE registration_id=?";

				DabaBaseManager.getJDBCTemplate().update(sql, register.getFirstName(), register.getLastName(),
						register.getEmailId(), register.getMobileNumber(), register.getRegisterationId());

			} else {
				// For insert

				registrationId = getMaxRegId()+1;

				String sql = "INSERT INTO registration (registration_id, first_name, last_name, email_id, mobile_number, title_id)"
						+ " VALUES (?,?, ?, ?, ?, ?)";

				DabaBaseManager.getJDBCTemplate().update(sql, registrationId, register.getFirstName().trim(), register.getLastName().trim(), register.getEmailId().trim(), 
						register.getMobileNumber().trim(), register.getTitleId().trim());
			}
		} catch (DataAccessException e) {
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_ACCESS_ERROR,e);
		} catch (SQLException e) {
			throw new SpringCustomException(e.getMessage(),ErrorCodes.DATA_BASE_ERROR ,e);
		}
		
		return registrationId;
	}
	
	
	// Delete operation of registration
	@Override
	public void delete(int registerationId) throws SpringCustomException  {
		String sql = "DELETE FROM registration WHERE registeration_id=?";
		try {
			DabaBaseManager.getJDBCTemplate().update(sql, registerationId);
		} catch (DataAccessException e) {
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_ACCESS_ERROR, e);
		} catch (SQLException e) {
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_BASE_ERROR, e);
		}
	}
	
	// List of registration
	@Override
	public List<Registration> list() throws SpringCustomException  {
		String sql = "SELECT registeration_id, first_name, last_name, email_id, mobile_number FROM registration";
		List<Registration> listRegistration = null;
		try {
			listRegistration = DabaBaseManager.getJDBCTemplate().query(sql, new RowMapper<Registration>() {

				public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
					Registration register = new Registration();
					register.setRegisterationId(rs.getInt("registeration_id"));
					register.setFirstName(rs.getString("first_name"));
					register.setLastName(rs.getString("last_name"));
					register.setEmailId(rs.getString("email_id"));
					register.setMobileNumber(rs.getString("mobile_number"));

					return register;
				}
			});
		} catch (DataAccessException e) {
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_ACCESS_ERROR, e);
		} catch (SQLException e) {
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_BASE_ERROR, e);
		}

		return listRegistration;
	}
	
	//get object by registration id
	@Override
	public Registration get(int registerationId) throws SpringCustomException  {
		String sql = "SELECT reg.registration_id, reg.first_name,reg.last_name,reg.email_id, reg.mobile_number,tm.title"
				+ " FROM registration reg, title_master tm WHERE tm.title_id = reg.title_id and registration_id=" + registerationId;
		Registration register = null; 
		try { 
			register =DabaBaseManager.getJDBCTemplate().query(sql, new ResultSetExtractor<Registration>() {

				public Registration extractData(ResultSet rs) throws SQLException,
				DataAccessException { 
					Registration register = null;
					if (rs.next()) {
						register= new Registration();
						register.setRegisterationId(rs.getInt(1));
						register.setFirstName(rs.getString(2));
						register.setLastName(rs.getString(3));
						register.setEmailId(rs.getString(4));
						register.setMobileNumber(rs.getString(5));
						register.setTitle(rs.getString(6));
					}

					return register;
				}
			});
		} catch (DataAccessException e) {
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_ACCESS_ERROR, e);
		} catch (SQLException e) {
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_BASE_ERROR, e);
		}
		return register;
	}

	// maximum number of registration id
	public int getMaxRegId() throws SpringCustomException  {
		int maxRegId= 1;
		try {
			maxRegId= DabaBaseManager.getJDBCTemplate().queryForInt("SELECT MAX(registration_id) FROM registration");
		} catch (DataAccessException e) {
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_ACCESS_ERROR, e);
		} catch (SQLException e) {
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_BASE_ERROR, e);
		}

		return maxRegId;
	}

}
