package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
	
	//@Controller는 메소드가 반환하는 문자열은 브라우저로 보낼 html데이터를 구성하기 위해 사용할 jsp를 지정해주게 된다.
	
	
	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}

}
