package kr.co.softcampus.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softcampus.beans.DataBean1;
import kr.co.softcampus.validator.DataBean1Validator;

@Controller
public class TestController {

	@GetMapping("/input_data")
	public String input_data(DataBean1 dataBean1) {
		
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {
		
		if(result.hasErrors()) {
			return"input_data";
		}
		
		return"input_success";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DataBean1Validator validator1 = new DataBean1Validator();
		//binder.setValidator(validator1);	//validator가 하나일 때
		binder.addValidators(validator1);	//validator가 여러개일 경우 @Valid를 매개변수로 받는 bean이 여러개일 수 있다는 의미
		//지금은 	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {
		//로 되어있는데, 여기에 객체가 주입이 될 때, binder.addValidators(validator1);여기에 세팅되어져 있는
		//validator들을 다 확인한다. 즉 여기서는 DataBean1Validator를 확인하는 것.
		//먼저 supports로 가서 지금 유효성 검사를 하려는 클래스타입의 객체가 정해져있는 객체인지 확인을 한다.(여기서는 DataBean1인지.(return에서 반환하는 클래스인지))
		//그래서 클래스타입에 따라서 validator를 다 다르게 만들어 주면, 각각 클래스타입에 맞춰서 유효성 검사를 따로따로 할 수 있다.

	}
}
