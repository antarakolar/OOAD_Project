package QuickShop;

import java.awt.BorderLayout;import java.sql.*;
import javax.swing.*;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Cart extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public int sum() {
		int rows= table.getRowCount();
		int sum=0;
		for (int i=0;i<rows;i++) {
			sum=sum+Integer.parseInt(table.getValueAt(i, 1).toString());
		}
		return sum;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart frame = new Cart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection =null;
	public JTextField texttotal;
	public JButton btnMakePayment;
	private JLabel lblRemoveProduct;
	private JLabel lblEnterProduct;
	private JTextField textprod;
	private JButton btnRemove;

	/**
	 * Create the frame.
	 */
	public Cart() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShowCart = new JButton("Show cart");
		btnShowCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from ShoppingCart";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnShowCart.setBounds(22, 23, 97, 25);
		contentPane.add(btnShowCart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 80, 203, 206);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnMakePayment = new JButton("Make Payment");
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String total = texttotal.getText();
				ShowPayment show = new ShowPayment();
				show.showtotal.setText(texttotal.getText());
				show.setVisible(true);
			}
		});
		btnMakePayment.setBounds(341, 299, 138, 25);
		contentPane.add(btnMakePayment);
		
		JButton btnTotalCost = new JButton("Total Cost");
		btnTotalCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texttotal.setText(Integer.toString(sum()));		
			}
		});
		btnTotalCost.setBounds(12, 299, 97, 25);
		contentPane.add(btnTotalCost);
		
		texttotal = new JTextField();
		texttotal.setBounds(145, 300, 59, 22);
		contentPane.add(texttotal);
		texttotal.setColumns(10);
		
		lblRemoveProduct = new JLabel("Remove Product");
		lblRemoveProduct.setBounds(410, 27, 116, 16);
		contentPane.add(lblRemoveProduct);
		
		lblEnterProduct = new JLabel("Enter Product");
		lblEnterProduct.setBounds(363, 80, 116, 16);
		contentPane.add(lblEnterProduct);
		
		textprod = new JTextField();
		textprod.setBounds(514, 77, 116, 22);
		contentPane.add(textprod);
		textprod.setColumns(10);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from ShoppingCart where ProductName= '"+textprod.getText()+"' ";
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
		btnRemove.setBounds(410, 134, 97, 25);
		contentPane.add(btnRemove);
	}

	public JTextField getTexttotal() {
		return texttotal;
	}
	public JButton getBtnMakePayment() {
		return btnMakePayment;
	}
}
