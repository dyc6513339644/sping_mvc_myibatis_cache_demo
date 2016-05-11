package com.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lyx
 *	
 * 2015-8-18下午3:53:19
 *
 *com.utils.SpringUtil
 *	TODO
 */
public class SpringUtil {

	private static ApplicationContext ctx =new ClassPathXmlApplicationContext("springmvc-servlet.xml");
	
	
	public static Object getBean(String beanId)
	{
		return ctx.getBean(beanId);
	}
}
