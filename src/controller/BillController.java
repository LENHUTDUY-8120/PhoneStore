package controller;

import view.BillView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dao.ConnectDB;

public class BillController {
	private ConnectDB connectDB;
	private int idacc;
	private BillView view;
	private String phonename;
	private int UnitPrice;
	private int total;
	
	public BillController(BillView view,String phonename, int idacc,int UnitPrice) {
		connectDB = new ConnectDB();
		this.idacc = idacc;
		this.view = view;
		this.UnitPrice = UnitPrice;
		this.phonename = phonename;
		total = UnitPrice;
		
		view.addSpinnerListener(new SpinnerListener());
		view.addCancelListener(new CancelListener());
		view.addConfirmListener(new ConfirmListener());
	}
	
	public void showBill() {
		ResultSet rs = connectDB.ExcuteQueryGetTable("Select ID_ORDER() as count");
		ResultSet rss = connectDB.ExcuteQueryGetTable("Select GET_USER_NAME("+idacc+") as user_name"); 
		int i = 0; String customer = new String();
		try {
			rs.next();
			rss.next();
			i = rs.getInt("count");
			customer = new String(rss.getString("user_name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		view.showBill( i, customer , phonename, UnitPrice);
		view.showTotal(UnitPrice);
		view.show(true);
	}
	
	
	/*
	 * handle event;
	 */
	public class ConfirmListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String QueryStr = new String();
			QueryStr = "{Call INSERT_BILL("+idacc+",'"+phonename+"',"+view.getAmount()+","+total+")}";
			connectDB.ExcuteQueryUpdate(QueryStr);
			view.show(false);
		}
		
	}
	
	public class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.show(false);
		}
		
	}
	
	public class SpinnerListener implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			total = view.getAmount() * UnitPrice;
			view.showTotal(total);
		}
		
	}
	
	
}
