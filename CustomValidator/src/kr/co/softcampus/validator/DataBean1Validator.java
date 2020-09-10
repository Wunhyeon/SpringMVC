package kr.co.softcampus.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.softcampus.beans.DataBean1;

public class DataBean1Validator implements Validator{

	/*
	 * Validator 인터페이스 구현
	 * 
	 * -먼저 Validator 인터페이스를 구현해야 한다. -supports : 유효성 검사할 데이터를 가지고 있는 객체가 유효성 검사가
	 * 가능한지 확인한다. (@Valid 어노테이션이 붙여져 있는가) -validate : 유효성 검사를 하는 메서드
	 */
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return DataBean1.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "data2", "error2");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data3", "error3");
		/*
		 * ValidateUtils -지정된 값에 대해 유효성 검사를 하는 메서드 -rejectIfEmpty(error객체, "프로퍼티이름",
		 * "코드이름") : 값이 비어있는지 확인한다. 공백은 글자로 취급한다. -rejectIfEmptyOrWhitespace(error객체,
		 * "프로퍼티이름", "코드이름") : 값이 비어있거나 공백으로만 구성되어 있는지 확인한다.(공백을 제거하고 글자길이 확인) -입력값에 문제가
		 * 있다면 error객체에 오류정보를 저장한다. 사용할 오류메시지는 "코드이름.bean객체이름.프로퍼티이름"으로 구성된다.
		 */
		
		DataBean1 bean1 = (DataBean1)target;
		
		String data2 = bean1.getData2();
		String data3 = bean1.getData3();
		
		if(data2.length() > 10) {	//data2의 길이가 10보다 크면 유효성 검사를 실패했다고 한다면
			errors.rejectValue("data2", "error4");
		}
		
		if(data3.contains("@") == false) {
			errors.rejectValue("data3", "error5");
		}
		/*
		 * rejectValue -유효성 조건을 직접 만들어 검사할 때 사용한다. -If문으로 유효성 검사를 해주고 위배시 rejectValue를
		 * 통해 오류 정보를 지정한다. -rejectValue("프로퍼티이름","코드이름(오류이름)") -입력값에 문제가 있다면 error객체에
		 * 오류정보를 저장한다. 사용할 오류메시지는 "코드이름.bean객체이름.프로퍼티이름"으로 구성된다.
		 */
	}

}
