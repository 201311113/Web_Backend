package com.javalec.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("/stdForm")
	public String stdForm() {
		return "createPage";
	}
	@RequestMapping("/stdCreate")//직접구현해서 에러검출
	public String stdCreate(@ModelAttribute("std") Student student,BindingResult result) {
		String page = "createDonePage";
		StudentValidate validator = new StudentValidate();
		validator.validate(student, result);
		if(result.hasErrors()) {
			page = "createPage";
		}
		return page;
	}
	@RequestMapping("/stdUtilCreate")//Util을 써서 에러검출
	public String stdutilCreate(@ModelAttribute("std") Student student,BindingResult result) {
		String page = "createDonePage";
		StudentValidateUtil validator = new StudentValidateUtil();
		validator.validate(student, result);
		if(result.hasErrors()) {
			page = "createPage";
		}
		return page;
	}
	@RequestMapping("/stdAnotationCreate")
	public String stdAnoCreate(@ModelAttribute("std") @Valid Student student, BindingResult result) {
		String page = "createDonePage";
		if(result.hasErrors()) {
			page = "createPage";
		}
		return page;
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidateUtil());
	}
}
