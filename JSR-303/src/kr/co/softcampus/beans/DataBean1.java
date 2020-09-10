package kr.co.softcampus.beans;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DataBean1 {
	
	public DataBean1() {
		this.data1 = true;
		this.data2 = false;
		this.data3 = "50";
		this.data4 = "50";
		this.data5 = null;
		this.data6 = "check1";
		this.data7 = "111.111";
		this.data8 = "abcd";
	}
	
	@AssertTrue	//유효성검사. true값만 받는다. 파라미터로 넘어오는 값이 true일 경우에만 통과.true가 아니면 error
	private boolean data1;
	
	@AssertFalse	//유효성검사. false값만 받는다. 파라미터로 넘어오는 값이 false일 경우에만 통과. false가 아니면 error
	private boolean data2;
	
	@Max(value = 100)
	@Min(value = 10)	//(value = '')말고 바로 값 넣어줘도 됨. EX)@Min(10)
	private String data3;
	
	//@DecimalMax(value=값, inclusive = true/false) : 값보다 작거나 같은 값이 들어와야 한다.
	//Inclusive가 false면 값은 포함하지 않기 때문에 작은 값이 들어와야 한다. 생략하면 true
	
	//@DecimalMin(value=값, inclusive = true/false) : 값보다 크거나 같은 값이 들어와야 한다.
	//Inclusive가 false면 값은 포함하지 않기 때문에 큰 값이 들어와야 한다.
	
	//이상/이하 일때는 그냥 Max,Min을 쓰고, 미만/초과 할때 DecimalMax, DecimalMin을 씀
	@DecimalMax(value = "100", inclusive = false)	//100미만이어야 함
	@DecimalMin(value = "10", inclusive = false)	//10초과여야 함
	private String data4;
	
	//@Null : 값이 들어오면 오류가 발생.(값이 null이어야 함)	※길이가 0인거랑 null이랑은 다르다. null은 아예 안들어오는거
	//@NotNull : 값이 들어오지 않으면 오류가 발생
	@Null
	private String data5;
	
	@NotNull
	private String data6;
	
	
	//@Digits(integer = 자릿수, fraction = 자릿수) : 지정된 자릿수의 숫자가 아닐 경우 오류가 발생. Integer - 정수 자릿수, fraction - 실수 자릿수
	//integer와 fraction에 지정해 준 자릿수 이하여야 한다.
	//정수자리는 체크를 하는데 실수자리는 없으면 아예 체크를 안함.(사실 실수자리에 아무것도 안쓰면 0이기 때문에 맞다고도 볼 수 있다.)
	@Digits(integer = 3, fraction = 3)
	private String data7;
	
	//@Size(min = 글자수, max = 글자수) : 지정된 글자수 보다 짧거나 길면 오류가 발생
	@Size(min = 2, max = 10)
	private String data8;
	
	//@Pattern(regexp=정규식) : 주어진 정규식에 위배되면 오류발생
	@Pattern(regexp = "[a-zA-Z]*")	//소문자 a부터z, 대문자 A부터Z까지 로만 구성이 되어야 한다는 정규식
	private String data9;
	
	
	
	
	

	public String getData9() {
		return data9;
	}

	public void setData9(String data9) {
		this.data9 = data9;
	}

	public String getData8() {
		return data8;
	}

	public void setData8(String data8) {
		this.data8 = data8;
	}

	public String getData7() {
		return data7;
	}

	public void setData7(String data7) {
		this.data7 = data7;
	}
	
	public String getData6() {
		return data6;
	}

	public void setData6(String data6) {
		this.data6 = data6;
	}
	
	public String getData5() {
		return data5;
	}


	public void setData5(String data5) {
		this.data5 = data5;
	}
	
	public String getData4() {
		return data4;
	}

	public void setData4(String data4) {
		this.data4 = data4;
	}

	public String getData3() {
		return data3;
	}

	public void setData3(String data3) {
		this.data3 = data3;
	}

	
	public boolean isData2() {
		return data2;
	}

	public void setData2(boolean data2) {
		this.data2 = data2;
	}

	public boolean isData1() {
		return data1;
	}

	public void setData1(boolean data1) {
		this.data1 = data1;
	}
	
	

}
