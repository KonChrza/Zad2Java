<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Twozenie Konta</title>
</head>
<body>
<form action="/RegisterServlet" method="post">
Nazwa Uzytkownika :  <input type="text" placeholder="Nazwa Uzytkownika" name="userName"></br>
Haslo :  <input type="text" placeholder="Haslo" name="password"></br>
Powtorz Haslo :  <input type="text" placeholder="Powtorz Haslo" name="confirmPassword"></br>
Email :  <input type="text" placeholder="Email" name="email"></br>
<input type="submit" value="Utworz Konto">

</form>

</body>
</html>