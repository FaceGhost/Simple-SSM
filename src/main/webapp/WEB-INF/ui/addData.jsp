<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./meta.jsp" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple SSM </title>
</head>
<body>
	<div class="app">
		<div class="back">
			<a href="${basepath}test"><-</a>
		</div>
		<div class="data">
			<form action="${basepath}test/addData" method="post">
			<table>
				<tbody>
					<tr>
						<td colspan="2">UserName</td>
						<td colspan="2"><input  name="userName"/></td>
					</tr>
					<tr>
						<td colspan="2">Sex</td>
						<td colspan="2">
							男：<input name="sex" value="1" checked="checked" type="radio" value="男"/>
							女：<input name="sex" value="2" type="radio" value="女"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">Addr</td>
						<td colspan="2"><input name="addr"/></td>
					</tr>
				</tbody>
					<tfoot>
						<tr>
							<td colspan="5">
								<input  type="submit" value="Save"/>
								<span class="tip">${err.msg}</span>							
							</td>
						</tr>
					</tfoot>
			</table>
			</form>
		</div>
	 </div>
</body>
</html>