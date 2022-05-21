<%--
  Created by IntelliJ IDEA.
  User: littlestar
  Date: 2022/5/20
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="评论管理"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="4"/>
<%@include file="common/adminNavigator.jsp" %>

<div class="container" >
    <ol class="breadcrumb">
        <li>评论管理</li>
    </ol>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">买家名称</th>
            <th scope="col">商品</th>
            <th scope="col">评论内容</th>
            <th scope="col">评论时间</th>
            <th scope="col" width="120px">操作</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${comments}" var="m" varStatus="vs">
            <tr>
                <th scope="row">${m.id}</th>
                <td>${m.user.name}</td>
                <td>${m.product.name}</td>
                <td>${m.content}</td>
                <td><fmt:formatDate value="${m.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                <td><a href="delete?id=${m.id}" class="delete-button"><span class="glyphicon glyphicon-trash"></span></a></td>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="common/adminPage.jsp" %>

<%@include file="common/adminFooter.jsp" %>
