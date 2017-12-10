package Quickshop;

public class Admin extends User implements OrderObserver{

	private int AdminID;

	protected int getAdminID() {
		return AdminID;
	}

	private void setAdminID(int adminID) {
		AdminID = adminID;
	}
	
	
}
