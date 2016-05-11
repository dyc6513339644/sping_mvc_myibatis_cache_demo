package com.test;


import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.entity.MemberUser;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class LoginTest {

	
	@Test
	public void findByOne()
	{
		UserService service =new UserServiceImpl();
		
		List<Map<String, Object>> list =service.findByAccounterName("liuyuxin");
		
	for (Map<String, Object> map : list) {
			
			for (String key : map.keySet()) {
				
				System.out.print(key+":"+map.get(key)+"\t");
			}
			System.out.println();
		}
	}
}
