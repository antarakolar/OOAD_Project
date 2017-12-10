package Quickshop;

public class User {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
	private  Profile UserProfile;	
	private String emailid;
	private Order Order;
		private String password;
		public Profile getUserProfile() {
			return UserProfile;
		}
		
	
		protected int UserId;
		
		protected int getUserId() {
			return UserId;
		}
		protected void setUserId(int userId) {
			UserId = userId;
		}
		protected String getEmailid() {
			return emailid;
		}
		protected void setEmailid(String emailid) {
			this.emailid = emailid;
		}
		protected String getPassword() {
			return password;
		}
		protected void setPassword(String password) {
			this.password = password;
		}


		public  Order getOrder(){
				return Order;
		}
		}