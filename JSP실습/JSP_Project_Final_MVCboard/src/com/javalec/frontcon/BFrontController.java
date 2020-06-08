package com.javalec.frontcon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.commands.*;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("EUC-KR");
		String viewpage = null;//선택할 view값
		BCommand command = null;//커맨드 역할
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		//uri 분석해서 com 뽑아내서 매칭
		
		String btitle = request.getParameter("bId");
		if(com.equals("/write_view.do")) {
			viewpage = "write_view.jsp";//이 command요청이 들어오면 이 뷰를 보여줘라
		}else if(com.equals("/write.do")) {
			command = new BWriteCommand();	//이 커맨드를 실행하라 (밑에줄까지)
			command.execute(request,response);//command인터페이스 오버라이드한 execute였죠?
			viewpage = "list.do";
		}else if(com.equals("/list.do")) {
			command = new BListCommand();	//이 커맨드를 실행하라 (밑에줄까지)
			command.execute(request,response);//command인터페이스 오버라이드한 execute였죠?
			viewpage = "list.jsp";
		}else if(com.equals("/content_view.do")) {
			command = new BContentCommand();	//이 커맨드를 실행하라 (밑에줄까지)
			command.execute(request,response);//command인터페이스 오버라이드한 execute였죠?
			viewpage = "content_view.jsp";
		}else if(com.equals("/modify.do")) {
			command = new BModifyCommand();	//이 커맨드를 실행하라 (밑에줄까지)
			command.execute(request,response);//command인터페이스 오버라이드한 execute였죠?
			viewpage = "list.do";
		}else if(com.equals("/delete.do")) {
			command = new BDeleteCommand();	//이 커맨드를 실행하라 (밑에줄까지)
			command.execute(request,response);//command인터페이스 오버라이드한 execute였죠?
			viewpage = "list.do";
		}else if(com.equals("/reply.do")) {
			command = new BReplyCommand();	//이 커맨드를 실행하라 (밑에줄까지)
			command.execute(request,response);//command인터페이스 오버라이드한 execute였죠?
			viewpage = "list.do";
		}else if(com.equals("/reply_view.do")) {
			command = new BReplyViewCommand();	//이 커맨드를 실행하라 (밑에줄까지)
			command.execute(request,response);//command인터페이스 오버라이드한 execute였죠?
			viewpage = "reply_view.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher(viewpage);
		disp.forward(request, response);
		//해당되는 viewpage로 포워딩
		
		
		
	}
}
