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
		String viewpage = null;//������ view��
		BCommand command = null;//Ŀ�ǵ� ����
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		//uri �м��ؼ� com �̾Ƴ��� ��Ī
		
		String btitle = request.getParameter("bId");
		if(com.equals("/write_view.do")) {
			viewpage = "write_view.jsp";//�� command��û�� ������ �� �並 �������
		}else if(com.equals("/write.do")) {
			command = new BWriteCommand();	//�� Ŀ�ǵ带 �����϶� (�ؿ��ٱ���)
			command.execute(request,response);//command�������̽� �������̵��� execute����?
			viewpage = "list.do";
		}else if(com.equals("/list.do")) {
			command = new BListCommand();	//�� Ŀ�ǵ带 �����϶� (�ؿ��ٱ���)
			command.execute(request,response);//command�������̽� �������̵��� execute����?
			viewpage = "list.jsp";
		}else if(com.equals("/content_view.do")) {
			command = new BContentCommand();	//�� Ŀ�ǵ带 �����϶� (�ؿ��ٱ���)
			command.execute(request,response);//command�������̽� �������̵��� execute����?
			viewpage = "content_view.jsp";
		}else if(com.equals("/modify.do")) {
			command = new BModifyCommand();	//�� Ŀ�ǵ带 �����϶� (�ؿ��ٱ���)
			command.execute(request,response);//command�������̽� �������̵��� execute����?
			viewpage = "list.do";
		}else if(com.equals("/delete.do")) {
			command = new BDeleteCommand();	//�� Ŀ�ǵ带 �����϶� (�ؿ��ٱ���)
			command.execute(request,response);//command�������̽� �������̵��� execute����?
			viewpage = "list.do";
		}else if(com.equals("/reply.do")) {
			command = new BReplyCommand();	//�� Ŀ�ǵ带 �����϶� (�ؿ��ٱ���)
			command.execute(request,response);//command�������̽� �������̵��� execute����?
			viewpage = "list.do";
		}else if(com.equals("/reply_view.do")) {
			command = new BReplyViewCommand();	//�� Ŀ�ǵ带 �����϶� (�ؿ��ٱ���)
			command.execute(request,response);//command�������̽� �������̵��� execute����?
			viewpage = "reply_view.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher(viewpage);
		disp.forward(request, response);
		//�ش�Ǵ� viewpage�� ������
		
		
		
	}
}
