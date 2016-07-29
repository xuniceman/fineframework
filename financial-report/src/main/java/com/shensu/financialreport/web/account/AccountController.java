package com.shensu.financialreport.web.account;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.shensu.web.core.ResultCodeVo;

/**
 * 权限管理模块控制器
 */
@Controller
public class AccountController {
	/**
	 * 登录首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	/**
	 * 登录验证
	 * 
	 * @param name
	 *            用户名
	 * @param password
	 *            密码
	 * @return 验证后json
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResultCodeVo doLogin(HttpServletRequest request, String username, String userpwd, String usercode) {

		ResultCodeVo resultCodeVo = new ResultCodeVo();

		HttpSession session = request.getSession();
		String ucode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);

		if (username == null || "".equals(username)) {
			resultCodeVo.setSuccess(false);
			resultCodeVo.setMsg("请输入用户名");
		} else if (userpwd == null || "".equals(userpwd)) {
			resultCodeVo.setSuccess(false);
			resultCodeVo.setMsg("请输入密码");
		} else if (usercode == null || "".equals(usercode)) {
			resultCodeVo.setSuccess(false);
			resultCodeVo.setMsg("请输入验证码");
		} else if (!ucode.equals(usercode.toLowerCase())) {
			resultCodeVo.setSuccess(false);
			resultCodeVo.setMsg("验证码输入错误");
		} else {
			//这里处理登录验证业务规则
			Map<String,Object> accountMap = new HashMap<String,Object>();
			accountMap.put("id", 1);
			request.getSession().setAttribute("account", accountMap);
			resultCodeVo.setSuccess(true);
			resultCodeVo.setMsg("登录验证通过");
		}
		return resultCodeVo;
	}

	/**
	 * 系统主页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "main";
	}

}
