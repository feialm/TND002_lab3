package lab3;

public class SavingsAccount extends Account{

	// constructor
	public SavingsAccount(CurrentAccount accountCurrent) {
		super(accountCurrent.getCustomer(), accountCurrent.theBank, 0); //sätter theBalance=0;
		
		accountType = "Savings"; // tillger konto som en viss typ
		
	}
	
	
	// insättning
	public void receive(double a) {
		
		theBalance = theBalance + a; //adds
	}
	
	
	// uttag
	public double send(double uttagValue) {
		
		double a;
		if (theBalance >= uttagValue)
		{
			theBalance = theBalance - uttagValue;
			a = uttagValue;	
		}
		else
		{
			a = theBalance;
			theBalance = 0; // eftersom man tömde kontot
		}
		
		return a; // värdet som subtraherades från kontot
	}

	
	
	
	
}
