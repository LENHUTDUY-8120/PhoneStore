package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.event.MouseListener;
import javax.swing.ListSelectionModel;
import java.awt.Component;
import java.awt.Rectangle;

public class UserView implements ActionListener{

	private JFrame frame;
	private JTable table;
	private JTableHeader header;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_cpu;
	private JLabel lblNewLabel_screen;
	private JLabel lblNewLabel_pin;
	private JLabel lblNewLabel_status;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton_4;
	private String column[] = new String[]{ "Name", "OS", "Screen size","Price" };
	
	
	public void Show() {
		frame.setVisible(true);
	}
	/**
	 * Create the application.
	 */
	public UserView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//** Init
		btnNewButton2 = new JButton("");
		btnNewButton_1 = new JButton("");
		btnNewButton_2 = new JButton("");
		btnNewButton_3 = new JButton("");
		lblNewLabel_1 = new JLabel("FILTER");
		panel = new JPanel();
		panel_1 = new JPanel();
		lblNewLabel = new JLabel("C\u1EA4U H\u00CCNH CHI TI\u1EBET");
		comboBox = new JComboBox<>();
		comboBox_1 = new JComboBox<>();
		comboBox_3 = new JComboBox<>();
		lblNewLabel_3 = new JLabel("0 VND");
		lblNewLabel_4 = new JLabel("Cpu");
		lblNewLabel_5 = new JLabel("Screen");
		lblNewLabel_6 = new JLabel("Battery capacity");
		lblNewLabel_7 = new JLabel("Status");
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_10 = new JLabel("OS:");
		lblNewLabel_12 = new JLabel("Screen size:");
		lblNewLabel_13 = new JLabel("Sort:");
		lblNewLabel_13.setForeground(new Color(106, 90, 205));
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(SystemColor.inactiveCaption);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		btnNewButton_4 = new JButton("");
		
		/*
		 * -------------------------------
		*/
		frame = new JFrame("SmartPhone Store");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1054, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	//** :	**
		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(Color.BLACK);
		canvas_1.setBounds(0, 44, 1038, 1);
		frame.getContentPane().add(canvas_1);
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.BLACK);
		canvas.setBounds(611, 0, 1, 556);
		frame.getContentPane().add(canvas);
		
		//** Order Button
		btnNewButton2.setEnabled(false);
		btnNewButton2.setIcon(new ImageIcon("C:\\Users\\8120\\OneDrive\\Desktop\\Library\\Project\\JavaSwing_Shopping\\mua.png"));
		btnNewButton2.setBounds(904, 492, 73, 44);
		frame.getContentPane().add(btnNewButton2);
		
		//** Samsung Button
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\8120\\OneDrive\\Desktop\\Library\\Project\\JavaSwing_Shopping\\samsung.png"));
		btnNewButton_1.setBounds(445, 492, 100, 53);
		frame.getContentPane().add(btnNewButton_1);
		
		//** Apple Button
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\8120\\OneDrive\\Desktop\\Library\\Project\\JavaSwing_Shopping\\apple.jpg"));
		btnNewButton_2.setBounds(44, 465, 80, 80);
		frame.getContentPane().add(btnNewButton_2);
		
		//** Nokia Button
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\8120\\OneDrive\\Desktop\\Library\\Project\\JavaSwing_Shopping\\nokia.jpg"));
		btnNewButton_3.setBounds(214, 501, 150, 35);
		frame.getContentPane().add(btnNewButton_3);
		
		panel.setBackground(new Color(255, 204, 0));
		panel.setBounds(0, 0, 612, 44);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		lblNewLabel_1.setBounds(10, 11, 66, 24);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 20));
		
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(611, 0, 427, 44);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//** Title "Cau hinh chi tiet"
		lblNewLabel.setBounds(120, 11, 187, 24);
		panel_1.add(lblNewLabel);
		lblNewLabel.setLabelFor(frame.getContentPane());
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		//** combobox Sort
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"NONE", "PRICE high to low", "PRICE low to high"}));
		comboBox.setBounds(505, 55, 100, 22);
		frame.getContentPane().add(comboBox);
		
		//** combobox Opera system
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"ALL", "IOS", "ANDROID","KAIOS"}));
		comboBox_1.setBounds(102, 55, 100, 22);
		frame.getContentPane().add(comboBox_1);
		
		//** combobox Screen Size
		comboBox_3.setModel(new DefaultComboBoxModel<String>(new String[] {"ALL", "< 5 INCH", "5 -> 6 INCH", "> 6 INCH"}));
		comboBox_3.setBounds(325, 55, 94, 22);
		frame.getContentPane().add(comboBox_3);
		
		// Name of SmartPhone
		lblNewLabel_2 = new JLabel(". . . . . . . . . . .");
		lblNewLabel_2.setForeground(new Color(184, 134, 11));
		lblNewLabel_2.setBackground(new Color(176, 224, 230));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(736, 62, 204, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		//** Price
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(692, 501, 131, 35);
		frame.getContentPane().add(lblNewLabel_3);
		
		//** INFO: Central Processing Unit
		lblNewLabel_4.setForeground(new Color(30, 144, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(639, 303, 50, 22);
		frame.getContentPane().add(lblNewLabel_4);
		
		//** INFO: Screen
		lblNewLabel_5.setForeground(new Color(30, 144, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setBounds(639, 344, 65, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
		//** INFO: Battery capacity
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setForeground(new Color(30, 144, 255));
		lblNewLabel_6.setBounds(639, 386, 131, 22);
		frame.getContentPane().add(lblNewLabel_6);
		
		//** INFO: Status
		lblNewLabel_7.setForeground(new Color(30, 144, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(639, 431, 65, 17);
		frame.getContentPane().add(lblNewLabel_7);
		
		//** Image of SmartPhone
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\8120\\OneDrive\\Desktop\\Library\\Project\\JavaSwing_Shopping\\null.jpg"));
		lblNewLabel_8.setBounds(758, 108, 160, 160);
		frame.getContentPane().add(lblNewLabel_8);
		
		//**Label OS option in filter
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setBounds(56, 60, 36, 17);
		frame.getContentPane().add(lblNewLabel_10);
		
		//**Label Screen size option in filter
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setBounds(242, 58, 73, 19);
		frame.getContentPane().add(lblNewLabel_12);
		
		//**Label Sort option in filter
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setBounds(462, 59, 36, 14);
		frame.getContentPane().add(lblNewLabel_13);
		
		
		//**
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(138, 43, 226));
		separator.setBounds(0, 88, 612, 6);
		frame.getContentPane().add(separator);
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(639, 332, 370, 1);
		frame.getContentPane().add(separator_1);
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(639, 377, 370, 6);
		frame.getContentPane().add(separator_2);
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(639, 420, 370, 1);
		frame.getContentPane().add(separator_3);
		
		//** SamrtPhone Table
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 105, 588, 349);
		frame.getContentPane().add(scrollPane_1);
		table = new JTable();
		table.setGridColor(SystemColor.inactiveCaptionText);
		table.setOpaque(false);
		table.setName("");
		table.setPreferredScrollableViewportSize(new Dimension(450, 400));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionBackground(SystemColor.activeCaption);
		table.setRowMargin(5);
		table.setBounds(new Rectangle(1, 1, 1, 1));
		table.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		table.setAlignmentX(Component.RIGHT_ALIGNMENT);
		table.setBackground(SystemColor.menu);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(20);
		scrollPane_1.setViewportView(table);
		
		//** filer icon
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\8120\\OneDrive\\Desktop\\Library\\Project\\JavaSwing_Shopping\\search.jpg"));
		btnNewButton_4.setBounds(10, 55, 30, 30);
		frame.getContentPane().add(btnNewButton_4);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(0, 0, 139));
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(445, 44, 2, 44);
		frame.getContentPane().add(separator_4);
		
		lblNewLabel_cpu = new JLabel("");
		lblNewLabel_cpu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_cpu.setBounds(824, 303, 170, 20);
		frame.getContentPane().add(lblNewLabel_cpu);
		
		lblNewLabel_screen = new JLabel("");
		lblNewLabel_screen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_screen.setBounds(824, 344, 170, 20);
		frame.getContentPane().add(lblNewLabel_screen);
		
		lblNewLabel_pin = new JLabel("");
		lblNewLabel_pin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_pin.setBounds(824, 386, 170, 20);
		frame.getContentPane().add(lblNewLabel_pin);
		
		lblNewLabel_status = new JLabel("");
		lblNewLabel_status.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_status.setBounds(824, 431, 170, 17);
		frame.getContentPane().add(lblNewLabel_status);
	}
	
	/**
	 * Funtions:
	 */
	public void ShowInfoPhone(String name, String cpu, String screen, String pin, int amount,int price) {
		lblNewLabel_2.setText(name);
		lblNewLabel_cpu.setText(cpu);
		lblNewLabel_screen.setText(screen);
		lblNewLabel_pin.setText(pin);
		if(amount > 0) {
			lblNewLabel_status.setText("Stocking");
			btnNewButton2.setEnabled(true);
		}
		else {
			lblNewLabel_status.setText("Out of stock");
			btnNewButton2.setEnabled(false);
		}
		lblNewLabel_3.setText(price+" VND");
		
	}
	
	public String getClickTable() {
		return table.getValueAt(table.getSelectedRow(), 0).toString();
	}
	
	public String getOS() {
		String T = new String(comboBox_1.getItemAt(comboBox_1.getSelectedIndex()).toString());
		return T;
	}
	
	public int getIndexOS() {
		return comboBox_1.getSelectedIndex();
	}
	
	public int getIndexSreensize() {
		return comboBox_3.getSelectedIndex();
	}
	
	public int getIndexSort() {
		return comboBox.getSelectedIndex();
	}
	
	public void setImagePhone(String pn) {
		String t = new String();
		t = "C:\\Users\\8120\\OneDrive\\Desktop\\Library\\Project\\JavaSwing_Shopping\\Phone_pictures\\"+pn+".jpg";
		lblNewLabel_8.setIcon(new ImageIcon(t));
	}
	
	public void ShowListPhone(Object[][] data) {
		table.setModel(new DefaultTableModel(data, column) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		});
		header = table.getTableHeader();
		header.setBackground(Color.lightGray);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		setColumnWidths(210, 100, 120, 140);
	}
	
	public void setColumnWidths(int a, int b, int c, int d) {
		table.getColumnModel().getColumn(0).setPreferredWidth(a);
		table.getColumnModel().getColumn(1).setPreferredWidth(b);
		table.getColumnModel().getColumn(2).setPreferredWidth(c);
		table.getColumnModel().getColumn(3).setPreferredWidth(d);
	}
	
	public void resetSort() {
		comboBox.setSelectedIndex(0);
	}
	
	/*
	 *Set Event:
	*/
	public void addFillterListener(ActionListener listener) {
		btnNewButton_4.addActionListener(listener);
	}
	
	public void addOrderListener(ActionListener listener) {
		btnNewButton2.addActionListener(listener);
	}
	
	public void addSamsungListener(ActionListener listener) {
		btnNewButton_1.addActionListener(listener);
	}
	
	public void addNokiaListener(ActionListener listener) {
		btnNewButton_3.addActionListener(listener);
	}
	
	public void addAppleListener(ActionListener listener) {
		btnNewButton_2.addActionListener(listener);
	}
	
	public void addSortListener(ActionListener listener) {
		comboBox.addActionListener(listener);
	}
	
	public void addTableMouseListener(MouseListener listener) {
		table.addMouseListener(listener);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
