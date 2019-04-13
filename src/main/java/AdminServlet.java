

import java.io.IOException;
import java.net.UnknownHostException;

import javax.faces.component.UpdateModelException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

import zad2.UserContext;
import zad2.UserDTO;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserContext _userContext;
	private UserDTO _userDTO;
    
	
    public AdminServlet() throws UnknownHostException {
        super();
        UserContext db = new UserContext();
        _userContext = db;
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("/");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String setAdmin =request.getParameter("setAdmin");
		String setPremium = request.getParameter("setPremium");
		
		this.UpdateUserCred(userName, setAdmin, setPremium);
		
		response.sendRedirect("/ProfilePage.jsp");
	}
	
	
	public void UpdateUserCred(String name, String setAdmin, String setPremium) {
		BasicDBObject credDoc = new BasicDBObject();
		boolean isAdmin = IsCheckBoxChecked(setAdmin);
		boolean isPremium = IsCheckBoxChecked(setPremium);
		
		credDoc.append("IsAdmin", isAdmin);
		credDoc.append("IsPremium", isPremium);
		BasicDBObject newDoc = new BasicDBObject();
		BasicDBObject searchQuery = new BasicDBObject("Name",name);
		BasicDBObject updateQuery = new BasicDBObject("$set", 
				new BasicDBObject().append("Credencials", credDoc));
		
		
		_userContext.dbContext.update(searchQuery, updateQuery);
	}
	public static boolean IsCheckBoxChecked(String b) 
	{
		try {
			if (b.equals("on"))
			{
				return true;
			}
			else 
			{
				return false;
			}
			
		} catch (Exception e)
		{
			
			return false;
		}
	}


}