package com.javalec.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contents_1")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/content1/home1")
	public String home1(Locale locale, Model model) {
		logger.info("welcome! locale is {}",locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);
		String formdate = dateFormat.format(date);
		model.addAttribute("serverTime",formdate);
		return "/contents_1/content1/home1";
	}
	@RequestMapping("/h")
	public String modeltest(Model model) {
		model.addAttribute("id",30);
		return "/contents_1/modeltest";
	}
	@RequestMapping("/")
	public ModelAndView mandvtest() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",40);
		mv.setViewName("/contents_1/mandvtest");
		return mv;
	}
	
}
