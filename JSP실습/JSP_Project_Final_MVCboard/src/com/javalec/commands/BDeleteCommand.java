package com.javalec.commands;
import com.javalec.dao.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BDeleteCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) {
		String bId= request.getParameter("bId");
		//Ŀ�ǵ� ��ΰ� request�� �ִ� �Ķ���͵��� �������� dao���� ó���ϴ� ���
		BDao dao = new BDao();
		dao.delete(bId);
	}
}
