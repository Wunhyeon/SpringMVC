package kr.co.softcampus.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softcampus.beans.DataBean1;

@Controller
public class TestController {
	
	@GetMapping("/input_data")
	public String input_data() {
		
		
		return"input_data";
	}
	
	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {
		
//		@Valid
//		-Controller의 메서드에서 주입 받는 Bean에 @Valid를 설정하면 유효성 검사를 실시한다. 
//		이것을 안붙여주면 유효성 조건을 붙여줬다 하더라도 검사를 실시하지 않는다.
//		-유효성 검사 결과를 사용하고자 한다면 BindingResult객체를 주입받아야 한다. 
//		유효성검사를 하고, 그 결과가 BindingResult객체를 통해 넘어오기 때문에 이 객체를 주입받아서 얼마나 유효성검사에서 어긋났는지 확인할 수 있다.
		
		System.out.printf("data1 : %s\n", dataBean1.getData1());
		System.out.printf("data2 : %s\n", dataBean1.getData2());
		
		System.out.printf("BindingResult : %s\n", result);
		
		if(result.hasErrors()) {	//hasErrors()로 위배된 사항이 있는지 확인. hasErrors()가 true이면 위반한 부분이 있는 것이고, false이면 없는 것
			//유효성 위반 결과를 모두 가져온다.
			for(ObjectError obj : result.getAllErrors()) {
				System.out.printf("메시지 : %s\n", obj.getDefaultMessage());
				System.out.printf("코드 : %s\n", obj.getCode());
				System.out.printf("object name : %s\n", obj.getObjectName());
				
				String[] codes = obj.getCodes();
				for(String c1 : codes) {
					System.out.println(c1);
				}
				
				if(codes[0].equals("Size.dataBean1.data1")) {
					System.out.println("data1은 2~10글자를 담을 수 있습니다.");
				}else if(codes[0].equals("Max.dataBean1.data2")) {
					System.out.println("data2는 100이하의 값만 담을 수 있습니다.");
				}
				
				System.out.println("---------------------------------------");
				
			}
			return"input_data";
		}
		
		return"input_success";
		
	}

}
