package com.dao.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.entity.MemberUser;
import com.utils.SpringUtil;

@Repository
public class UserDaoImpl implements UserDao {

	
	private JdbcTemplate jdbc;//=(JdbcTemplate) SpringUtil.getBean("jdbcTemplate");
	
	public List<Map<String,Object>> queryAllInfo(int currentPage,int limitPage) {
		// TODO Auto-generated method stub
		jdbc =(JdbcTemplate) SpringUtil.getBean("jdbcTemplate");
		String sql="SELECT * FROM (SELECT A.*, ROWNUM RN FROM (select * from LYX.MEMBERUSER m order by m.memberid Asc) A WHERE ROWNUM <="+(currentPage*limitPage)+")WHERE RN >"+((currentPage-1)*limitPage)+"";
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		list = jdbc.queryForList(sql);
		
		return list;
	}

	
	public int totalCount() {
		
		jdbc =(JdbcTemplate) SpringUtil.getBean("jdbcTemplate");
		String sql="select count(*) from LYX.MEMBERUSER";
		
		return jdbc.queryForInt(sql);
	}


	public List<Map<String, Object>>  findByAccounterName(String accountnumber) {
		// TODO Auto-generated method stub
		jdbc =(JdbcTemplate) SpringUtil.getBean("jdbcTemplate");
		String sql="SELECT * FROM tb_test where accountNumber="+"'"+accountnumber+"'";
		System.out.println(sql);	
		List<Map<String, Object>> list =new ArrayList<Map<String,Object>>();
		list = jdbc.queryForList(sql);
		
		//MemberUser user =jdbc.queryForObject(sql, MemberUser.class);
		return list;
	}


	public boolean updateMemberUser(MemberUser memberUser) {
		// TODO Auto-generated method stub
		
		/*jdbc =(JdbcTemplate) SpringUtil.getBean("jdbcTemplate");
		
		String sql="update LYX.memberUser set();";
		jdbc.update(sql, args);*/
		return false;
	}
	
	

}
