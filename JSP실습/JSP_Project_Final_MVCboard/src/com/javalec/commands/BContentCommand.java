package com.javalec.commands;
import com.javalec.dao.*;
import com.javalec.dto.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BContentCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) {
		
		String bId = request.getParameter("bId");
		//Ŀ�ǵ� ��ΰ� request�� �ִ� �Ķ���͵��� �������� dao���� ó���ϴ� ���
		BDao dao = new BDao();
		BDto dto = dao.contentView(bId);	//
		request.setAttribute("content_view", dto);
	}
	
}
