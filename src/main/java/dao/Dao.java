package dao;

import model.Authentication;
import model.Customer;

public interface Dao {

	public boolean save(Object o);

	public Authentication[] displayUsers();

	public Customer[] displayCustomers();

	public Authentication getUserInfo(Authentication auth);

	public Customer getCustomerInfo(Authentication auth);

	public void deleteInfo(Object o);

}
