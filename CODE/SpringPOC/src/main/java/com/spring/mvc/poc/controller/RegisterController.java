package com.spring.mvc.poc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.poc.dao.RegisterationDAO;
import com.spring.mvc.poc.dao.impl.RegisterationDAOImpl;
import com.spring.mvc.poc.exception.ErrorCodes;
import com.spring.mvc.poc.exception.SpringCustomException;
import com.spring.mvc.poc.model.Registration;

// This controller routes accesses to the application to the appropriate handler methods. 
@Controller
public class RegisterController {

	private RegisterationDAO registerDAO = new RegisterationDAOImpl();

	//Save data of registration page 
	@RequestMapping(value = "/saveRegisteration", method = RequestMethod.POST)
	public ModelAndView saveRegisteration(@ModelAttribute Registration register) throws SpringCustomException {
		ModelAndView view =new ModelAndView(); 
		try{
			int registrationId = registerDAO.saveOrUpdate(register);
			if(registrationId > 0){
				register = registerDAO.get(registrationId);
				view.addObject("register", register);
				view.setViewName("registration-successful");
			}
		}catch(Exception e){
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_ACCESS_ERROR,e);
		}
		return view;
	}

	// For Delete registration
	@RequestMapping(value = "/deleteRegisteration", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) throws SpringCustomException {
		try{
			int registerationId = Integer.parseInt(request.getParameter("id"));
			registerDAO.delete(registerationId);
		}catch(Exception e){
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_ACCESS_ERROR,e);
		}
		return new ModelAndView("redirect:/");
	}

	// For Editing of registration
	@RequestMapping(value = "/editRegisteration", method = RequestMethod.GET) 
	public ModelAndView editRegisteration(HttpServletRequest request) throws SpringCustomException {
		ModelAndView model;
		try{
			int registerationId = Integer.parseInt(request.getParameter("id"));
			Registration register = registerDAO.get(registerationId);
			model = new ModelAndView("ContactForm");
			model.addObject("register", register);
		}catch(Exception e){
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_ACCESS_ERROR,e);
		}
		return model;
	}

	public RegisterationDAO getRegisterDAO() {
		return registerDAO;
	}

	public void setRegisterDAO(RegisterationDAO registerDAO) {
		this.registerDAO = registerDAO;
	}

}
