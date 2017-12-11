package Quickshop;

public class Admin extends User implements OrderObserver{

	private int AdminID;
	private String order;
	private static Admin singleton;
	private Profile profile; 
	private User User; 

	protected int getAdminID() {
		return AdminID;
	}

	private void setAdminID(int adminID) {
		AdminID = adminID;
	}
	public void update(Order order);		// Observer design pattern : Observer
	
	// Singleton Design Pattern
	private Admin() {
	}
	
	public static getAddAccount() {
		return profile; 
	}
	public static removeAccount() {
		return User.userID; 
	}

	public static Admin getSingleton() {
	    if (null == singleton) {
	        singleton = new Admin();
	    }
	    return singleton;
	}
	
}



