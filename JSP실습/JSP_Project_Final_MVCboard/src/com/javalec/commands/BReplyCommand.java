package com.javalec.commands;
import com.javalec.dao.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BReplyCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bContent = request.getParameter("bContent");
		String bTitle = request.getParameter("bTitle");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		
		BDao dao = new BDao();
		dao.reply(bId,bName,bTitle,bContent,bGroup,bStep,bIndent);
	}
}
