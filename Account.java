package lab3;

public class Account {

	protected Customer theCustomer;
	protected int accountNumber;
	protected double theBalance;
	private static int availableNumbers = 0;
	protected String accountType; // ger värde i subclasserna
	protected Bank theBank;
	public final double CURRENTACCOUNTFEE = 10.0;
	public final double SAVINGSINTEREST = 0.01;
	
	
	public Account(Customer arg1, Bank aBank,  double arg2) {
		theCustomer = arg1;
		theBalance = arg2;
		theBank = aBank;
		availableNumbers = availableNumbers + 1;
		accountNumber = availableNumbers;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return theBalance;
	}
	
	public void annualChange(){
		// test if current or saving account
		//comparing strings
		
		if(accountType.equals("Current"))//nånstans kommer man tilge vilken typ av konto det är
		{
			theBalance-=CURRENTACCOUNTFEE; //dras bort
		}
		else //(accountType.equals("Savings"))
		{
			theBalance=theBalance + (theBalance*SAVINGSINTEREST);
		}
		
	}
	
	
	public String toString() {
		
		String result = null;
		
		if(this.accountType.equals("Current")) {
			
			CurrentAccount ettObjekt = (CurrentAccount)this;
			// force to be CurrentAccount		

			SavingsAccount askingIfSavingAccount =ettObjekt.getSavingsAccount();
			
			if (askingIfSavingAccount != null) {
				//Savings account” followed by its account number and its value of theBalance.

				result = "\n******************************"; 
				result = result + "\nAccount number : " + accountNumber;
				result = result + "\nCustomer : " + theCustomer.getName();
				result = result + "\nBalance : " + theBalance;
				result = result + "\nSavings account: " + askingIfSavingAccount.getAccountNumber() + "\nBalance: " + askingIfSavingAccount.getBalance();
				result = result + "\n******************************";
			}
		}
		else {
			result = "\n******************************"; 
			result = result + "\nAccount number : " + accountNumber;
			result = result + "\nCustomer : " + theCustomer.getName();
			result = result + "\nBalance : " + theBalance;
			result = result + "\n******************************";
			}
		
		
		return result;
		}
	
	
	
	
}// måsvinge till Account

