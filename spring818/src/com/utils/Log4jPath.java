package com.utils;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.PropertyConfigurator;

/**
 * @author lyx
 *	
 * 2015-8-20下午4:33:22
 *
 *com.utils.Log4jPath
 *	TODO
 */
public class Log4jPath extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public void init(ServletConfig config,HttpServletRequest request)
	{
		String root =request.getSession().getServletContext().getRealPath("");
				//this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();//getClass().getResource("/").getFile().toString();
				//config.getServletContext().getRealPath("/");
		System.out.println(root);
		String log4jLocation = config.getInitParameter("log4jLocation");
		
		System.setProperty("log4jPath",root);
		
		if(log4jLocation!=null)
		{
			PropertyConfigurator.configure(root+log4jLocation);
		}
	
		
	}

}
