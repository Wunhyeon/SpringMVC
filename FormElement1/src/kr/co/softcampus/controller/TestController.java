package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softcampus.beans.DataBean;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(DataBean bean) {	//@modelAttribute("이름")으로 이름을 따로 저장 안해줄 시, 클래스이름(DataBean)이 첫글자가 소문자로 바껴서(dataBean)으로 저장된다.
		
		bean.setA1("data1");
		bean.setA2("data2");
		bean.setA3("data3");
		bean.setA4("data4");
		
		return "test1";
	}

}
