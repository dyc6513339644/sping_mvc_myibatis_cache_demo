

//加载数据
  	$(document).ready(function() {
  		
		var param={};
		param.currentPage=1;
		param.limitPage=2;
  		
		$.post(home+"/user/queryAllInfo",null,
			function(result)
			{
				if(result !=null && result.success)
					{
						var obj =result.rows;
						
						//总的页数是否大于10 如果大于则显示10页，否则显示总的页数
						var visiblePage=result.total>10?10:result.total;
						
						for ( var i = 0; i < obj.length; i++) {
							
							var user =obj[i];
							
							var tr = "<tr><td>"
								+ user.MEMBERNAME
								+ " </td>  <td>"
								+ user.ACCOUNTNUMBER
								+ " </td>  <td>"
								+ user.AGE
								+ " </td>  <td>"
								+ user.GENDER
								+ " </td>  <td>"	
								+ user.BIRTHDAY
								+ " </td>  <td>"						
								+ user.MEMBER_LABEL
								+ " </td>";
							
							$(".userTable").append(tr);
							
							
							//--------------分页
							 $('#pages').twbsPagination({
								 //总共多少页
							        totalPages: result.total,
							     //页面显示几页
							        visiblePages:visiblePage,
							        version: '1.1',
							       // href:home + "/user/queryAllInfo",
							        onPageClick: function (event, page) {
							        	//调用分页函数
							        	setPage(page);
							        }
							    });
						}
						
					}else
						{
						alert(result.msg);
						}
			
		},"json"
		);
		
	});  
  	
  	//实现分页
  	function setPage(currentPage)
  	{
  		var param={};
		param.currentPage=currentPage;
		//每页几条数据
		param.limitPage=5;
		
	
		
		$.post(home+"/user/queryAllInfo",param,
			function(result)
			{
				if(result !=null && result.success)
					{
					
						var obj =result.rows;
						
						$("#pageSize").val(result.size);
						
						//清空上一次查询表中数据
						$('.userTable tbody').empty();
						
						for ( var i = 0; i < obj.length; i++) {
							
							var user =obj[i];
							
							var tr = "<tr><td>"
								+ user.MEMBERNAME
								+ " </td>  <td>"
								+ user.ACCOUNTNUMBER
								+ " </td>  <td>"
								+ user.AGE
								+ " </td>  <td>"
								+ user.GENDER
								+ " </td>  <td>"	
								+ user.BIRTHDAY
								+ " </td>  <td>"						
								+ user.MEMBER_LABEL
								+ " </td>";
							
							$(".userTable").append(tr);
							
						}
						
					}else
						{
						alert(result.msg);
						}
			
		},"json"
		);
  		
  	}
  	
  	