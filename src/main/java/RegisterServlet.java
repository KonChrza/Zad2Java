

import java.io.IOException;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import zad2.User;
import zad2.UserContext;
import zad2.UserDTO;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserContext _userContext;
    private UserDTO _userDTO;
   
    public RegisterServlet() throws UnknownHostException {
        super();
        UserContext db = new UserContext();
        _userContext = db;
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/index.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		if (userName.isEmpty() || password.isEmpty() || email.isEmpty()) {
			response.sendRedirect("/ErrorPageRegister.jsp");
		}else if (this.IsInDb(userName)) {
			response.sendRedirect("/ErrorPageSameUserName.jsp");
		}
		
		User user = new User(userName,password);
		_userDTO = new UserDTO();
		_userContext.dbContext.insert(_userDTO.GetToTheDb(user));
		
		response.sendRedirect("/index.jsp");
		
	}
	
	private boolean IsInDb(String name) {
		
		DBObject query = new BasicDBObject("Name", name);
		DBCursor cursor = _userContext.dbContext.find(query);
		if (cursor.count()==0) return false;
		else return true;
	}

}
