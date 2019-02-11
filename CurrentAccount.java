package lab3;

import java.util.ArrayList;

public class CurrentAccount extends Account {

	private ArrayList <Transaction> theTransactions; 
	
	// Constructor
	public CurrentAccount(Customer arg1, Bank aBank, double arg2) {
		super(arg1, aBank, arg2);
		
		accountType = "Current"; // tillger konto en som en viss typ
	}
	
	public Customer getCustomer() {
		
		return theCustomer;
	}
	
	public void payIn(double arg) {
		theBalance = theBalance + arg;
	}
	
}
