package kr.co.softcampus.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.softcampus.beans.DataBean;

@RestController
public class RestTestController {
	
	//@Controller가 붙어있는 컨트롤러는 응답결과로 html데이터를 구성해서 보낸 것이고,
	//@RestController같은 경우는 데이터만 보낸다.
	
	@GetMapping("/test2")
	public ResponseEntity<ArrayList<DataBean>> test2() {
		
		DataBean bean1 = new DataBean("문자열1", 100, 11.11, false);
		DataBean bean2 = new DataBean("문자열2", 200, 21.11, true);
		DataBean bean3 = new DataBean("문자열3", 300, 31.11, false);
		
		ArrayList<DataBean> list = new ArrayList<DataBean>();
		list.add(bean1);
		list.add(bean2);
		list.add(bean3);
		
		//응답결과로 json데이터로 변환하기 위해서 객체로 만들어준다.
		ResponseEntity<ArrayList<DataBean>> entry = new ResponseEntity<ArrayList<DataBean>>(list, HttpStatus.OK);
		
		return entry;
	}

}
