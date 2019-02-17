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
		
		theTransactions = new ArrayList <Transaction>();
		
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
	public void send(double amount) {
		
		
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
		Transaction newTransaction = new Transaction(theSavingsAccount.getAccountNumber(), -amount, theBalance );
		theTransactions.add(newTransaction);
		//l�gger in newTransaction i arrayen theTransactions
	}
	
	
	
	
	// Part D, sending to another persons account
	public void send(int arg1, double arg2) {
	
			// arg2 �r pengarna som ska �verf�ras till fr�n konto till annat konto
		
			Account valueOfAccountNumber = theBank.getAccount(arg1);
			// h�mtar banken, och dens account nummer
			
			if(valueOfAccountNumber == null) {
				System.out.println("No such account exists");
			}	
			else if(accountType.equals("Current")) {
					
				((CurrentAccount)valueOfAccountNumber).receive(arg1, arg2);
				// metoden kallar p� kontot d�r pengarna ska till
				// valueOfAccountNumber �r kontot man vill �verf�ra till	
				// Tvingar valueOfAccountNumber att bli ett CurrentAccount
		
				theBalance -= arg2; // remove money fr�n kontot som man skickar ifr�n
				
				Transaction newT = new Transaction(arg1, arg2 ,theBalance);
				theTransactions.add(newT);
						
			}
			else {
				//(accountType.equals("Savings")) 
				// hamnar h�r om theBnak �r ett sparkonto
					
					System.out.println("That is not a current account.");
				}
		
	}
	
	
	
	public void receive(double amount2) {
		
		
		double money = theSavingsAccount.send(amount2); // kallar p� metoden send i klassen SavingsAccount
		
		// add its return value to theBalance (from SavingsAccount)
		theBalance += money; // money �r v�rdet a i SavingsAccount, metoden a
		
		Transaction newTransaction = new Transaction(theSavingsAccount.getAccountNumber(), money ,theBalance);
		theTransactions.add(newTransaction);
		
	}

	
	
	
	// Part D, receiving from another persons account
	public void receive(int arg1, double arg2) {
		
		// h�mtar info om ett konto, belopp
		// �kar saldot i det kontot
		// l�gger i transactionslistan theTransactions
		
		theBalance += arg2;
		Transaction newTransaction = new Transaction(arg1, arg2, theBalance);
			// arg1 = kontonummer
			// arg2 = belopp
			// theBalance = nya saldot efter adderat belopp
		theTransactions.add(newTransaction);
	}
	
	
	
	
	
	public String listTransactions() {
		
		String aString = String.format("Transaction summary of the current account " + accountNumber + "\n");
		
		
		for (int i = 0; i < theTransactions.size(); i++)
		{
			aString += theTransactions.get(i).toString() + "\n";
			// kanske kan ropa p� metoden utan .toString() + "\n"
		}
		
		return aString;
	}
	
	
	
	
	
} // m�svinge till CurrentAccount