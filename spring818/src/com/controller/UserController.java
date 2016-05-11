package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utils.ResultUtil;

import com.entity.MemberUser;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

/**
 * @author lyx
 *	
 * 2015-8-19上午8:53:52
 *
 *com.controller.UserController
 *	TODO
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	//private static final Logger log =Logger.getLogger(UserController.class);
	private static final org.slf4j.Logger logger =org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	 private UserService service; 
	
	
	
	@RequestMapping("/")
	public String userLogin()
	{
		return "/login";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "/login";
	}
	
	
	/**
	 * @param request
	 * @return
	 * 处理登录
	 */
	@RequestMapping("/toLogin")
	public String toLogin(HttpServletRequest request)
	{
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		String rememberMe =request.getParameter("rememberMe");
		
		
		List<Map<String, Object>> userlist = new ArrayList<Map<String,Object>>();
		
		if(username!=null)
		{
			userlist=service.findByAccounterName(username);
			
		/*	System.out.println("password:"+userlist.get(0).get("pwd"));
			
			for (Map<String, Object> map : userlist) {
				for (String key : map.keySet()) {
					
					System.out.print(key+":"+map.get(key));
				}
			}*/
			
			if( !password.isEmpty() && userlist.get(0).get("pwd").equals(password) )
			{
				return "/main";
			}
		}
		
		
		return "redirect:/user/login";
	}
	
	@RequestMapping("/queryUserInfoByUsername")
	public String queryUserInfoByUsername(HttpServletRequest request)
	{
		String username = request.getParameter("username");
		
		List<Map<String, Object>> userlist = new ArrayList<Map<String,Object>>();
		MemberUser user =new MemberUser();
		
		if(username!=null)
		{
			userlist = service.findByAccounterName(username);
			//user=(MemberUser) userlist.get(0);
			for (Map<String, Object> map : userlist) {
				for (String key : map.keySet()) {
					
					user.setAccountNumber(map.get("ACCOUNTNUMBER").toString());
					user.setMemberName(map.get("MEMBERNAME").toString());
					System.out.print(key+":"+map.get(key));
				}
			}
			if(user!=null)
			{
				request.setAttribute("memberUser", user);
				
				return "/myInfo";
			}
		}
		
		return null;
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(HttpServletRequest request)
	{
		String username = request.getParameter("username");
		service.update(username);
		request.setAttribute("accounterNumber", username);
		
		return "/update";
	}
	
	@RequestMapping(value="/removeAll",method=RequestMethod.GET)
	public String removeAll()
	{
		service.removeAll();
		return "/removeAll";
	}
	
	
	
	
	
	
	@RequestMapping("/queryAllInfo")
	@ResponseBody
	public Map<String,Object> queryAllInfo(HttpServletRequest request,HttpServletResponse response)
	{
		
		//日志管理训练
		//当前方法名
		/*String currentMethod=Thread.currentThread().getStackTrace()[1].getMethodName();
		logger.info("currentThread call currentMethod is:"+currentMethod);
		logger.debug("debug");
		logger.error("error");*/
		//PropertyConfigurator.configure( "E:/java/java code/Project/spring818/src/log4j.properties " );
	       /* Logger logger  =  Logger.getLogger(UserController. class );
	        logger.debug( " debug " );
	        logger.error( " error " );*/
		
	/*	System.out.println("-------------------------------------------");
		System.out.println(System.getProperty("user.dir"));*/
		
		ResultUtil result =new ResultUtil();
		
		//数据库总的数据总条数
		int totalRecords =service.totalCount();
		//当前页
		int currentPage=1;
		//每页多少条数据
		int limitPage=5;
		
		//获得当前页 和 每页条数
		if(request.getParameter("currentPage")!=null)
			currentPage=Integer.valueOf(request.getParameter("currentPage"));
		if(request.getParameter("limitPage")!=null)
			limitPage =Integer.valueOf(request.getParameter("limitPage"));
		
		//总页数
		int totalpage;
		if(totalRecords<=limitPage)
		{
			totalpage=1;
		}else if((totalRecords%limitPage)==0)
		{
			totalpage=totalRecords/limitPage;
		}else
		{
			totalpage=(totalRecords/limitPage)+1;
		}
	
		 //根据当前页和每页条数获取结果集
		List<Map<String,Object>> list = service.queryAllInfo(currentPage,limitPage);
		
		
		if(list.size()>0)
		{
			//数据集
			result.setRows(list);
			//总页数
			result.setTotal(totalpage);
			//总记录数
			result.setSize(totalRecords);
			result.setMsg("查询成功！");
		}else
		{
			result.setSuccess(false);
			result.setMsg("查询失败！");
		}
		
		return result.getResult();
	}

	
	@RequestMapping("findByAcconutNumber")
	@ResponseBody
	public Map<String, Object> findByAcconutNumber(String accountnumber)
	{
		ResultUtil result =new ResultUtil();
		List<Map<String,Object>> list =service.findByAccounterName(accountnumber);
		
		if(list!=null)
		{
			result.setMsg("查询成功！");
			result.setRows(list);
			
			logger.info(Thread.currentThread().getStackTrace()[1].getMethodName()+"查询成功！");
			
		}else
		{
			result.setMsg("查询失败！");
			result.setSuccess(false);
			
			logger.info(Thread.currentThread().getStackTrace()[1].getMethodName()+"查询失败！");
		}
		
		return result.getResult();	
	}
	
	
}
