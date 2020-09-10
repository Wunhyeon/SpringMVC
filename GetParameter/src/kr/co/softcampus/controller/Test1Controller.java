package kr.co.softcampus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class Test1Controller {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String [] data3 = request.getParameterValues("data3");
		
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		for(String str1 : data3) {
			System.out.println("data3 : " + str1);
		}
		
		return "result";
	}
	
	@PostMapping("/test2")
	public String test2(HttpServletRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String [] data3 = request.getParameterValues("data3");
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		if(data3 != null) {
			for(String str1 : data3) {
				System.out.println("data 3 : " + str1);
			}
		}
		
		
		return "result";
	}
	
	@GetMapping("/test3")
	public String test3(WebRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String [] data3 = request.getParameterValues("data3");
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		for(String str1 : data3) {
			System.out.println("data3 : " + str1);
		}
		return "result";
	}
	
	//매개변수로, request객체로 값을 받아서 추출하는 경우 무조건 문자열로 추출이 되기 때문에,
	//보통 Spring MVC에서는 파라미터로 넘어오는 값을 메소드에 변수로 직접 주입받아 사용하는 경우가 많다.(Restful로)
	@GetMapping("/test4/{data1}/{data2}/{data3}")
	public String test4(@PathVariable int data1,
						@PathVariable int data2,
						@PathVariable int data3) {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);
		
		int add = data1 + data2 + data3;
		System.out.println("add :" + add);
		
		return "result";
	}
	
	// 값을 받을 때 아예 정수타입으로 받아버리기(request객체를 이용하면 String타입밖에 안됨)
	@GetMapping("/test5")
	public String test5(@RequestParam int data1, // 자동 형변환이 이루어 진다.
						@RequestParam int data2, 
						@RequestParam int[] data3) {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		for (int a1 : data3) {
			System.out.println("data3 : " + a1);
		}

		return "result";
	}
	
	@GetMapping("/test6")
	public String test6(@RequestParam(value = "data1") int value1,	//'data1'이라는 파라미터는 int value1에 담아주겠다
						@RequestParam(value = "data2") int value2,
						@RequestParam(value = "data3") int [] value3) {
		System.out.println("data1 : " + value1);
		System.out.println("data2 : " + value2);
		for(int a1 : value3) {
			System.out.println("data3 : " + a1);
		}
		return "result";
	}
	
	@GetMapping("/test7")
	public String test7(@RequestParam int data1,
						@RequestParam (required = false) String data2,	//data2로 넘어오는 값이 없으면 null값을 넣어줌
						@RequestParam (defaultValue = "200") int data3) {	//data3으로 넘어오는 값이 없으면 default로 200을 넣어줌. 넘어오는 값이 있으면 넘어오는 값을 넣어줌
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);
		return "result";
	}
	
}
