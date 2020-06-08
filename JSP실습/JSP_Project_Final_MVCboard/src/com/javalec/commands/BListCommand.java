package com.javalec.commands;

import com.javalec.dao.*;
import com.javalec.dto.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BListCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) {
		//커맨드 모두가 request에 있는 파라미터들을 가져오거나 dao의 기능을 수행
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}
}
