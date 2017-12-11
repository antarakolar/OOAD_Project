package QuickShop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
public class AdminView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection =null;
	private JTextField textID;
	private JPasswordField passwordField;
	private JTextField textEmail;
	private JTextField textName;
	private JTable table_1;
	private JTextField txtNewOrderPlaced;

	/**
	 * Create the frame.
	 */
	public AdminView() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdmin.setBounds(262, 13, 105, 33);
		contentPane.add(lblAdmin);
/*******This button is created to display the customer users******************/		
		JButton btnDisplayUsers = new JButton("Display Customer Users");
		btnDisplayUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from CustomerDetails"; /**********Entire customer details is fetched from the SQL databse and displayed *************/
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDisplayUsers.setBounds(269, 72, 192, 25);
		contentPane.add(btnDisplayUsers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 122, 382, 99);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel txtName = new JLabel("Name");
		txtName.setBounds(12, 166, 56, 16);
		contentPane.add(txtName);
		
		textID = new JTextField();
		textID.setBounds(71, 119, 90, 22);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel txtPassword = new JLabel("Password");
		txtPassword.setBounds(12, 230, 56, 16);
		contentPane.add(txtPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(71, 227, 90, 22);
		contentPane.add(passwordField);
		
		JLabel txtEmailid = new JLabel("EmailID");
		txtEmailid.setBounds(12, 195, 56, 16);
		contentPane.add(txtEmailid);
		
		textEmail = new JTextField();
		textEmail.setBounds(71, 192, 90, 22);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel ID_text = new JLabel("");
		ID_text.setBounds(12, 125, 56, 16);
		contentPane.add(ID_text);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12, 122, 33, 16);
		contentPane.add(lblId);
		
		textName = new JTextField();
		textName.setBounds(71, 160, 90, 22);
		contentPane.add(textName);
		textName.setColumns(10);
/*********When Save is clicked all the customer details gets stored in the SQL data base Customer details*******/		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "insert into CustomerDetails (CustomerID,Name,EmailID,Password) values (?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textID.getText() );
					pst.setString(2,textName.getText() );
					pst.setString(3,textEmail.getText() );
					pst.setString(4,passwordField.getText() );
					pst.execute();
					JOptionPane.showMessageDialog(null, "User Data Saved");
					pst.close();
					//rs.close();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnSave.setBounds(46, 270, 97, 25);
		contentPane.add(btnSave);
/*********Delete user option where the Admin is allowed to delete a user from the database **********/		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from CustomerDetails where CustomerID= '"+textID.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "User Data Removed");
					pst.close();
					//rs.close();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDeleteUser.setBounds(46, 328, 105, 25);
		contentPane.add(btnDeleteUser);
/*****Admin is able to view orders as per the observer design pattern**********/		
		JButton btnViewOrders = new JButton("View Orders");
		btnViewOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewOrder frame = new ViewOrder();
				frame.setVisible(true);
			}
		});
		btnViewOrders.setBounds(46, 379, 115, 25);
		contentPane.add(btnViewOrders);
		
		JLabel lblAddAccount = new JLabel("Add and Delete Account ");
		lblAddAccount.setBounds(12, 76, 149, 16);
		contentPane.add(lblAddAccount);
/*******Admin is able to display all sellers **************/		
		JButton btnDisplaySellerUsers = new JButton("Display Seller Users");
		btnDisplaySellerUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from SellerDetails";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDisplaySellerUsers.setBounds(269, 253, 167, 25);
		contentPane.add(btnDisplaySellerUsers);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(262, 333, 384, 99);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		txtNewOrderPlaced = new JTextField();
		txtNewOrderPlaced.setForeground(Color.RED);
		txtNewOrderPlaced.setText("New Order Placed");
		txtNewOrderPlaced.setBounds(45, 425, 116, 22);
		contentPane.add(txtNewOrderPlaced);
		txtNewOrderPlaced.setColumns(10);
	}

}
