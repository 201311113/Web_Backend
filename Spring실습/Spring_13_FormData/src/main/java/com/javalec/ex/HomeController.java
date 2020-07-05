package com.javalec.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping("formex/httpservletrequest")//HttpServletRequest사용하여 데이터 받기
	public String exHttpservletrequest(HttpServletRequest hsr, Model m){
		String id = hsr.getParameter("id");
		String pw = hsr.getParameter("pw");
		m.addAttribute("hsrid",id);
		m.addAttribute("hsrpw",pw);
		return "formex/httpservletrequest";
	}
	@RequestMapping("formex/anotation")//어노테이션 이용하여 데이터받기
	public String exAnotation(@RequestParam(value = "id",required=true,defaultValue = "0") String id,@RequestParam(value = "id",required=false,defaultValue = "0") int pw, Model m) {
		m.addAttribute("anoid",id);
		m.addAttribute("anopw",pw);
		return "formex/anotation";
	}
	@RequestMapping(value = "formex/dataObj", method = RequestMethod.GET)//데이터 객체 이용하여 데이터 받고 전달
	public String exDataObj(Student student){
		
		return "formex/dataObj";
	}
	@RequestMapping("formex/expathvar/{id}")
	public String expathVariable(@PathVariable String id,Model mm) {
		mm.addAttribute("pvid",id);
		return "formex/expathvar";
	}
}
