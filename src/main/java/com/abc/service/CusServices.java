package com.abc.service;

import com.abc.dao.CusDao;
import com.abc.model.Customer;

public class CusServices {
	private CusDao customerdao = new CusDao();

    public boolean registerCustomer(Customer customer) {
        return customerdao.registerCustomer(customer);
    }
}
