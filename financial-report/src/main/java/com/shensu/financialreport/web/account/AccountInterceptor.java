package com.shensu.financialreport.web.account;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 权限管理——用户合法性拦截器
 * 
 * @author Administrator
 *
 */
public class AccountInterceptor extends HandlerInterceptorAdapter {

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 从session中获取登录账户数据
		Map<String, Object> accountMap = (Map<String, Object>) request.getSession().getAttribute("account");

		// 如果有继续执行否则转到登录页面
		if (accountMap != null) {
			return true;
		} else {
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			response.sendRedirect(basePath);
			return false;
		}

	}

}
