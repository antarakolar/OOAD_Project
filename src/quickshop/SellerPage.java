package QuickShop;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class SellerPage extends JFrame {

	private JPanel contentPane;
	private JTextField textprodname;
	private JTextField textprodcat;
	private JTextField textprodcost;
	private JTextField textprodrem;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellerPage frame = new SellerPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection =null;
	private JTextField txtNewOrderPlaced;
	/**
	 * Create the frame.
	 */
	public SellerPage() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeSeller = new JLabel("Welcome Seller");
		lblWelcomeSeller.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWelcomeSeller.setBounds(63, 13, 184, 40);
		contentPane.add(lblWelcomeSeller);
		
		JButton btnViewOrders = new JButton("View Orders");
		btnViewOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewOrder frame = new ViewOrder();
				frame.setVisible(true);
			}
		});
		btnViewOrders.setBounds(604, 81, 115, 25);
		contentPane.add(btnViewOrders);
		
		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setBounds(12, 142, 80, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product Category");
		lblNewLabel_1.setBounds(12, 193, 115, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product Cost");
		lblNewLabel_2.setBounds(12, 253, 96, 16);
		contentPane.add(lblNewLabel_2);
		
		textprodname = new JTextField();
		textprodname.setBounds(120, 139, 116, 22);
		contentPane.add(textprodname);
		textprodname.setColumns(10);
		
		textprodcat = new JTextField();
		textprodcat.setBounds(120, 190, 116, 22);
		contentPane.add(textprodcat);
		textprodcat.setColumns(10);
		
		textprodcost = new JTextField();
		textprodcost.setBounds(120, 250, 116, 22);
		contentPane.add(textprodcost);
		textprodcost.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into ListProducts (ProductName,ProductCost,Category) values (?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textprodname.getText() );
					pst.setString(2,textprodcost.getText() );
					pst.setString(3, textprodcat.getText() );
					
		
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
		btnSave.setBounds(59, 319, 97, 25);
		contentPane.add(btnSave);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(275, 142, 105, 16);
		contentPane.add(lblProductName);
		
		textprodrem = new JTextField();
		textprodrem.setBounds(398, 139, 116, 22);
		contentPane.add(textprodrem);
		textprodrem.setColumns(10);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				try {
					String query = "delete from ListProducts where ProductName= '"+textprodrem.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Product Removed");
					pst.close();
					//rs.close();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnRemove.setBounds(361, 319, 97, 25);
		contentPane.add(btnRemove);
		
		JButton btnViewProducts = new JButton("View Products");
		btnViewProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from ListProducts";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnViewProducts.setBounds(170, 367, 115, 25);
		contentPane.add(btnViewProducts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 420, 488, 110);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblRemoveProduct = new JLabel("Remove Product");
		lblRemoveProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRemoveProduct.setBounds(340, 85, 139, 16);
		contentPane.add(lblRemoveProduct);
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddProduct.setBounds(48, 85, 91, 16);
		contentPane.add(lblAddProduct);
		
		txtNewOrderPlaced = new JTextField();
		txtNewOrderPlaced.setForeground(Color.RED);
		txtNewOrderPlaced.setText("New Order Placed");
		txtNewOrderPlaced.setBounds(604, 139, 116, 22);
		contentPane.add(txtNewOrderPlaced);
		txtNewOrderPlaced.setColumns(10);
	}

	
}
