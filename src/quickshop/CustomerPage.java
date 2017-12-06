package QuickShop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;

public class CustomerPage extends JFrame {
	private String name; 

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerPage frame = new CustomerPage();
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
	public CustomerPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Customer");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 48, 190, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblQuickshop = new JLabel("QuickShop");
		lblQuickshop.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQuickshop.setBounds(127, 13, 110, 22);
		contentPane.add(lblQuickshop);
		
		JLabel lblSelectSeller = new JLabel("Select Seller");
		lblSelectSeller.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectSeller.setBounds(12, 88, 98, 16);
		contentPane.add(lblSelectSeller);
		
		JButton btnNewButton = new JButton("Shopper");
		btnNewButton.setBounds(181, 113, 97, 25);
		contentPane.add(btnNewButton);
		fetch();
	}
	public void fetch() {
		try {
			String query = "select * from  SellerDetails";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				
			}
			//jTable1.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
		}
	}

}
