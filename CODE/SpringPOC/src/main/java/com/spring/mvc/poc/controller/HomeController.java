package com.spring.mvc.poc.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.poc.dao.TitleDAO;
import com.spring.mvc.poc.dao.impl.TitleDAOImpl;
import com.spring.mvc.poc.exception.ErrorCodes;
import com.spring.mvc.poc.exception.SpringCustomException;
import com.spring.mvc.poc.model.Title;

// Handles requests for the application home page.
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private TitleDAO titleDAO = new TitleDAOImpl();

	// Simply selects the home view to render by returning its name
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws SpringCustomException {
		logger.info("RegisterationPage is loaded! The client locale is {}.", locale);

		try{
			model.addAttribute("titlesMap", getTitles() );
		}catch(Exception e){
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_GENERAL_ERROR,e);
		}

		return "registration";
	}
	
	// Redirect to registration page
	@RequestMapping(value = "backToRegistration", method = RequestMethod.GET)
	public ModelAndView backToRegistration() throws SpringCustomException {
		return new ModelAndView("registration").addObject("titlesMap", getTitles());
	}
	
	// Get map of titles
	public Map<Integer, String> getTitles() throws SpringCustomException {
		List<Title> titles;
		Map<Integer, String> titlesMap;
		try{
			titles = titleDAO.getTitles();
			titlesMap = new HashMap<Integer, String>();
			for (Title title: titles){
				titlesMap.put(title.getTitleId(), title.getTitleName());
			}
		}catch(Exception e){
			throw new SpringCustomException(e.getMessage(), ErrorCodes.DATA_GENERAL_ERROR,e);
		}
		return titlesMap;
	}

}
