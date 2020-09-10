package kr.co.softcampus.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softcampus.beans.DataBean1;

@Controller
public class TestController {
	
	@Autowired
	ServletContext application;	
	//ServletContext는 매개변수로 주입을 받지는 못한다. HttpServletRequest로 추출이 가능하기 때문에 그럴 필요가 없기 때문이다.
	//@Autowired를 통해 타입을 통한 주입을 받을 수는 있다.
	
//	@GetMapping("/test1")
//	public String test1(HttpServletRequest request) {
//		
//		ServletContext application = request.getServletContext();	//servletcontext영역에 저장을 해주면 브라우저에 관계없이 똑같은 메모리 공간을 사용하게 된다.
//		application.setAttribute("data1", "문자열1");
//		
//		return"test1";
//	}
	
	@GetMapping("/test1")
	public String test1(){
		
		//ServletContext application = request.getServletContext();	//servletcontext영역에 저장을 해주면 브라우저에 관계없이 똑같은 메모리 공간을 사용하게 된다.
		application.setAttribute("data1", "문자열1");
		
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("data1");
		bean1.setData2("data2");
		
		application.setAttribute("bean1", bean1);
		
		return"test1";
	}
	
//	@GetMapping("/result1")
//	public String result1(HttpServletRequest request) {
//		
//		ServletContext application = request.getServletContext();
//		String data1 = (String)application.getAttribute("data1");
//		
//		//application에 저장하면 브라우저에 상관없이 이용가능하다. (세션은 다른브라우저로 키면 그 정보가 안나오지만 application은 다른브라우저로 켜도 저장된 정보가 나온다.)
//		System.out.printf("data1 : %s\n", data1);
//		
//		return"result1";
//	}
	
	@GetMapping("/result1")
	public String result1() {
		
		//ServletContext application = request.getServletContext();
		String data1 = (String)application.getAttribute("data1");
		
		//application에 저장하면 브라우저에 상관없이 이용가능하다. (세션은 다른브라우저로 키면 그 정보가 안나오지만 application은 다른브라우저로 켜도 저장된 정보가 나온다.)
		System.out.printf("data1 : %s\n", data1);
		
		DataBean1 bean1 = (DataBean1)application.getAttribute("bean1");
		
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
		return"result1";
	}

}
