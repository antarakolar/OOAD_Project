package QuickShop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.sql.*;
import javax.swing.*;


public class CreateAccountView extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textID;
	private JTextField textEmail;
	private JButton btnNewButton_1;
	private JButton btnSeller;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountView frame = new CreateAccountView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection =null;

	/**
	 * Create the frame.
	 */
	public CreateAccountView() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(44, 13, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(44, 42, 56, 16);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("EmailID");
		lblNewLabel.setBounds(44, 76, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(44, 121, 74, 16);
		contentPane.add(lblNewLabel_1);
		
		textName = new JTextField();
		textName.setBounds(176, 10, 116, 22);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textID = new JTextField();
		textID.setBounds(176, 39, 116, 22);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(176, 73, 116, 22);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Sorry, cannot add another Admin");
			}
		});
		btnNewButton.setBounds(44, 153, 97, 25);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Customer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnNewButton_1.setBounds(161, 153, 97, 25);
		contentPane.add(btnNewButton_1);
		
		btnSeller = new JButton("Seller");
		btnSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into SellerDetails (SellerID,Name,EmailID,Password) values (?,?,?,?)";
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
		btnSeller.setBounds(284, 153, 97, 25);
		contentPane.add(btnSeller);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 118, 116, 22);
		contentPane.add(passwordField);
	}
}
