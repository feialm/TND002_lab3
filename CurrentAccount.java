package lab3;

import java.util.ArrayList;

public class CurrentAccount extends Account {

	private ArrayList <Transaction> theTransactions;
	private SavingsAccount theSavingsAccount = null;
	
	
	
	// Constructor
	public CurrentAccount(Customer arg1, Bank aBank, double arg2) {
		super(arg1, aBank, arg2);
		
		// i bas klassen Account: (beh�ve rej koda h�r)
		// The constructor gets an additional argument of the type Bank
		//with which we initialize theBank.
		
		accountType = "Current"; // tillger konto en som en viss typ
	}
	
	
	
	
	
	public boolean hasSavingsAccount() {
		// tests if saving account attached to current account
		
		return theSavingsAccount != null;
		// om theSavingsAccount != null blir den true
		// om theSavingsAccount == null blir den false, finns inget konto kopplat d�r
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
			// om den �r false, inte finns konto, skapar man ett konto

			theSavingsAccount  = new SavingsAccount(this);
			// this. ett visst konto skickar med sig sj�lv till en annan funktion
			// htis. ett objekt av den klassen man befinner sig i
			// i det h�r fallet ett objekt av klassen CurrenAccount
			// skapar nytt sparkonto i den f�r att den var tom
			
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
	
	
	
	// uttag f�r currentaccount, ins�ttning savingaccount
	public void send(int amount) {
		
		
		theSavingsAccount.receive(amount); //ingen kontroll om inte konto finns vart? st�r ej i lab instruktion
		// kallar p� metoden receive(arg)
		// skicka hur mycket pengar p� kontot som ska skickas till annat konto
		// till metoden receive i SavingsAccount
		
		theBalance = theBalance - amount; //updaterar gamla kontots saldo
		
		// skickar faktan/infon till klassen Transactions
		// money is negative if money leaves the current
		
		// h�r skickas kontonummer f�r sparkontot
		// �r det theCurrentAccount(this) eller theSavingsAccount??
		// ska vara theSavingsAccount
		// It should create an instance of Transaction with the appropriate numbers
		// (number of savings account) and add it to theTransactions. 
		Transaction newTransaction = new Transaction(theSavingsAccount.getAccountNumber(), 0-amount, theBalance );
		theTransactions.add(newTransaction);
		//l�gger in newTransaction i arrayen theTransactions
	}
	
	
	
	
	
	public void send(int a, double b) {
		
		
		
		
	}
	
	
	
	public void receive(double something) {
		
		
		
		
	}
	
	
	public void receive(int ff, double hh) {
		
		
		
	}
	
	
	
	public String listTransactions() {
		
		
		return "hej";
		
		
	}
	
	
	
}
