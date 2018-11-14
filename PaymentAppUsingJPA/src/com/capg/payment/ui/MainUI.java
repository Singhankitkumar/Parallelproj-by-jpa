package com.capg.payment.ui;

import java.util.Scanner;

import com.capg.payment.dto.Customer;
import com.capg.payment.exception.PaymentException;
import com.capg.payment.service.IPaymentService;
import com.capg.payment.service.PaymentServiceImpl;

public class MainUI {
	private static Scanner sc;

	public static void main(String args[])
	{
	Customer c=new Customer();
	IPaymentService service=new PaymentServiceImpl();
	sc = new Scanner(System.in);
	int ch;
	do
	{
		System.out.println("1. Create new Customer Account");                                                            
		System.out.println("2.Deposit the Amount into your Account");                                    
	    System.out.println("3.Withdraw the Amount from your Account");                                   
		System.out.println("4.Show Existing Customer's balance");                                        
		System.out.println("5.Fund Transfer");                                                           
		System.out.println("6.Exit Application");                                                       
		System.out.println("Enter ur choice");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:                                                                                         //Create new Customer Account
			String name;
			String mob;
			double bal;
			do
			{
				try
				{
					System.out.println("Enter Customer name");
					name=sc.next();
					service.validateName(name);
					System.out.println("Enter mobile number");
					mob=sc.next();
					service.validateNumber(mob);
					System.out.println("Enter initial Amount");
					bal=sc.nextDouble();
					service.validateBalance(bal);
					if(service.validateName(name)&&service.validateNumber(mob)&&service.validateBalance(bal))
					{
						c=service.createAccount(name,mob,bal);
						break;
				
					}
				}
				catch(PaymentException i)
				{
					System.out.println(i.getMessage());
				}
			
			}while(true);
			
			
			System.out.println("Succesfully created account for " +c.getName()+" with mobile number "+c.getMobileNo());
			System.out.println("\n****************************************************************************************");
			break;
			
		case 2:                                                                                             //Deposit the Amount into your Account
			String mobi;
			Double amt;
			do
			{
			try
			{
				System.out.println("Enter the mobile no");
				mobi=sc.next();
				service.validateNumber(mobi);
				System.out.println("Please enter the Amount you want to deposit");
				amt=sc.nextDouble();
				service.validateBalance(amt);
				if(service.validateNumber(mobi))
				{
					c=service.depositAmount(mobi, amt);
					break;
				}
			}
			catch(PaymentException e)
			{
				System.out.println(e.getMessage());
			}
			
			}while(true);
			
			System.out.println(c.getName()+" Your current balance after deposition is  "+c.getBalance());
			System.out.println("\n****************************************************************************************");
			break;
		case 3:                                                                                                //Withdraw the Amount from your Account
			do
			{
				try
				{
					System.out.println("Enter the mobile no");
					String mobil=sc.next();
					service.validateNumber(mobil);
					System.out.println("Please enter the Amount you want to withdraw");
					double at=sc.nextDouble();
					
					if(service.validateNumber(mobil))
					{
						c=service.withdrawAmount(mobil, at);
						break;
					}
				}
				catch(PaymentException e)
				{
					System.out.println(e.getMessage());
				}
			
		    
			}while(true);
			System.out.println(c.getName()+" Your remaining balance agter withdrawal is "+c.getBalance());
			System.out.println("\n****************************************************************************************");
			break;
		case 4:                                                                                                 //Show Existing Customer's balance
			do
			{
			System.out.println("Enter mobile no.");
			String mobile=sc.next();
		
			
			try
			{
				if(service.validateNumber(mobile))
				{
					c=service.showBalance(mobile);
					break;
				}
			}
			catch(PaymentException e)
			{
				System.out.println(e.getMessage());
			}
			
			}while(true);
			System.out.println(c.getName()+" Your Available Balance: "+c.getBalance());
			System.out.println("\n****************************************************************************************");
			break;
		case 5:                                                                                                    //Fund Transfer
			do
			{
				System.out.println("Enter mobile no.");
				String mob1=sc.next();
				System.out.println("Enter mobile no of the receiver");
				String mob2=sc.next();
			
				System.out.println("Enter the amount you want to transfer");
				double amount=sc.nextDouble();
				try
				{
					if(service.validateNumber(mob1)&&service.validateNumber(mob2))
					{
						c=service.fundTransfer(mob1, mob2, amount);
						break;
					}
				}
				catch(PaymentException e)
				{
					System.out.println(e.getMessage());
				}
			
			}while(true);
			
			if(c!=null)
			{
				System.out.println("Hurray !! Amount successfully Transfered");
				System.out.println("Available account balance is: "+c.getName()+" with mobile no. "+c.getMobileNo()+" is "+c.getBalance());
				System.out.println("\n****************************************************************************************");
			}	
			else
				System.out.println("Transfer failed");
			break;
		
		case 6:                                                                                                    //Exit Application
			System.out.println("You have exited the application.....");
			System.out.println("\n****************************************************************************************");
			break;
		}
		
		
	}while(ch!=6);
	
	}
}
