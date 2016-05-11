package com.service;

import java.util.List;
import java.util.Map;

import com.entity.MemberUser;

/**
 * @author lyx
 *	
 * 2015-8-19上午8:51:59
 *
 *service.UserService
 *	TODO
 */
public interface UserService {

	public List<Map<String,Object>> queryAllInfo(int currentPage,int limitPage);
	
	public int totalCount();
	
	public List<Map<String, Object>>  findByAccounterName(String accountnumber);
	
	public void update(String accountnumber);
	
	public void removeAll();
}
