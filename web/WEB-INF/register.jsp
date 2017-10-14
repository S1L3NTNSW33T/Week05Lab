<%-- 
    Document   : register
    Created on : Oct 12, 2017, 9:37:56 AM
    Author     : 725899
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action='ShoppingList' method='GET'>
        Username: <input type='text' name='username'>
        <input type='hidden' name='action' value='register'>
        <input type='submit' value='Register name'></br>
        </form>
        
        ${message}
    </body>
</html>
