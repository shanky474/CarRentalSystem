package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Authentication;
import model.Customer;

public class DaoImpl {

	private static Connection con = null;

	public DaoImpl(String db_name, String user_name, String password) {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name + "?",
						user_name, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public boolean save(Object o) {
		if (o instanceof Authentication) {
			try {
				PreparedStatement stmt = (PreparedStatement) con
						.prepareStatement("INSERT INTO Authentication VALUES(NULL,?,?,?,?)");
				stmt.setString(1, ((Authentication) o).getUsername());
				stmt.setString(2, ((Authentication) o).getPassword());
				stmt.setString(3, ((Authentication) o).getRole());
				stmt.setString(4, ((Authentication) o).getBlacklisted());
				stmt.executeUpdate();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (o instanceof Customer) {
			try {
				PreparedStatement stmt = (PreparedStatement) con
						.prepareStatement("INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)");
				stmt.setInt(1, ((Authentication) o).getUserId());
				stmt.setString(2, ((Customer) o).getCustomerName());
				stmt.setString(3, ((Customer) o).getDob());
				stmt.setString(4, ((Customer) o).getCustomerGender());
				stmt.setString(5, ((Customer) o).getStartingPoint());
				stmt.setString(6, ((Customer) o).getDestination());
				stmt.setString(7, ((Customer) o).getCarSelected());
				stmt.setString(8, ((Customer) o).getDateOfJourney());
				stmt.setString(9, ((Customer) o).getJourneyEndingDate());
				stmt.executeUpdate();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		} else {
			return false;
		}
		return true;
	}

	public Authentication[] displayUsers() {
		int size = 0;
		int i = 0;
		Authentication[] auth = null;
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("SELECT * from Authentication");
			ResultSet rs = stmt.executeQuery();
			if (rs != null) {
				rs.beforeFirst();
				rs.last();
				size = rs.getRow();
			}
			auth = new Authentication[size];
			while (rs.next()) {
				auth[i].setUserId(rs.getInt(1));
				auth[i].setUsername(rs.getString(2));
				auth[i].setPassword(rs.getString(3));
				auth[i].setRole(rs.getString(4));
				auth[i].setBlacklisted(rs.getString(5));
				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auth;
	}

	public Customer[] displayCustomers() {
		int size = 0;
		int i = 0;
		Customer[] customers = null;
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("SELECT * from Customer");
			ResultSet rs = stmt.executeQuery();
			if (rs != null) {
				rs.beforeFirst();
				rs.last();
				size = rs.getRow();
			}
			customers = new Customer[size];
			while (rs.next()) {
				customers[i].setUserId(rs.getInt(1));
				customers[i].setCustomerName(rs.getString(2));
				customers[i].setDob(rs.getString(3));
				customers[i].setCustomerGender(rs.getString(4));
				customers[i].setStartingPoint(rs.getString(5));
				customers[i].setDestination(rs.getString(6));
				customers[i].setCarSelected(rs.getString(7));
				customers[i].setDateOfJourney(rs.getString(8));
				customers[i].setJourneyEndingDate(rs.getString(9));
				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public Authentication getUserInfo(Authentication auth) {
		try {
			PreparedStatement stmt = (PreparedStatement) con
					.prepareStatement("SELECT * from Authentication where password=?");
			stmt.setString(1, auth.getPassword());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				auth.setUserId(rs.getInt(1));
				auth.setUsername(rs.getString(2));
				auth.setPassword(rs.getString(3));
				auth.setRole(rs.getString(4));
				auth.setBlacklisted(rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auth;
	}

	public Customer[] getCustomerInfo(Authentication auth) {
		int size = 0;
		int i = 0;
		Customer[] customers = null;
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("SELECT * from customer where userId=?");
			stmt.setInt(1, auth.getUserId());
			ResultSet rs = stmt.executeQuery();
			if (rs != null) {
				rs.beforeFirst();
				rs.last();
				size = rs.getRow();
			}
			customers = new Customer[size];
			while (rs.next()) {
				System.out.println("oops");
				customers[i].setUserId(rs.getInt(1));
				customers[i].setCustomerName(rs.getString(2));
				customers[i].setDob(rs.getString(3));
				customers[i].setCustomerGender(rs.getString(4));
				customers[i].setStartingPoint(rs.getString(5));
				customers[i].setDestination(rs.getString(6));
				customers[i].setCarSelected(rs.getString(7));
				customers[i].setDateOfJourney(rs.getString(8));
				customers[i].setJourneyEndingDate(rs.getString(9));
				i++;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return customers;
	}

	public void deleteInfo(Object o) {
		if (o instanceof Authentication) {
			PreparedStatement stmt;
			try {
				stmt = (PreparedStatement) con.prepareStatement("DELETE from Authentication where userId=?");
				stmt.setInt(1, ((Authentication) o).getUserId());
				stmt.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else if (o instanceof Customer) {
			PreparedStatement stmt;
			try {
				stmt = (PreparedStatement) con.prepareStatement("DELETE from Customer where customerName=?");
				stmt.setString(1, ((Customer) o).getCustomerName());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
