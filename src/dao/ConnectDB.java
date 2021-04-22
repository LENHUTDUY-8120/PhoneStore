package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;

import java.sql.ResultSet;

public class ConnectDB {

	public String connstr = "jdbc:mysql://localhost:3306/phonestore?"
						+ "user=root&password=8120";
	public Connection conn;
	private Object[][] data;

	// Contructor:
	public ConnectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(connstr);
			System.out.print("Connected\n");
		}
		catch(SQLException Ex) {
			Ex.printStackTrace();} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	// Thuc thi cau lenh select:
	public ResultSet ExcuteQueryGetTable(String QueryStr) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(QueryStr);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	
	//Thuc thi cau lenh Insert,Update,Delete:
	public void ExcuteQueryUpdate(String QueryStr) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(QueryStr);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	// call StoreProcedure:
	public ResultSet CallProcedure(String QueryStr) {
		CallableStatement stmt;
		ResultSet rs = null;
		try {
			stmt = (CallableStatement) conn.prepareCall(QueryStr,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	// **
	public int getSizeRS(ResultSet rs) {
		int size=0;
		try {
			while(rs.next()) {
				size++;
			}
			rs.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return size;
	}
	
	// **
	public Object[][] getListPhone(String str,int bool){
		ResultSet rs = CallProcedure(str);
		int size = getSizeRS(rs);
		data = new Object[size][4];
		int i = 0;
		try {
			while(rs.next()) {
				data[i][0] = rs.getString("NAME_PHONE");
				data[i][1] = rs.getString("NAME_OS");
				data[i][2] = rs.getString("SCREEN").concat(" inch");
				data[i][3] = rs.getString("PRICE").concat(" VND");
				i++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(bool == -1) {
			sortHightoLow(size);
		}
		else if(bool == 1) {
			sortLowtoHigh(size);
		}
		return data;
	}
	
	
	public void sortHightoLow(int size) {
		for(int i = 0; i<size; i++) {
			for(int j=i;j<size;j++) {
				if(data[i][3].toString().compareTo(data[j][3].toString())<0){
					String temp = new String(); 
					temp = data[i][0].toString();
					data[i][0] = data[j][0];
					data[j][0] = temp;	
					
					temp = data[i][1].toString();
					data[i][1] = data[j][1];
					data[j][1] = temp;	
					
					temp = data[i][2].toString();
					data[i][2] = data[j][2];
					data[j][2] = temp;
					
					temp = data[i][3].toString();
					data[i][3] = data[j][3];
					data[j][3] = temp;	
				}
				
			}
		}
	}
	
	public void sortLowtoHigh(int size) {
		for(int i = 0; i<size; i++) {
			for(int j=i;j<size;j++) {
				if(data[i][3].toString().compareTo(data[j][3].toString())>0){
					String temp = new String(); 
					temp = data[i][0].toString();
					data[i][0] = data[j][0];
					data[j][0] = temp;	
					
					temp = data[i][1].toString();
					data[i][1] = data[j][1];
					data[j][1] = temp;	
					
					temp = data[i][2].toString();
					data[i][2] = data[j][2];
					data[j][2] = temp;
					
					temp = data[i][3].toString();
					data[i][3] = data[j][3];
					data[j][3] = temp;	
				}
				
			}
		}
	}
		
}
		

