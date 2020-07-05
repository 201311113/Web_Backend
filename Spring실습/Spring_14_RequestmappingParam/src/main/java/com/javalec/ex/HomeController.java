package com.javalec.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value = "/getposttest" ,method = RequestMethod.GET)
	public String getorpost(HttpServletRequest hsr, Model m) {
		String id = hsr.getParameter("id");
		m.addAttribute("gpid",id);
		return "getpost";
	}
	
	@RequestMapping(value = "/modelattributetest",method = RequestMethod.GET)
	public String modelattrtest(@ModelAttribute("std") Student student) {
		return "modelattr";
	}
	@RequestMapping("/selections")//url로 인자받아서 A/B로
	public String Selections(HttpServletRequest hsr,Model m) {
		String sel = hsr.getParameter("sel");
		m.addAttribute("selected",sel);
		if(sel.equals("A")){
			return "redirect:Aselect";
		}else {
			return "redirect:Bselect";
		}
	}
	@RequestMapping("/Aselect")
	public String Aselection(HttpServletRequest hsr,Model m) {
		String sel = hsr.getParameter("sel");
		m.addAttribute("selected",sel);
		return "selectredirect/Aselection";
	}
	@RequestMapping("/Bselect")
	public String Bselection() {
		return "selectredirect/Bselection";
	}
}
