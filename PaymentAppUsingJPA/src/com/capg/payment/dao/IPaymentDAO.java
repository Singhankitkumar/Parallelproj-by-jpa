package com.capg.payment.dao;

import com.capg.payment.dto.Customer;

public interface IPaymentDAO {
	public boolean save(Customer customer);
	public Customer findOne(String mobileNo);
	public boolean createNewDetails(Customer pr);
}
