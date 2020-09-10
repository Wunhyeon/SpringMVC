package kr.co.softcampus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.softcampus.beans.DataBean;
import kr.co.softcampus.beans.DataBean2;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(@RequestParam Map<String, String> map, @RequestParam List<String> data3) {
		String data1 = map.get("data1");
		String data2 = map.get("data2");
		String data33 = map.get("data3");
		
		System.out.printf("data1 : %s\n", data1);
		System.out.printf("data2 : %s\n", data2);
		System.out.printf("data3 : %s\n", data33);	//같은 이름으로 2개의 값을 넘겨주었을 때 앞에 있는 값만 넘어온다. 동일명으로 전달되는 파라미터가 2개이상이라면 List로 주입받아야 한다.
		
		for(String str : data3) {
			System.out.printf("data3 : %s\n", str);
		}
		
		//parameter로 넘어오는 데이터가 숫자로 되있다고 하더라도 map이나 list로 받을 때 형변환 할 수 없다. 무조건 String으로 받아줘야 한다.
		return "result";
	}
	
	@GetMapping("/test2")
	/*public String test2(@ModelAttribute DataBean bean1,
						@ModelAttribute DataBean2 bean2) {*/
	public String test2(DataBean bean1,
						DataBean2 bean2) {
		System.out.printf("data1 : %d\n",bean1.getData1());
		System.out.printf("data2 : %d\n",bean1.getData2());
		
		for(int a1 : bean1.getData3()) {
			System.out.printf("data3 : %d\n",a1);
		}
		
		System.out.printf("bean2.data1 : %d\n",bean2.getData1());
		System.out.printf("bean2.data2 : %d\n", bean2.getData2());
		
		return "result";
		
	}
}
