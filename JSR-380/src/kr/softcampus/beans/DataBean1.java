package kr.softcampus.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class DataBean1 {
	public DataBean1() {
		this.data1 = "abcd";
		this.data2 = "aaa";
		this.data3 = 50;
		this.data4 = 0;
		this.data5 = -1;
		this.data6 = 0;
	}
	
	//JSR-380
	
	//@NotEmpty : 주입된 값의 길이가 0이면 오류 발생. 공백도 글자로 인식한다.
	@NotEmpty
	private String data1;
	//@NotBlank : 주입된 값이 공백을 제거하고 길이가 0이면 오류 발생
	@NotBlank
	private String data2;
	
	//@Positive : 양수가 아니라면 오류 발생. 0은 안된다. 무조건 1이상	
	//※@Positive, @PositiveOrZero, @Negative, @NegativeOrZero가 세팅되어져 있는 변수들은  무조건 정수. 
	//숫자형태만 가능하다. 문자형태로 받으면 오류가 발생한다.
	@Positive
	private int data3;
	
	//@PositiveOrZero : 0또는 양수가 아니라면 오류 발생
	@PositiveOrZero
	private int data4;
	//@Negative : 음수가 아니라면 오류발생. 0도 안됨. 0이들어와도 유효성 검사 실패
	@Negative
	private int data5;
	//@NegativeOrZero : 0또는 음수가 아니라면 오류 발생.
	@NegativeOrZero
	private int data6;
	//@Email : 이메일 형식이 아니라면 오류발생. 중간에 @가 있는지 정도만 확인한다.
	@Email
	private String data7;
	
	
	

	

	
	

	public String getData7() {
		return data7;
	}

	public void setData7(String data7) {
		this.data7 = data7;
	}

	public int getData6() {
		return data6;
	}

	public void setData6(int data6) {
		this.data6 = data6;
	}
	
	public int getData5() {
		return data5;
	}

	public void setData5(int data5) {
		this.data5 = data5;
	}
	
	public int getData4() {
		return data4;
	}


	public void setData4(int data4) {
		this.data4 = data4;
	}
	
	public int getData3() {
		return data3;
	}

	public void setData3(int data3) {
		this.data3 = data3;
	}
	
	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}
	
	public String getData1() {
		return data1;
	}


	public void setData1(String data1) {
		this.data1 = data1;
	}
	
	
	
	

}
