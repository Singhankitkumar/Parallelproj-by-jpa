package com.capg.payment.service;
import java.math.BigDecimal;

import com.capg.payment.dto.Customer;
import com.capg.payment.exception.PaymentException;


public interface IPaymentService {
public Customer createAccount(String name ,String mobileno, double amount) throws PaymentException;
public Customer showBalance (String mobileno) throws PaymentException;
public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, double amount) throws PaymentException;
public Customer depositAmount (String mobileNo,double amount ) throws PaymentException;
public Customer withdrawAmount(String mobileNo, double amount) throws PaymentException;
public boolean validateName(String name) throws PaymentException;
public boolean validateNumber(String number) throws PaymentException;
public boolean validateBalance(double number) throws PaymentException;
}
