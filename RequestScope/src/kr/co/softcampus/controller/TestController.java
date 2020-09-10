package kr.co.softcampus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.co.softcampus.beans.DataBean1;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		request.setAttribute("data1", "문자열1");
		
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		
		String data1 = (String)request.getAttribute("data1");
		System.out.printf("data1 : %s\n",data1);
		
		return"result1";
	}
	
	@GetMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("data2","문자열2");
		
		return "forward:/result2";
	}
	
	@GetMapping("/result2")
	public String result2(Model model, HttpServletRequest request) {
		String data2 = (String)model.getAttribute("data2");
		System.out.printf("data2 : %s\n", data2);	//결과 : null //model을 통해서 저장하게 되면 model에 저장이 되는 것이 아니라 request영역에 저장된다.
		//그래서 다시 model을 주입받게 되면 model에 저장된게 아니기 때문에 데이터를 가져올 수 없다.
		
		String data22 = (String)request.getAttribute("data2");
		System.out.printf("data22 : %s\n", data22);
		
		return "result2";
	}
	
	@GetMapping("/test3")
	public ModelAndView test3(ModelAndView mv) {
		
		mv.addObject("data3", "문자열3");
		mv.setViewName("forward:/result3");
		
		return mv;
	}
	
	@GetMapping("/result3")
	public String result3(HttpServletRequest request) {
		String data3 = (String)request.getAttribute("data3");
		System.out.printf("data3 : %s\n",data3);
		
		return "result3";
	}
	
	@GetMapping("/test4")
	public String test4(Model model) {
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("문자열4");
		bean1.setData2("문자열5");
		
		model.addAttribute("bean1",bean1);
		
		return "forward:/result4";
	}
	
	@GetMapping("/result4")
	public String result4(HttpServletRequest request) {
		
		DataBean1 bean1 = (DataBean1)request.getAttribute("bean1");
		String data1 = bean1.getData1();
		String data2 = bean1.getData2();
		
		System.out.printf("data1 : %s\n", data1);
		System.out.printf("data2 : %s\n", data2);
		
		return"result4";
		
	}
	
//	@GetMapping("/test5")
//	public String test5(@ModelAttribute("bean1") DataBean1 bean1) {
//		bean1.setData1("문자열6");
//		bean1.setData2("문자열7");
//		
//		return "test5";
//		//bean1이라는 이름으로 주입된 객체는 request영역에서도 bean1이라는 이름으로 저장된다.
//		//test5에 ${requestScope.bean1.data1 }로 불러올 수 있다.
//	}

	
	@GetMapping("/test5")
	public String test5(@ModelAttribute("bean1") DataBean1 bean1) {
		bean1.setData1("문자열6");
		bean1.setData2("문자열7");
		
		//(@ModelAttribute("bean1") DataBean1 bean1)에서 bean객체를 주입받을 때 ("bean1")이 이름으로 request영역에 저장된다.
		
		return "forward:/result5";
	}
	
//	@GetMapping("/result5")
//	public String result5(@ModelAttribute("bean1") DataBean1 bean1) {
//		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
//		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
//		
//		//결과 : null
//		//이유 : 포워딩되긴 했지만, 둘다 @ModelAttribute("bean1")를 주입받고 있기 때문에
//		//		둘 다 bean1이라는 새로운 객체를 만들고 있다. 그래서 데이터를 유지할 수 없게 된다.
//		
//		return "result5";
//		
//	}
	
	@GetMapping("/result5")
	public String result5(HttpServletRequest request) {
//		DataBean1 bean1 = (DataBean1)request.getAttribute("bean1");
//		
//		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
//		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
//		
		return "result5";
		
	}

}
