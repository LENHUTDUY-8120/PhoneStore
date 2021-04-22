package view;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class BillView {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JSpinner spinner;

	/**
	 * Create the application.
	 */
	public BillView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 343, 500);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Bill ");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 23));
		lblNewLabel.setBounds(120, 11, 89, 37);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Id:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(26, 87, 259, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Customer:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(26, 137, 259, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Phone name:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(24, 190, 261, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Unit Price:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(24, 244, 261, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Amount:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(24, 296, 70, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Total:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(72, 355, 192, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(120, 44, 77, 4);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 112, 281, 4);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(24, 162, 281, 10);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(24, 213, 279, 4);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(24, 269, 279, 4);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(24, 319, 279, 4);
		frame.getContentPane().add(separator_5);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinner.setBounds(239, 292, 46, 26);
		JFormattedTextField tf = ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField();
		tf.setEditable(false);
		frame.getContentPane().add(spinner);
		
		btnNewButton = new JButton("CONFIRM");
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(178, 415, 125, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(49, 415, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	public void show(boolean b) {
		frame.setVisible(b);
	}
	
	public void showBill(int id, String customer, String phonename
									,int unitPrice) {
		lblNewLabel_2.setText("Id: "+id);
		lblNewLabel_3.setText("Customer: "+customer);
		lblNewLabel_4.setText("Phone name: "+phonename);
		lblNewLabel_5.setText("Unit Price: "+unitPrice+" VND");
	}
	
	public void showTotal(int total) {
		lblNewLabel_7.setText("Total:   "+ total+" VND");
	}
	
	public int getAmount() {
		return (Integer) spinner.getValue();
	}
	
	
	/*
	 * Set event;
	 */
	public void addSpinnerListener(ChangeListener listener) {
		spinner.addChangeListener(listener);
	}
	
	public void addConfirmListener(ActionListener listener) {
		btnNewButton.addActionListener(listener);
	}
	
	public void addCancelListener(ActionListener listener) {
		btnNewButton_1.addActionListener(listener);
	}
	
	public void addClosingWingdow(WindowListener listener) {
		frame.addWindowListener(listener);
	}
	
}
