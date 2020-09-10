package kr.co.softcampus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.softcampus.beans.DataBean1;

@Controller
@SessionAttributes({"sessionBean1","sessionBean2"})	//이컨트롤러에서 sessionBean1이라는 이름으로  model attribute를 통해서 주입하는 객체는 request가 아니라 session영역에 저장하겠습니다 라는 의미
public class TestController {
	//이때(@SessionAttributes("sessionBean1")를 쓸 때) 객체를 만들어서 반환하는 메소드를 만들어 줘야 한다.
	//브라우저가 최초의 요청이 발생하게 되면 sessionBean1이라는 이름으로 등록되어있는 메소드를 호출해서 반환하는 객체를 세션이 자동으로 저장하고,
	//나중에 매핑되어있는 메소드가 호출이 될 때, 해당객체가 자동으로 주입된다. 
	//일단 세션객체에 저장이 되어있어야 주입이 가능하기 때문에 세션객체에 저장할 수 있도록 @ModelAttribute를 정의해줘야한다.(생략되면 오류발생)
	@ModelAttribute("sessionBean1")
	public DataBean1 sessionBean1() {
		return new DataBean1();
		//새로운 요청이 발생하게 되면 "sessionBean1"이름으로 등록되어 있는 메소드가 자동으로 호출이 되고(@SessionAttributes("sessionBean1")로 위에서 설정했기 때문에),
		//반환하는 객체의 주소값을 메소드 이름으로 세션영역에 저장하게 된다.
	}
	
	@ModelAttribute("sessionBean2")
	public DataBean1 sessionBean2() {
		return new DataBean1();
	}
	
	//일반적인 Session사용
//	@GetMapping("/test1")
//	public String test1(HttpServletRequest request) {
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("data1", "문자열1");
//		
//		
//		return "test1";
//	}
	
	//Spring에서는 Session을 매개변수에 곧바로 직접 받는 것이 가능
	@GetMapping("/test1")
	public String test1(HttpSession session) {
		
		//HttpSession session = request.getSession();
		session.setAttribute("data1", "문자열1");
		
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(HttpSession session) {
		session.setAttribute("data1", "문자열2");
		return "redirect:/result1";
	}
	
	@GetMapping("/test3")
	public String test3(HttpSession session) {
		session.setAttribute("data1", "문자열3");
		return "forward:/result1";
	}
	
	//일반적인 Session사용
//	@GetMapping("/result1")
//	public String result1(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		String data1 = (String)session.getAttribute("data1");
//		System.out.printf("data1 : %s\n",data1);
//		
//		return "result1";
//	}
	
	//Spring에서는 Session을 매개변수로 받는 것이 가능
	@GetMapping("/result1")
	public String result1(HttpSession session) {
		//HttpSession session = request.getSession();
		String data1 = (String)session.getAttribute("data1");
		System.out.printf("data1 : %s\n",data1);
		
		return "result1";
	}
	
	@GetMapping("/test4")
	public String test4(HttpSession session) {
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("문자열4");
		bean1.setData2("문자열5");
		
		session.setAttribute("bean1", bean1);
		return "test4";
	}
	
	@GetMapping("/result2")
	//public String result2(HttpSession session) {
	public String result4(@SessionAttribute("bean1") DataBean1 bean1) {	//이렇게도 bean을 주입해서 설정이 가능하다.(위에서 session에 값을 저장했을 시. 세션영역에 이미 저장되어 있는 객체들을 가져다 쓸때만 가능.)
		//DataBean1 bean1 = (DataBean1)session.getAttribute("bean1");
		
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
		
		return "result2";
	}
	
	@GetMapping("/test5")
	public String test5(@ModelAttribute("sessionBean1") DataBean1 sessionBean1,
						@ModelAttribute("sessionBean2") DataBean1 sessionBean2) {
		
		sessionBean1.setData1("문자열6");
		sessionBean1.setData2("문자열7");
		
		sessionBean2.setData1("문자열8");
		sessionBean2.setData2("문자열9");
		
		return"test5";
	}
	
	@GetMapping("/result3")
	public String result3(@ModelAttribute("sessionBean1") DataBean1 sessionBean1,
						@ModelAttribute("sessionBean2") DataBean1 sessionBean2) {
		System.out.printf("sessionBean1.data1 : %s\n", sessionBean1.getData1());
		System.out.printf("sessionBean1.data2 : %s\n", sessionBean1.getData2());
		
		System.out.printf("sessionBean1.data1 : %s\n", sessionBean2.getData1());
		System.out.printf("sessionBean1.data2 : %s\n", sessionBean2.getData2());
		
		return "result3";
	}
	
	
	
}
