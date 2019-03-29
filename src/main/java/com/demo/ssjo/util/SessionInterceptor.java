package com.demo.ssjo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录验证拦截
 * 
 * @author Juyon
 *
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LogManager.getLogger(SessionInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) {

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse rsp, Object arg2) throws Exception {
		String header = req.getHeader("User-Agent");
		String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
		HttpSession session = req.getSession();
		LOGGER.info(session.getId() + ":" + uri + "->" + header);
		Object sessionInfo = session.getAttribute(Constants.SESSION_INFO);
		boolean isLogin = false;
		if (sessionInfo != null) {
			isLogin = true;
		} else if (header != null && (header.contains("iPhone") || header.contains("android") || header.contains("Android"))) {
			req.getRequestDispatcher("/noLogin").forward(req, rsp);
		} else {
			rsp.sendRedirect(contextPath+"/noLogin.html");
		}
		return isLogin;
	}
}
