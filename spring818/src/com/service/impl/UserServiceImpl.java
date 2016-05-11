package com.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.dao.Impl.UserDaoImpl;
import com.entity.MemberUser;

import com.service.UserService;

/**
 * @author lyx
 *	
 * 2015-8-19上午8:52:16
 *
 *service.impl.UserServiceImpl
 *	TODO
 */

@Service("UserService")
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserDao dao;
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	public List<Map<String, Object>> queryAllInfo(int currentPage,int limitPage) {
		// TODO Auto-generated method stub
		
		return dao.queryAllInfo( currentPage, limitPage);
	}

	public int totalCount() {
		// TODO Auto-generated method stub
		return dao.totalCount();
	}
	
	 //将查询到的数据缓存到myCache中,并使用方法名称加上参数中的userNo作为缓存的key  
    //通常更新操作只需刷新缓存中的某个值,所以为了准确的清除特定的缓存,故定义了这个唯一的key,从而不会影响其它缓存值  
	@Cacheable(value="myCache",key="'findByAccounterName'+#accountnumber")
	public List<Map<String, Object>> findByAccounterName(String accountnumber) {
	
		return dao.findByAccounterName(accountnumber);
	}

	@CacheEvict(value="myCache",key="'findByAccounterName'+#accountnumber")
	public void update(String accountnumber)
	{ 
		System.out.println("移除缓存中此用户号[" + accountnumber + "]对应的用户名[" + dao.findByAccounterName(accountnumber).get(0).get("ACCOUNTNUMBER")+ "]的缓存");
		logger.info("-------移除缓存中此用户号[" + accountnumber + "]对应的用户名[" + accountnumber+ "]的缓存");
	}

	//allEntries为true表示清除value中的全部缓存,默认为false  
	@CacheEvict(value="myCache",allEntries=true)
	public void removeAll()
	{
		System.out.println("移除缓存中的所有数据！");
		logger.info("-------移除缓存中的所有数据！");
	}
}
