package zad2;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

public class UserDTO {
	
	private UserContext _userContext;

	public BasicDBObject GetToTheDb(User user) 
	{
		BasicDBObject document = new BasicDBObject();
		BasicDBObject documentCredencials = new BasicDBObject();
		documentCredencials.put("IsAdmin", user.getCred().IsAdmin );
		documentCredencials.put("IsPremium", user.getCred().IsPremium);
		document.put("Name", user.getName());
		document.put("Password", user.getPassword());
		document.put("Credencials", documentCredencials);
		
		return document;
	}
	
	public User GetUserFromDB(String name, String password) throws UnknownHostException {
		//List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		//obj.add( new BasicDBObject("Name", name));
		//obj.add( new BasicDBObject("Password", password));
		BasicDBObject andQuery = new BasicDBObject("Name",name);
		DBCursor cursor = _userContext.dbContext.find(andQuery);
		String xd = cursor.toArray().toString();
		User user = new User(name, password);
		Credencials cred = new Credencials();
		if (xd.contains("\"IsAdmin\" : true")) 
		{
			cred.setIsAdmin(true);
			user.setCred(cred);
			return user;
		}
		else if (xd.contains("\"IsPremium\" : true")) 
		{
			cred.setIsPremium(true);
			user.setCred(cred);
			return user;
		}
		
		
		return user;
	
	}
	
	
	
	
}
