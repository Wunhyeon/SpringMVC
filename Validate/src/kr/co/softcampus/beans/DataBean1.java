package kr.co.softcampus.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class DataBean1 {
	
	@Size(min = 2, max = 10)	//이 문자열에 들어가는 글자는 최소2, 최대 10. 하지만 이 값을 넘어가게 입력해도 값은 들어간다. 이것은 나중에 유효성 검사를 한다면 이렇게 하겠다는 의미이지 지금 유효성검사를 하겠다는 의미는 아니다.
	private String data1;
	
	@Max(100)	//이 변수에는 최대 100까지만 집어넣겠다는 의미
	private int data2;
	
	
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public int getData2() {
		return data2;
	}
	public void setData2(int data2) {
		this.data2 = data2;
	}
	
	
}
