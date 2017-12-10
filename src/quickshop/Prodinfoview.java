package QuickShop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class Prodinfoview extends JFrame {

	private JPanel contentPane;
	private JTextField textProdname;
	private JTextField textprodcat;
	private JTextField textprodcost;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prodinfoview frame = new Prodinfoview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Prodinfoview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setBounds(28, 26, 91, 16);
		contentPane.add(lblNewLabel);
		
		textProdname = new JTextField();
		textProdname.setBounds(143, 23, 116, 22);
		contentPane.add(textProdname);
		textProdname.setColumns(10);
		
		JLabel lblProductCategory = new JLabel("Product Category");
		lblProductCategory.setBounds(29, 71, 108, 16);
		contentPane.add(lblProductCategory);
		
		textprodcat = new JTextField();
		textprodcat.setBounds(143, 65, 116, 22);
		contentPane.add(textprodcat);
		textprodcat.setColumns(10);
		
		JLabel lblProductCost = new JLabel("Product Cost");
		lblProductCost.setBounds(28, 123, 91, 16);
		contentPane.add(lblProductCost);
		
		textprodcost = new JTextField();
		textprodcost.setBounds(143, 120, 116, 22);
		contentPane.add(textprodcost);
		textprodcost.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(110, 152, 97, 25);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(160, 186, 296, 165);
		contentPane.add(table);
		
		JButton btnViewProducts = new JButton("View Products");
		btnViewProducts.setBounds(22, 204, 115, 25);
		contentPane.add(btnViewProducts);
	}

}
