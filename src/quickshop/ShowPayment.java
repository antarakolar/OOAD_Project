package QuickShop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
public class ShowPayment extends JFrame {

	private JPanel contentPane;
	private JTextField textname;
	private JTextField textadd;
	private JTextField textdeliver;
	public JTextField showtotal;
	private JTextField textcard;
	private JLabel lblExMonth;
	private JTextField textmonth;
	private JLabel lblCcv;
	protected Object texttotal;
	private JTextField textcvv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowPayment frame = new ShowPayment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection =null;
	private JButton btnViewOrder;

	/**
	 * Create the frame.
	 */
	public ShowPayment() {
		
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Card Name");
		lblName.setBounds(29, 13, 81, 16);
		contentPane.add(lblName);
		
		textname = new JTextField();
		textname.setBounds(182, 10, 116, 22);
		contentPane.add(textname);
		textname.setColumns(10);
		
		JLabel lblCreditCardNumber = new JLabel("Credit card number");
		lblCreditCardNumber.setBounds(29, 176, 121, 16);
		contentPane.add(lblCreditCardNumber);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(29, 51, 56, 16);
		contentPane.add(lblAddress);
		
		JLabel lblDeliveryOptions = new JLabel("Delivery Options");
		lblDeliveryOptions.setBounds(29, 92, 98, 16);
		contentPane.add(lblDeliveryOptions);
		
		JLabel lblTotalAmmount = new JLabel("Total amount");
		lblTotalAmmount.setBounds(29, 135, 98, 16);
		contentPane.add(lblTotalAmmount);
		
		textadd = new JTextField();
		textadd.setBounds(182, 48, 176, 22);
		contentPane.add(textadd);
		textadd.setColumns(10);
		
		textdeliver = new JTextField();
		textdeliver.setBounds(182, 89, 116, 22);
		contentPane.add(textdeliver);
		textdeliver.setColumns(10);
		
		showtotal = new JTextField();
		showtotal.setBounds(182, 132, 116, 22);
		contentPane.add(showtotal);
		showtotal.setColumns(10);
		
		textcard = new JTextField();
		textcard.setBounds(182, 173, 116, 22);
		contentPane.add(textcard);
		textcard.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm and Place Order");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into OrderTable (Name,Address,DeliveryOption,TotalAmount,CreditCardNumber,ExMonth,CVV) values (?,?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textname.getText() );
					pst.setString(2,textadd.getText() );
					pst.setString(3,textdeliver.getText() );
					pst.setString(4,showtotal.getText() );
					pst.setString(5,textcard.getText());
					pst.setString(6,textmonth.getText());
					pst.setString(7,textcvv.getText());
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
		btnConfirm.setBounds(29, 291, 207, 25);
		contentPane.add(btnConfirm);
		
		lblExMonth = new JLabel("Ex month");
		lblExMonth.setBounds(29, 217, 56, 16);
		contentPane.add(lblExMonth);
		
		textmonth = new JTextField();
		textmonth.setBounds(182, 214, 116, 22);
		contentPane.add(textmonth);
		textmonth.setColumns(10);
		
		lblCcv = new JLabel("CVV");
		lblCcv.setBounds(29, 248, 56, 16);
		contentPane.add(lblCcv);
		
		textcvv = new JTextField();
		textcvv.setBounds(182, 249, 116, 22);
		contentPane.add(textcvv);
		textcvv.setColumns(10);
		
		btnViewOrder = new JButton("View Order");
		btnViewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewOrder frame = new ViewOrder();
				frame.setVisible(true);
			}
		});
		btnViewOrder.setBounds(287, 291, 97, 25);
		contentPane.add(btnViewOrder);
	}

	public JTextField getTextField_3() {
		return showtotal;
	}
}
