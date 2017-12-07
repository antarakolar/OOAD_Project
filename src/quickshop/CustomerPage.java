package QuickShop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

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
	private JTextField SellerName;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public CustomerPage() {
		connection = sqliteConnection.dbConnector();
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
		
		JButton btnNewButton = new JButton("Show Sellers");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						String query = "select Name from SellerDetails";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				
				
				
			}
		});
		btnNewButton.setBounds(194, 88, 135, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblEnterSeller = new JLabel("Enter Seller");
		lblEnterSeller.setBounds(12, 224, 98, 16);
		contentPane.add(lblEnterSeller);
		
		SellerName = new JTextField();
		SellerName.setBounds(104, 221, 116, 22);
		contentPane.add(SellerName);
		SellerName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 126, 263, 82);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListCategory list = new ListCategory();
				list.setVisible(true);	
				
			}
		});
		btnConfirm.setBounds(273, 220, 97, 25);
		contentPane.add(btnConfirm);
		//fetch();
	}
	/*public void fetch() {
		try {
			String query = "select * from  SellerDetails";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			ShopperTable.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
		}
	}*/

}
