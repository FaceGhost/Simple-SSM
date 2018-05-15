<%@ page language="java" import="java.util.*" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="${basepath}statics/jquery-1.12.0.min.js"></script>
<c:set var="basepath"  value="${pageContext.request.contextPath}/"/>
<style>
.app{width: 900px;margin: 50px auto;}
.app .search{padding: 25px 0;text-align: center;	}
.app .back{padding: 25px 0;}
.app a{background: 0 0;color: #4183c4;text-decoration: none;}
.app .data th,td {text-align: center;}
.app table {border-collapse: collapse;border-spacing: 0;display: block;overflow: auto;word-break: normal;word-break: keep-all}
.app table th {font-weight: 700}
.app table td,.app table th {padding: 6px 13px;border: 1px solid #ddd;width:25%;}
.app table tr {background-color: #fff;border-top: 1px solid #ccc}
.app table tr:nth-child(2n) {background-color: #f8f8f8}
</style>