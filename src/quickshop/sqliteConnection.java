package QuickShop;
import java.sql.*;
import javax.swing.*;
/*******This is mainlly the reference class for creating a connection to the SQL databse (SQlite that was added as an addon to our Browser)*********/
public class sqliteConnection {
	Connection conn=null;   		// Connecting with Sqlite 
	public static Connection dbConnector()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Hariram Natarajan\\Desktop\\OOAD\\Quickshop\\SellerData.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection done!");
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			//JOptionPane.showMessageDialog(null, "Error to connect");
			return null;
		}
	}
}
