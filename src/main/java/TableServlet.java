

import java.awt.List;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import zad2.UserContext;
import zad2.UserDTO;

/**
 * Servlet implementation class TableServlet
 */
@WebServlet("/TableServlet")
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	private UserContext _userContext;
	private UserDTO _userDTO;
    public TableServlet() throws UnknownHostException {
        super();
        UserContext db = new UserContext();
        _userContext = db;
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBCursor cursor = _userContext.dbContext.find();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("table", cursor.toArray().toString());
		response.sendRedirect("/userTable.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
