package com.javalec.daoto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Service;


/**
 * Servlet implementation class FrontCon
 */
@WebServlet("*.do")
public class FrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}
	private void actionDo(HttpServletRequest request,HttpServletResponse response) throws ServletException , IOException{
		System.out.println("actionDo");
		
		String uri = request.getRequestURI();
		String conPath =request.getContextPath();
		String command = uri.substring(conPath.length());
		System.out.println(uri + " "+conPath+" "+command);
		if(command.equals("/membersAll.do")) {
			System.out.println("get branch");
			response.setContentType("text/html;charset=EUC-KR");
			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head></body>");
			//여기서 클래스로 작업을 위임한다.
			com.javalec.daoto.Service service = new MembersAllService();
			ArrayList<memberDTO> dtos =service.execute(request,response);
			
			for (int i = 0; i < dtos.size(); i++) {
				memberDTO dto = dtos.get(i);
				String id = dto.getId();
				String pw = dto.getPw();
				String name = dto.getName();
				String eMail = dto.getEMail();
				Timestamp rDate = dto.getRDate();
				String address = dto.getAddress();
				
				writer.println(id + ", " + pw + ", " + name + ", " + eMail + ", " + rDate.toLocalDateTime() + ", " + address + "<hr />");
			}
			
			writer.println("</body></html>");
		}
		
		
	}
}
