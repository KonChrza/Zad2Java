<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title class="xd">XD</title>
</head>
<body>
<table id="userTable">
<tr>
<th>Nazwa uzytkownika</th>
<th>Czy ma admina</th>
<th>Czy ma premium</th>
</tr>
<tr>
</tr>

</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
var xd = <%out.println((String)session.getAttribute("table"));%>

xd.forEach(function(user){
	if(user.Credencials.IsPremium===true){
	$('#userTable').append("<tr><td>"+user.Name
			+"</td><td class='xd'>"+user.Credencials.IsAdmin+"</td><td class='xd'>"
				+user.Credencials.IsPremium+"</td></tr>");}
	
});
</script>
</body>
</html>


