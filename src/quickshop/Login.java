package QuickShop;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField textEmailID;
	private JPasswordField txtpasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection =null;

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = sqliteConnection.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EmailID");
		lblNewLabel.setBounds(62, 50, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(62, 126, 79, 16);
		frame.getContentPane().add(lblPassword);
		
		textEmailID = new JTextField();
		textEmailID.setBounds(228, 47, 116, 22);
		frame.getContentPane().add(textEmailID);
		textEmailID.setColumns(10);
		
		txtpasswordField = new JPasswordField();
		txtpasswordField.setBounds(228, 123, 112, 22);
		frame.getContentPane().add(txtpasswordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String emailID = textEmailID.getText();
				String password = txtpasswordField.getText();
				
				if(emailID.equals("admin.com")&& password.equals("1234")) {
					JOptionPane.showMessageDialog(frame,"Login done");
					AdminPage admin = new AdminPage();
					admin.setVisible(true);
				}
				else if(emailID.equals("antara.com")&& password.equals("1234")){
					JOptionPane.showMessageDialog(frame,"Login done");
					CustomerPage customer = new CustomerPage();
					customer.setVisible(true);		
					try {
						String query="select * from CustomerDetails where EmailID=? and password=?";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.setString(1,textEmailID.getText() );
						pst.setString(2, txtpasswordField.getText());
						
						ResultSet rs=pst.executeQuery();
						int count =0;
						while(rs.next()) {
							count=count+1;
						}
						if (count ==1) {
							JOptionPane.showMessageDialog(null, "Correct EmailID and Password");
						}
						else if(count>1) {
							JOptionPane.showMessageDialog(null, "Duplicate EmailID and Password");
						}
						else {
							JOptionPane.showMessageDialog(null, "Incorrect EmailID and Password");
						}
						rs.close();
						pst.close();
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null,e);
					}
					
				}
				else if(emailID.equals("shriya.com")&& password.equals("1234")){
					JOptionPane.showMessageDialog(frame,"Login done");
					CustomerPage customer = new CustomerPage();
					customer.setVisible(true);		
					try {
						String query="select * from CustomerDetails where EmailID=? and password=?";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.setString(1,textEmailID.getText() );
						pst.setString(2, txtpasswordField.getText());
						
						ResultSet rs=pst.executeQuery();
						int count =0;
						while(rs.next()) {
							count=count+1;
						}
						if (count ==1) {
							JOptionPane.showMessageDialog(null, "Correct EmailID and Password");
						}
						else if(count>1) {
							JOptionPane.showMessageDialog(null, "Duplicate EmailID and Password");
						}
						else {
							JOptionPane.showMessageDialog(null, "Incorrect EmailID and Password");
						}
						rs.close();
						pst.close();
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null,e);
					}
					
				}
				else if(emailID.equals("Hariram")&& password.equals("1234")){
					JOptionPane.showMessageDialog(frame,"Login done");
								
					
				}
				else {

					try {
						String query="select * from SellerDetails where emailID=? and password=?";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.setString(1,textEmailID.getText() );
						pst.setString(2, txtpasswordField.getText());
						
						ResultSet rs=pst.executeQuery();
						int count =0;
						while(rs.next()) {
							count=count+1;
						}
						if (count ==1) {
							//JOptionPane.showMessageDialog(frame,"Login Correct");
							SellerPage seller = new SellerPage();
							seller.setVisible(true);
							JOptionPane.showMessageDialog(null, "Correct EmailID and Password");
						}
						else if(count>1) {
							JOptionPane.showMessageDialog(null, "Duplicate EmailID and Password");
						}
						else {
							JOptionPane.showMessageDialog(null, "Incorrect EmailID and Password");
						}
						rs.close();
						pst.close();
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null,e);
					}
				}
				
				
			}
		});
		btnNewButton.setBounds(91, 195, 97, 25);
		frame.getContentPane().add(btnNewButton);
		

	}
}
