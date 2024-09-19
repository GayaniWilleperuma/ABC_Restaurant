package com.abc.service;

import com.abc.dao.PaymentsDao;
import com.abc.model.Payments;

public class PayServices {
	public class PaymentService {
	    private PaymentsDao paymentdao = new PaymentsDao();

	    public void processPayment(Payments payment) throws Exception {
	        // Add validation or business logic if required
	        paymentdao.savePayment(payment);
	    }
	}}
