package kr.co.softcampus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.softcampus.beans.DataBean1;

@Controller
public class TestController {
	@GetMapping("/input_data")
	public String input_data(DataBean1 databean1) {
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {
		
		Object obj = result.getAllErrors();
		System.out.println(obj);
		
		if(result.hasErrors()) {
			return"input_data";
		}
		
		return"input_success";
	}
}
