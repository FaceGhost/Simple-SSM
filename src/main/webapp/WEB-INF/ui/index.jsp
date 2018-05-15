<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./meta.jsp" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${basepath}statics/laypage/laypage.js"></script>
<title>Simple SSM </title>
</head>
<body>
	<div class="app">
		<div class="search">
			<form action="${basepath}test">
				<input name="userName" value="${searchVo.userName}"> 
				<input type="submit" value="Search"/>
				<a href="${basepath}addData">
					<input name="add"  type="button" value="Add"/>
				</a>
			</form>
		</div>
		<div class="data">
			<table>
				<thead>
					<tr>
						<td>ID</td>
						<td>UserName</td>
						<td>Sex</td>
						<td>Addr</td>
						<td>Edit</td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(vo.list) > 0  }">
							<c:forEach items="${vo.list}" var="bean">
								<tr>
									<td>${bean.id }</td>
									<td>${bean.userName }</td>
									<td>
									<c:if test="${bean.sex == 1 }">男 </c:if>
									<c:if test="${bean.sex != 1 }">女 </c:if>
									<td>${bean.addr }</td>
									<td><a href="${basepath}test/updateDataPre?id=${bean.id}">update</a>&nbsp;<a href="${basepath}test/deleteData?id=${bean.id}">Delete	</a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5">
									没有相关数据...
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
					
					
				</tbody>
				<c:if test="${vo.totalPage > 1 }">
					<tfoot>
						<tr>
							<td colspan="5">
							
										<div id="page_div"></div>
								
							</td>
						</tr>
					</tfoot>
				</c:if>
			</table>
		</div>
	 </div>
</body>
<script>
<c:if test="${vo.totalPage > 1}">
laypage({
    cont: $('#page_div'), //容器。值支持id名、原生dom对象，jquery对象,
    pages: ${vo.totalPage}, //总页数
    skip: false, //是否开启跳页
    skin: '#8a8a8a',
    curr: ${vo.pageNo},
    groups: 3, //连续显示分页数
    jump: function(e, first){
    	 if(!first){ //一定要加此判断，否则初始时会无限刷新
	    	var page = e.curr;
	    	window.location.href= '${basepath}test?pageNum='+page;
         }
    }
});
</c:if>
</script>
</html>