package com.javalec.commands;
import com.javalec.dao.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BModifyCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) {
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		//커맨드 모두가 request에 있는 파라미터들을 가져오고 dao에서 처리하는 방식
		BDao dao=new BDao();
		dao.modify(bId,bName,bTitle,bContent);
	}
}
