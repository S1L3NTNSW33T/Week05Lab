<%-- 
    Document   : shoppingList
    Created on : Oct 12, 2017, 9:37:48 AM
    Author     : 725899
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <br/>
        <b>Hello ${username}.</b><br/>
        <br/>
        <a href="ShoppingList?action=logout">Logout</a>

        <h1>List</h1>
        <form action='ShoppingList' method='GET' name='add'>
            Add item <input type='text' name='item'>
            <input type='hidden' name='action' value='add'>
            <input type='submit' value='Add'></br>
        </form>
        
        <c:if test="${fn:length(shoppingList.items) gt 0}">
            <form action='ShoppingList' method='GET' name='remove'>
                <c:forEach var="item" items="${shoppingList.items}">
                    <input type='radio' name='item' value='${item.name}'> ${item.name}</br>
                </c:forEach>
                <input type='hidden' name='action' value='delete'>
                <input type='submit' value='Delete'></br>
            </form>
        </c:if>
    </body>
</html>
