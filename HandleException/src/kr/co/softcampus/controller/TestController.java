package kr.co.softcampus.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(Model model) {
		
//		int [] array1 = {10,20,30};
//		System.out.println("array1 :" + array1[0]);
//		//model.addAttribute("array1", array1[0]);
//		model.addAttribute("array1", array1[10]);
		
		ArrayList<String> list = null;
		list.add("문자열");
		
		return "test1";
	}
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public String exception1() {
		return"error1";
	}
	
	//@ExceptionHandler는 Controller마다 만들어 줘야 한다.
	//만약 Controller 마다 발생 가능한 예외들이 있다면 한번만 정의해서 사용하는 것이 효율적이다.
	//GlobalExceptionHandler를 구현하면 Controller에 정의한 ExceptionHandler중에 
	//해당 오류에 대한 것이 없다면 GlobalExceptionHandler로 이동하여 예외에 관련된 처리를 해주게 된다.

	
}
