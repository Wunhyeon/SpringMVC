package kr.co.softcampus.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softcampus.beans.DataBean1;
import kr.co.softcampus.beans.DataBean2;
import kr.co.softcampus.beans.DataBean3;
import kr.co.softcampus.beans.DataBean4;

@Controller
public class TestController {

	@Autowired
	DataBean1 requestBean1;	//타입으로 주입을 받겠다. 그래서 @configuration으로 bean들을 정의해 놓은
							//RootAppContext에 가서 DataBean1타입을 찾는다.
							//그런데 RequestScope가 붙어있다. 그러면 이 클래스에 DataBean1 requestBean1이 주입받는 시점은 새로운 요청이 발생했을때이다.
							//그래서 test1을 요청하게 되면 자동으로 bean객체가 주입되고, 그걸 사용해서 포워딩 한것이다.
							//포워딩은 새로운 요청을 하는 것이 아니라서 requestBean1.setData1("문자열1");등 데이터가 세팅된 빈을 
							//public String result1()에서 그대로 가져다 쓴다.
							//그런데 RequestScope어노테이션을 붙여서 빈을 정의하면, 빈이 주입되는 시기가 새로운 요청이 발생했을 때 객체를 만들어서 주입을 하겠다는 의미.
							//하지만 이거를 request에 저장하겠다는 의미는 아니다. 
							//그냥 이 객체가 주입되는 시점이 새로운 요청이 발생했을 때 새로운 객체를 만들어서 주입하겠다 라는 의미
							//request영역에 집적 저장을 해줘야 함.
	
	@Resource(name = "requestBean2")
	DataBean2 requestBean2;
	
	@Autowired
	DataBean3 requestBean3;
	
	@Resource(name = "requestBean4")
	DataBean4 requestBean4;
	
	
	@GetMapping("/test1")
	public String test1(Model model){
		
		requestBean1.setData1("문자열1");
		requestBean1.setData2("문자열2");
		
		requestBean2.setData3("문자열3");
		requestBean2.setData4("문자열4");
		
		requestBean3.setData5("문자열5");
		requestBean3.setData6("문자열6");
		
		requestBean4.setData7("문자열7");
		requestBean4.setData8("문자열8");
		
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		System.out.printf("requestBean1.data1 : %s\n", requestBean1.getData1());
		System.out.printf("requestBean1.data2 : %s\n", requestBean1.getData2());
		
		System.out.printf("requestBean2.data3 : %s\n", requestBean2.getData3());
		System.out.printf("requestBean2.data4 : %s\n", requestBean2.getData4());
		
		model.addAttribute("requestBean1", requestBean1);
		model.addAttribute("requestBean2", requestBean2);
		model.addAttribute("requestBean3", requestBean3);
		model.addAttribute("requestBean4", requestBean4);
		
		return "result1";
	}
}
