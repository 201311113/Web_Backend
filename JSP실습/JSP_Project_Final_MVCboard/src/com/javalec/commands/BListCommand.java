package com.javalec.commands;

import com.javalec.dao.*;
import com.javalec.dto.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BListCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) {
		//Ŀ�ǵ� ��ΰ� request�� �ִ� �Ķ���͵��� �������ų� dao�� ����� ����
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}
}
