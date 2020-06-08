package com.javalec.commands;
import com.javalec.dao.*;
import com.javalec.dto.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BWriteCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) {
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		//Ŀ�ǵ� ��ΰ� request�� �ִ� �Ķ���͵��� �������� dao���� ó���ϴ� ���
		BDao  dao =new BDao();
		dao.write(bName,bTitle,bContent);

	}
}
