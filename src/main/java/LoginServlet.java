

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import zad2.Credencials;
import zad2.User;
import zad2.UserContext;
import zad2.UserDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserContext _userContext;
	private UserDTO _userDTO;
    public LoginServlet() throws UnknownHostException {
        super();
        UserContext db = new UserContext();
        _userContext = db;
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (userName.isEmpty() || password.isEmpty() || !this.IsPasswordCorrect(userName,password)) 
		{
			response.sendRedirect("/ErrorPageWrongPass.jsp");
		}
		HttpSession session =request.getSession();
		User user = this.GetUserFromDB(userName, password);
		
		session.setAttribute("UserName", user.getName());
		session.setAttribute("IsAdmin", user.getCred().IsAdmin);
		session.setAttribute("IsPremium", user.getCred().IsPremium);
		response.sendRedirect("/ProfilePage.jsp");
		 
		 
	}
	
	
	
	
	private boolean IsPasswordCorrect(String userName, String password) {
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add( new BasicDBObject("Name", userName));
		obj.add( new BasicDBObject("Password", password));
		BasicDBObject andQuery = new BasicDBObject();
		andQuery.put("$and", obj);
		DBCursor cursor = _userContext.dbContext.find(andQuery);
		if (cursor.toArray().isEmpty()) return false;
		else return true;
	}
	private User GetUserFromDB(String name, String password) {
		
		BasicDBObject andQuery = new BasicDBObject("Name",name); //Cala logika jest tutaj bo w userDTO TA SAMA LOGIKA WYWALALA NULLPOINETA COSIE DZIEJE W TEJ JAVIE
		DBCursor cursor = _userContext.dbContext.find(andQuery);
		String xd = cursor.toArray().toString();
		User user = new User(name, password);
		Credencials cred = new Credencials();
		
		if (xd.contains("\"IsAdmin\" : true")) 
		{
			cred.setIsAdmin(true);
			user.setCred(cred);
			
		}
		else if (xd.contains("\"IsPremium\" : true")) 
		{
			cred.setIsPremium(true);
			user.setCred(cred);
			
		}
		return user;
		
		
	}
}
