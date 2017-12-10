package QuickShop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProductView extends JFrame {
	

	private JPanel contentPane;
	private JTextField textProduct;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductView frame = new ProductView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection =null;
	private JButton btnAddToCart;
	private JButton btnGoToCart;
	private JLabel lblEnterCost;
	private JTextField textcost;

	/**
	 * Create the frame.
	 */
	public ProductView() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchProduct = new JLabel("Search Product");
		lblSearchProduct.setBounds(131, 16, 107, 16);
		contentPane.add(lblSearchProduct);
		
		textProduct = new JTextField();
		textProduct.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String query = "select * from ListProducts where ProductName=?";
					
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textProduct.getText() );
					//System.out.print("This is"+);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		//System.out.print("This is"+textField);
		textProduct.setBounds(233, 13, 116, 22);
		contentPane.add(textProduct);
		textProduct.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(187, 86, 211, 154);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnShowItems = new JButton("Show items");
		btnShowItems.addActionListener(new ActionListener() {
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
		btnShowItems.setBounds(12, 9, 107, 25);
		contentPane.add(btnShowItems);
		
		btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into ShoppingCart (ProductName,Cost) values (?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textProduct.getText() );
					pst.setString(2,textcost.getText() );

					pst.execute();
					JOptionPane.showMessageDialog(null, "Product added to cart");
					pst.close();
					//rs.close();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnAddToCart.setBounds(12, 129, 107, 25);
		contentPane.add(btnAddToCart);
		
		btnGoToCart = new JButton("Go to cart");
		btnGoToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowCart  cart = new ShowCart ();
				cart.setVisible(true);
			}
		});
		btnGoToCart.setBounds(12, 188, 107, 25);
		contentPane.add(btnGoToCart);
		
		lblEnterCost = new JLabel("Enter cost");
		lblEnterCost.setBounds(132, 42, 85, 25);
		contentPane.add(lblEnterCost);
		
		textcost = new JTextField();
		textcost.setBounds(233, 51, 116, 22);
		contentPane.add(textcost);
		textcost.setColumns(10);
	}
}
