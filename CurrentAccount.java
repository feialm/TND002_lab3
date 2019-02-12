package lab3;

import java.util.ArrayList;

public class CurrentAccount extends Account {

	private ArrayList <Transaction> theTransactions;
	private SavingsAccount theSavingsAccount = null;
	
	
	
	// Constructor
	public CurrentAccount(Customer arg1, Bank aBank, double arg2) {
		super(arg1, aBank, arg2);
		
		// i bas klassen Account: (behöve rej koda här)
		// The constructor gets an additional argument of the type Bank
		//with which we initialize theBank.
		
		accountType = "Current"; // tillger konto en som en viss typ
	}
	
	
	
	
	
	public boolean hasSavingsAccount() {
		// tests if saving account attached to current account
		
		return theSavingsAccount != null;
		// om theSavingsAccount != null blir den true
		// om theSavingsAccount == null blir den false, finns inget konto kopplat där
	}
	
	
	
	
	
	public SavingsAccount createSavingsAccount() {
		// skapar nytt konto 
	
		if( hasSavingsAccount()== true)
		{		
			System.out.println("A savings account already exists");
			return null;
		}
		else
		{
			// om den är false, inte finns konto, skapar man ett konto

			theSavingsAccount  = new SavingsAccount(this);
			// this. ett visst konto skickar med sig själv till en annan funktion
			// htis. ett objekt av den klassen man befinner sig i
			// i det här fallet ett objekt av klassen CurrenAccount
			// skapar nytt sparkonto i den för att den var tom
			
			System.out.println("Added a savings account to the: " + accountNumber);
			return theSavingsAccount; // returnernar kontot
		}	
	}
	
	
	
	
	
	public Customer getCustomer() {
		
		return theCustomer;
	}
	
	
	
	
	public Bank getBank() {
		
		return theBank;
	}
	
	
	
	public SavingsAccount getSavingsAccount() {
		
		return theSavingsAccount;
		
	}
	
	
	public void payIn(double arg) {
		theBalance = theBalance + arg;
	}
	
	
	
	// uttag
	public void send(int amount) {
		
		theSavingsAccount.receive(amount);
		// skicka hur mycket pengar på kontot som ska skickas till annat konto
		// till metoden receive i SavingsAccount
		
		theBalance = theBalance - amount; //updaterar gamla kontots saldo
		
		// skickar faktan/infon till klassen Transactions
		// money is negative if money leaves the current
		
		// här skickas kontonummer för sparkontot
		// är det theCurrentAccount(this) eller theSavingsAccount??
		
		/**
		 * 	FRÅGA MARK
		 * */
		
		Transaction newTransaction = new Transaction(theSavingsAccount.getAccountNumber(), 0-amount, theBalance );

		theTransactions.add(newTransaction); //lägger in newTransaction i arrayen theTransactions
	}
	
	
}
