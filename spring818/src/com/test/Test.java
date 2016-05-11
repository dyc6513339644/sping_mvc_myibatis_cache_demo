package com.test;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.controller.UserController;
import com.dao.Impl.UserDaoImpl;
import com.entity.MemberUser;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.utils.SpringUtil;

public class Test {

	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDaoImpl dao = new UserDaoImpl();
		int totalRecords=4;
		int limitPage=7;
		
		int totalpage;// =(totalRecords+limitPage-1)/limitPage;
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
		System.out.println(totalpage);
		
		List<Map<String,Object>> list =dao.queryAllInfo(2,3);
		
		for (Map<String, Object> map : list) {
			
			for (String key : map.keySet()) {
				
				System.out.print(key+":"+map.get(key)+"\t");
			}
			System.out.println();
		}
	}
*/
	
	public static void main(String[] args) {
		//UserDaoImpl dao = new UserDaoImpl();
	/*	
		UserService service =new UserServiceImpl();
		
		List<Map<String, Object>> list =service.findByAccounterName("liuyuxin");
		//List<Map<String, Object>> list =dao.findByAccounterName("liuyuxin");
		System.out.println("------------------------------");
		
	for (Map<String, Object> map : list) {
			
			for (String key : map.keySet()) {
				
				System.out.print(key+":"+map.get(key)+"\t");
			}
			System.out.println();
		}*/
		UserController user=new UserController();
		user.findByAcconutNumber("liuyuxin");
	}
}
