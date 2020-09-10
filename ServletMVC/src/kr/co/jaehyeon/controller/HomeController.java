package kr.co.jaehyeon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jaehyeon.model.Test2Service;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.mvc")	//뒤에 mvc가 붙어있는 모든 요청에 대해서 이페이지가 반응함	//동일한 이름을 가진 컨트롤러를 2개이상 가질 수 없다. 하지만 스프링에서는 가능
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Home Controller");
		//요청한 주소를 가져온다.
		String url = request.getRequestURI();
		System.out.println(url);
		
		//View로 사용할 JSP
		String viewName = null;
		
		if(url.contains("main.mvc")) {
			System.out.println("main 요청");
			viewName= "main.jsp";
		}else if(url.contains("test1.mvc")) {
			request.setCharacterEncoding("utf-8");
			System.out.println("test1요청");
			//파라미터 데이터 추출
			String str1 = request.getParameter("data1");
			String str2 = request.getParameter("data2");
			
			System.out.println("str1 : "+ str1);
			
			int number1 = Integer.parseInt(str1);
			int number2 = Integer.parseInt(str2);
			
			int result = number1 + number2;
			
			request.setAttribute("result", result);
			
			viewName = "test1.jsp";
		}else if(url.contains("test2.mvc")) {
			System.out.println("teset2요청");
			//모델 요청
			//int result = Test2Service.minus(request);
			
			
			request.setAttribute("result", result);
			
			
			viewName = "test2.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(viewName);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
