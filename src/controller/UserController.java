package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ConnectDB;
import view.UserView;
import view.BillView;

public class UserController {
	private ConnectDB connectDB;
	private UserView view;
	private String QueryStr = new String("{CALL GETLISTPHONE()}");
	private int account;
	private String name;
	private int price;
	
	public UserController(UserView view, int account) {
		connectDB = new ConnectDB();
		this.view = view;
		this.account = account;
		view.addFillterListener(new FilterListener());
		view.addOrderListener(new OrderListener());
		view.addSamsungListener(new SamsungListener());
		view.addNokiaListener(new NokiaListener());
		view.addAppleListener(new AppleListener());
		view.addSortListener(new SortListener());
		view.addTableMouseListener(new TableMouseListener());
		view.ShowListPhone(connectDB.getListPhone(QueryStr,1));
	}
	
	public void showView() {
		view.Show();
	}
	
	
	/**
	 * handle event;
	 */
	public class FilterListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(view.getIndexOS()==0 && view.getIndexSreensize()==0) {
				QueryStr = "{CALL GETLISTPHONE()}";
				view.resetSort();
			}
			else {
				String T = new String(view.getOS());
				int i = view.getIndexSreensize();
				QueryStr = "{CALL GET_LIST_FILTER_PHONE('"
						+ T + "'," + i +")}";
				view.resetSort();
			}
		}
	}
	
	public class OrderListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			BillView billview = new BillView();
			BillController C = new BillController(billview,name,account,price);
			C.showBill();
		}
	}
	
	public class SamsungListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			QueryStr = new String();
			QueryStr = "{CALL ONLY_MANU('SAMSUNG')}";
			view.ShowListPhone(connectDB.getListPhone(QueryStr,0));
		}
	}
	
	public class NokiaListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			QueryStr = new String();
			QueryStr = "{CALL ONLY_MANU('NOKIA')}";
			view.ShowListPhone(connectDB.getListPhone(QueryStr,0));
		}
	}
	
	public class AppleListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			QueryStr = new String();
			QueryStr = "{CALL ONLY_MANU('APPLE')}";
			view.ShowListPhone(connectDB.getListPhone(QueryStr,0));
		}
	}
	
	public class SortListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int i = view.getIndexSort();
			if(i == 0) {
				view.ShowListPhone(connectDB.getListPhone(QueryStr,0));
			}
			else if(i == 1) {
				view.ShowListPhone(connectDB.getListPhone(QueryStr,-1));
			}
			else {
				view.ShowListPhone(connectDB.getListPhone(QueryStr,1));
			}
		}
	}
	
	public class TableMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			String QueryStr1 = new String();
			QueryStr1 = "{CALL GET_INFO_PHONE('"+view.getClickTable()+"')}";
			ResultSet rs = connectDB.CallProcedure(QueryStr1);
			try {
				rs.next();
				name = rs.getString("NAME_PHONE");
				String performanace = rs.getString("PERFORMANACE");
				String screen = rs.getString("SCREEN").concat(" inch");
				String pin = rs.getString("PIN").concat(" mAh");
				int amount = rs.getInt("AMOUNT");
				price = rs.getInt("PRICE");
				view.ShowInfoPhone(name, performanace, screen, pin, amount, price);
				view.setImagePhone(name);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		}
	
	public static void main(String[] args) {
		
	}

}
