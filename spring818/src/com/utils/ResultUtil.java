package com.utils;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;


//import com.alibaba.fastjson.JSONObject;

/**
 * @author lyx
 *	
 * 2015-8-18下午1:39:40
 *
 *com.yr.utils.ResultUtil
 *	TODO 结果工具类
 */
public class ResultUtil {

		/**
		 * 保存json对象
		 */
		private Map<String,Object> results;
		
		//---- key值：		
		
		private static final String MSG="msg";
		private static final String SUCCESS="success";
		/**
		 * 单独对象
		 */
		private static final String OBJ ="obj";
		/**
		 * 列表对象
		 */
		private static final String ROWS="rows";
		
		private static final String TOTAL ="total";
		
		private static final String STATUS="status";

		private static final String SIZE="size";
		
		
		/**
		 *构造函数初始化 
		 */
		public ResultUtil() {
			this.results = new HashMap<String,Object>();
			//默认值
			this.results.put(SUCCESS, true);
		}

		public Map<String, Object> getResult() {
			return results;
		}
		
		public void setResult(Map<String, Object> results) {
			this.results = results;
		}
		
		public  String getMsg() {
			return (String) results.get(MSG);
		}

		public  boolean getSuccess() {
			return (Boolean) results.get(SUCCESS);
		}

		public  String getObj() {
			return OBJ;
		}

		public  void setRows(Object rows) {
			 this.results.put(ROWS,rows);
		}

		public  void setTotal(Integer total) {
			this.results.put(TOTAL, total);
		}
		
		public  void setSize(Integer szie) {
			this.results.put(SIZE, szie);
		}

		
		/**
		 * @param key
		 * @param value
		 * 自定义添加属性标识
		 */
		public void setProperty(String key,Object value)
		{
			try {
				this.results.put(key, value);
			} catch (Exception e) {
				// TODO: handle exception
				//logger.error("出错时：key:"+key+",value："+value+",Json时错误是：",e);
			}
		}
		
		
		
		public void setStatus(String status)
		{
			setProperty(STATUS, status);
		}
	
		
		public void setSuccess(boolean success)
		{
			setProperty(SUCCESS, success);
		}
		
		public void setMsg(String Msg)
		{
			setProperty(MSG, Msg);
		}
		
		public void setTotal(int size)
		{
			setProperty(TOTAL, size);
		}
		
		public void setSize(int size)
		{
			setProperty(SIZE, size);
		}
		
		public void setData(String data)
		{
			setProperty(ROWS, data);
		}
		
		public void setObj(Object obj)
		{
			setProperty(OBJ, obj);
		}
		
		
		
		public String toJsonString()
		{
			JSONObject obj =new JSONObject();
			obj.put("data", this.results);
			return obj.toString();
		}
		
		public static void main(String[] args)
		{
			ResultUtil utils =new ResultUtil();
			System.out.println(utils.toJsonString());
		}
		
}
