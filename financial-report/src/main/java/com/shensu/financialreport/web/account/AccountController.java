package com.shensu.financialreport.web.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.shensu.web.core.DataVo;
import com.shensu.web.core.ResultCodeVo;

/**
 * 权限管理模块控制器
 */
@Controller
public class AccountController {
	
	private String serverUrl = "http://127.0.0.1:8080/solr7/jobs";
	/**
	 * 登录首页
	 * 
	 * @return
	 * @throws IOException 
	 * @throws SolrServerException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() throws SolrServerException, IOException {
		
		HttpSolrClient client = new HttpSolrClient(serverUrl);
        
       
        SolrQuery query = new SolrQuery();
       
        query.set("q", "name:帽子");      
        query.setStart(0);
        query.setRows(10);
         
 
        QueryResponse queryResponse = client.query(query);
  
        SolrDocumentList results = queryResponse.getResults();
       
        long numFound = results.getNumFound();
        System.out.println("总条数:" + numFound);
       
        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
        for (SolrDocument solrDocument : results) {
            System.out.println("id:" + solrDocument.get("id"));
            System.out.println("名称 :" + solrDocument.get("name")); 
        }
        client.close();
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
			// 这里处理登录验证业务规则
			Map<String, Object> accountMap = new HashMap<String, Object>();
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

	/**
	 * 获取系统左边菜单栏目数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/account/sysmenu")
	@SuppressWarnings("unchecked")
	@ResponseBody
	public ResultCodeVo menuData(HttpServletRequest request) {
		ResultCodeVo resultCodeVo = new ResultCodeVo();
		Map<String, Object> accountMap = (Map<String, Object>) request.getSession().getAttribute("account");
		// 这里处理根据账户获取该账户下的功能集合
		resultCodeVo.setSuccess(true);
		resultCodeVo.setData(null);
		return resultCodeVo;
	}

	/**
	 * 系统模块管理——主页面
	 * 
	 * @param moudelId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account/sysmoudel")
	public String sysMoudel(String moudelId, HttpServletRequest request) {
		return "/account/sysmoudel";
	}
	/**
	 * 系统模块管理——查询
	 * @param name
	 * @param subject
	 * @return
	 */
	@RequestMapping(value = "/account/sysmoudel/querymoudel")
	@ResponseBody
	public DataVo queryMoudel(String rows,String page,String startPage)
	{
		DataVo data = new DataVo();
		System.out.println(rows+"---"+page+"--"+startPage);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> s = new HashMap<String,Object>();
		s.put("productid", "FI-SW-01");
		
		list.add(s);
		data.setTotal(28);
		data.setRows(list);
		//"productid":"FI-SW-01","unitcost":10.00,"status":"P","listprice":36.50,"attr1":"Large","itemid":"EST-1"
		return data;
	}
	/**
	 * 系统模块管理——添加页面
	 * 
	 * @param moudelId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account/sysmoudel/createview")
	public String sysMoudelCreateView(String moudelId, HttpServletRequest request) {
		return "/account/sysmoudelcreate";
	}

	/**
	 * 系统模块管理——添加
	 * 
	 * @param moudelId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account/sysmoudel/create")
	public String sysMoudelCreate(String moudelId, HttpServletRequest request) {
		System.out.println("dddddddddddddddddddddddddddd");

		// 处理添加
		request.setAttribute("status", 1);
		return "/account/sysmoudelcreate";
	}

	/**
	 * 系统模块管理——修改页面
	 * 
	 * @param moudelId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account/sysmoudel/updateview")
	public String sysMoudelUpdateView(String moudelId, HttpServletRequest request) {
		return "/account/sysmoudelupdate";
	}

	/**
	 * 系统模块管理——修改
	 * 
	 * @param moudelId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account/sysmoudel/update")
	public String sysMoudelUpdate(String moudelId, HttpServletRequest request) {
		return "/account/sysmoudelupdate";
	}

}
