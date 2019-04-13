package zad2;

public class Credencials {
	public boolean IsPremium;
	public boolean IsAdmin;
	
	public Credencials() {
		this.IsAdmin=false;
		this.IsPremium=false;
	}
	
	public boolean isIsPremium() {
		return IsPremium;
	}
	public void setIsPremium(boolean isPremium) {
		IsPremium = isPremium;
	}
	public boolean isIsAdmin() {
		return IsAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		IsAdmin = isAdmin;
	}
}
