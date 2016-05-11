package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.MemberUser;

/**
 * @author lyx
 *	
 * 2015-8-18下午3:58:39
 *
 *com.dao.Impl.UserDao
 *	TODO
 */
public interface UserDao {

	public List<Map<String,Object>> queryAllInfo(int currentPage,int limitPage);
	
	public int totalCount();
	
	public List<Map<String, Object>>  findByAccounterName(String accountnumber);
	
	public boolean updateMemberUser(MemberUser memberUser);
}
