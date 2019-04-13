<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
    
    if(session.getAttribute("UserName") != null)
    {
        response.sendRedirect("ProfilePage.jsp");
    }
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autoryzacja</title>
</head>
<body>
<form action="LoginServlet" method="post">
Nazwa Uzytkownika :  <input type="text" placeholder="Nazwa Uzytkownika" name="userName"></br>
Haslo :  <input type="text" placeholder="Haslo" name="password"></br>
<input type="submit" value="Zaloguj">

</form>
<a href="/NewRegister.jsp">Zarejstruj sie</a>

</body>
</html>