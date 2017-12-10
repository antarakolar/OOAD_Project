package QuickShop;
import java.sql.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CategoryView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryView frame = new CategoryView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection =null;
	private JLabel lblEnterCategory;
	private JTextField txtCategory;
	private JButton btnConfirm;
	private JButton btnNewButton;
	/**
	 * Create the frame.
	 */
	public CategoryView() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadCategories = new JButton("Search categories");
		btnLoadCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select CategoryName from Products";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLoadCategories.setBounds(12, 13, 140, 25);
		contentPane.add(btnLoadCategories);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 51, 261, 83);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblEnterCategory = new JLabel("Enter Category");
		lblEnterCategory.setBounds(12, 158, 103, 16);
		contentPane.add(lblEnterCategory);
		
		txtCategory = new JTextField();
		txtCategory.setBounds(115, 158, 116, 22);
		contentPane.add(txtCategory);
		txtCategory.setColumns(10);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String category = txtCategory.getText();
				if (category.equals("Vegetables"))
				{
				
				try {
					String query = "select Vegetables from Products";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				}
				else if (category.equals("Fruits"))
				{
				
				try {
					String query = "select Fruits from Products";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				}
				if (category.equals("DairyProducts"))
				{
				
				try {
					String query = "select DairyProducts from Products";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				}
				
			}
		});
		btnConfirm.setBounds(258, 157, 97, 25);
		contentPane.add(btnConfirm);
		
		btnNewButton = new JButton("Search by Name");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductList product_name = new ProductList();
				product_name.setVisible(true);	
			}
		});
		btnNewButton.setBounds(258, 13, 141, 25);
		contentPane.add(btnNewButton);
		
	}
}
