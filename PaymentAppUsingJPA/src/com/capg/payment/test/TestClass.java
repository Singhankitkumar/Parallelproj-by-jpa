package com.capg.payment.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.payment.dto.Customer;
import com.capg.payment.exception.PaymentException;
import com.capg.payment.service.IPaymentService;
import com.capg.payment.service.PaymentServiceImpl;

public class TestClass {

	/*static Customer cust;
	static IPaymentService ws;
    @BeforeClass
    public static void init(){
        System.out.println("In Before Class..");
        cust=new Customer();
        ws=new PaymentServiceImpl();*/

    
    
    @Test
    public void ValidateNameTrue() throws PaymentException{
		PaymentServiceImpl bs = new PaymentServiceImpl();
		assertEquals(true, bs.validateName("Ankit"));
    }
    
    @Test (expected= PaymentException.class)
    public void ValidateNameFalse() throws PaymentException{
		PaymentServiceImpl bs = new PaymentServiceImpl();
		assertEquals(false, bs.validateName("ankit"));}}
  /*  @Test
    public void  test_depositbalance() throws PaymentException {
            assertNotNull(ws.depositAmount("9989334999",45));
    }
    @Test
    public void  test_withdraw() throws PaymentException {
            assertNotNull(ws.withdrawAmount("9989334999", 963));
    }
    
    @Test
    public void  test_fundtransfer() throws PaymentException {
            assertNotNull(ws.fundTransfer("8686682001", "9989334999", 963));
    }
    */
    


