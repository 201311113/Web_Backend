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
		//Ŀ�ǵ� ��ΰ� request�� �ִ� �Ķ���͵��� �������� dao���� ó���ϴ� ���
		BDao dao=new BDao();
		dao.modify(bId,bName,bTitle,bContent);
	}
}
