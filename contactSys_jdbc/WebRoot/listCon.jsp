<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查询所有联系人</title>
</head>

<body>
<center><h3>查询所有联系人(jsp版本)</h3></center>
<form action="${pageContext.request.contextPath }/ConBatchDelServlet" method="post">
<table border="1" align="center" width="800px">
	<tr>
		<th><input type="checkbox" id="all" onclick="checkAll(this)"/>全选/反选<input type="submit" value="批量删除"/></th>
    	<th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>地址</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${conList}" var="con" varStatus="varSta">
    <tr>
    	<td><input type="checkbox" name="item" value="${con.id }"/></td>
    	<td>${varSta.count }</td>
        <td>${con.name }</td>
        <td>${con.gender }</td>
        <td>${con.phone }</td>
        <td>${con.email }</td>
        <td>${con.address }</td>
        <td><a href="${pageContext.request.contextPath }/ConQueryServlet?id=${con.id}">修改</a>&nbsp;<a href="javascript:void(0)" onclick="delCon('${con.id}')">删除</a></td>
    </tr>
    </c:forEach>
    <tr>
    	<td colspan="8" align="center"><a href="${pageContext.request.contextPath }/addCon.jsp">【添加联系人】</a></td>
    </tr>
</table>
</form>

<script type="text/javascript">
	//删除联系人的函数
	function delCon(id){
		//1）提示用户是否继续删除
		if(window.confirm("是否继续删除，一旦删除不能恢复！")){
			//按了“确定”
			//发出删除请求
			var url = "${pageContext.request.contextPath}/ConDelServlet?id="+id;
			window.location.href=url;
		}	
	}
	
	//全选
	function checkAll(obj){
		var itemList = document.getElementsByName("item");
		for(var i=0;i<itemList.length;i++){
			itemList[i].checked = obj.checked; 
		}
	}
</script>
</body>
</html>

