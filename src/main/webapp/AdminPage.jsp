<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
    
    if(session.getAttribute("IsAdmin").equals(false))
    {
        response.sendRedirect("/");
    }
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Strona admina</title>
<form action="AdminServlet" method="post">
<input type="text" placeholder="Nazwa uzytkownika" name="userName"></br>
Nadaj uprawnienia admina <input type="checkbox" name="setAdmin"></br>
Nadaj uprawnienia premium <input type="checkbox" name="setPremium"></br>
<input type="submit" value="Zmien uprawnienia">
</form>


</head>
<body>

</body>
</html>