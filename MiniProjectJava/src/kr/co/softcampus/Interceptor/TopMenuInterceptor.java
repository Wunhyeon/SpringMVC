package kr.co.softcampus.Interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{

	//※인터셉터에서는 자동주입을 통해 bean을 주입받지 못한다. 
	//따라서 인터셉터에서 사용할 객체들은 객체들을 인터셉터를 등록하는 쪽에서 주입받은다음, 
	//생성자로 넘겨서 작업해줘야 한다.
	
//	@Autowired
//	private TopMenuService topMenuService;
	
	private TopMenuService topMenuService;
	
	private UserBean loginUserBean;
	
	public TopMenuInterceptor(TopMenuService topMenuService, UserBean loginUserBean) {
		this.topMenuService = topMenuService;
		this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		request.setAttribute("loginUserBean", loginUserBean);
		
		
		return true;
	}
	
	
}
