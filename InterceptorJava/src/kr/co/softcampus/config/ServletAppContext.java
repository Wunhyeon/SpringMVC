package kr.co.softcampus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.softcampus.interceptor.TestInterceptor1;
import kr.co.softcampus.interceptor.TestInterceptor2;
import kr.co.softcampus.interceptor.TestInterceptor3;
import kr.co.softcampus.interceptor.TestInterceptor4;
import kr.co.softcampus.interceptor.TestInterceptor5;
import kr.co.softcampus.interceptor.TestInterceptor6;
import kr.co.softcampus.interceptor.TestInterceptor7;
import kr.co.softcampus.interceptor.TestInterceptor8;

// Spring MVC 프로젝트에 관련된 설정을 하는 클래스
@Configuration
// Controller 어노테이션이 셋팅되어 있는 클래스를 Controller로 등록한다.
@EnableWebMvc
// 스캔할 패키지를 지정한다.
@ComponentScan("kr.co.softcampus.controller")
public class ServletAppContext implements WebMvcConfigurer{
	// Controller의 메서드가 반환하는 jsp의 이름 앞뒤에 경로와 확장자를 붙혀주도록 설정한다.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	// 정적 파일의 경로를 매핑한다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	//인터셉터를 등록한다.
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addInterceptors(registry);
		
		TestInterceptor1 inter1 = new TestInterceptor1();
		TestInterceptor2 inter2 = new TestInterceptor2();
		TestInterceptor3 inter3 = new TestInterceptor3();
		TestInterceptor4 inter4 = new TestInterceptor4();
		TestInterceptor5 inter5 = new TestInterceptor5();
		TestInterceptor6 inter6 = new TestInterceptor6();
		TestInterceptor7 inter7 = new TestInterceptor7();
		TestInterceptor8 inter8 = new TestInterceptor8();
		
		
		InterceptorRegistration reg1 = registry.addInterceptor(inter1);
		InterceptorRegistration reg2 = registry.addInterceptor(inter2);
		InterceptorRegistration reg3 = registry.addInterceptor(inter3);
		InterceptorRegistration reg4 = registry.addInterceptor(inter4);
		InterceptorRegistration reg5 = registry.addInterceptor(inter5);
		InterceptorRegistration reg6 = registry.addInterceptor(inter6);
		InterceptorRegistration reg7 = registry.addInterceptor(inter7);
		InterceptorRegistration reg8 = registry.addInterceptor(inter8);
		
		
		//선언한 순서대로 호출이 되는데 preHandle은 위에서 부터 실행되지만,
		//postHandle과 afterCompletion은 역순으로 호출된다.
		
		
		reg1.addPathPatterns("/test1");	// /test1로 요청을하면 컨트롤러롤 바로 가는게 아니라 위에서 등록한 인터셉터(inter1)를 호출하라는 뜻
		reg2.addPathPatterns("/test1");
		reg3.addPathPatterns("/test2");
//		reg4.addPathPatterns("/test1");
//		reg4.addPathPatterns("/test2");
		reg4.addPathPatterns("/test1","/test2");
		reg5.addPathPatterns("/sub1/test3", "/sub1/test4");
		
		//주소를 등록할 때 직접 주소값 입력 말고 패턴을 입력할 수도 있다.
		//-* : 이름 하나를 의미하며 글자수, 글자 등 제한이 없다.
		//-? : 글자하나를 의미
		//-** : 하위 이름까지 포함하여 글자수, 글자 등 제한이 없다.
		reg6.addPathPatterns("/*");
		reg7.addPathPatterns("/sub1/*");
		reg8.addPathPatterns("/**");
		
		//Pattern 등록
		//-addPathPatterns, <mapping> : Interceptor가 가로채 갈 주소를 등록한다.(위에서 한거)
		//-excludePathPatterns, <exclude-mapping> : Interceptor가 가로채 가지않을 주소를 등록한다.
		reg8.excludePathPatterns("/*");
		
	}
}










