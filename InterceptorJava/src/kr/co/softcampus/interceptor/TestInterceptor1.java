package kr.co.softcampus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor1 implements HandlerInterceptor{

	//Controller의 메서드가 호출되기 전에 호출된다.
	//false를 반환하면 요청처리에 대한 진행이 중단된다.(지금 이 메소드(preHandle)까지만 진행되고 그 밑의 메소드들 다 진행 안됨. 이 메소드를 호출한 메소드(이메소드가 묶여있는 : test1)도 진행안됨.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestInterceptor1 - preHandle");
		return false;
	}
	
	//Controller의 메서드가 호출되고 난 후에 호출된다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestInterceptor1 - postHandle");
	}
	
	//View 처리까지 완료되면 호출된다.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestInterceptor1 - afterCompletion");
	}
}
