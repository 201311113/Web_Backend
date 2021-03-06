package com.javalec.commands;
import com.javalec.dao.*;
import com.javalec.dto.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BReplyViewCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bId = request.getParameter("bId");
		BDao dao= new BDao();
		BDto dto= dao.reply_view(bId);
		
		request.setAttribute("reply_view", dto);
	}
}
