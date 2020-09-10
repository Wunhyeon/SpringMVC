package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softcampus.beans.DataBean;

@Controller
public class TestController {
	
	@PostMapping("/test1")
	public String test1(@ModelAttribute DataBean bean) {
		//System.out.printf("data1 : %s\n",bean.getData1());
		//System.out.printf("data2 : %s\n",bean.getData2());
		
		//모델어트리뷰트에서 빈을 주입받으면 이 빈은 request영역에 자동으로 담기게 된다.(모델어트리뷰트 어노테이션은 생략 가능)
		//이때, 파라미터로 넘어오는 데이터의 이름을 보고 해당 빈에 정의되어 있는 프로퍼티와 동일한 이름으로 되어져 있다고 한다면,
		//해당 데이터를 세팅해주게 된다.
		//프로퍼티라는 것은 한 클래스에 변수와 게터세터메소드를 합쳐서 프로퍼티라고 한다.
		return "test1";
	}
	
	@PostMapping("/test2")
	public String test2(@ModelAttribute("testData") DataBean bean) {
		//@ModelAttribute에 이름을 지정해 줄시 생략하면 안된다. 
		//클래스이름이 아닌 "testData"로 주입된다.
		//만약 생략하게 된다면 jsp 페이지에서 클래스이름 (맨앞글자 소문자)로 부를 수 있다.(test1.jsp참조)
		
		return "test2";
	}

}
