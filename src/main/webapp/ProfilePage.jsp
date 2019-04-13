<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
    <%@ page import="zad2.Credencials,zad2.User" %>
<!DOCTYPE html>
<%
    
    if(session.getAttribute("UserName") == null)
    {
        response.sendRedirect("/");
    }
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Strona Uzytkownika </title>

<h1>WITAJ <%session.getAttribute("UserName"); %></h1>

<% if(session.getAttribute("IsPremium").equals(true) || 
		session.getAttribute("IsAdmin").equals(true) ) { %>
        <p><a href="/premium.jsp"> Kontent Premium</a></p></br>
        <% } %>
        
<% if(session.getAttribute("IsAdmin").equals(true)) { %>
        <p><a href="/AdminPage.jsp"></i> Strona dla adminow</a></p></br>
        <% } %>
        
        <a href="/TableServlet">Lista uzytkownikow</a>

</head>
<body>

</body>
</html>