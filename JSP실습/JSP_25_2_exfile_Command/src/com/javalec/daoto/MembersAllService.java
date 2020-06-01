package com.javalec.daoto;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MembersAllService implements Service {
	public MembersAllService() {
		
	}
	
	@Override
	public ArrayList<memberDTO> execute(HttpServletRequest request,HttpServletResponse response){
		
		memberDAO dao = memberDAO.getInstance();
		return dao.membersAll();
	}
}
