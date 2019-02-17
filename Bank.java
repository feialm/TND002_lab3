package lab3;
import java.util.ArrayList;


public class Bank {
	private ArrayList<Account> theAccounts;
	private ArrayList<Customer> theCustomers;
	
	
	
	
	public Bank() {
		theAccounts = new ArrayList<Account>();
		theCustomers = new ArrayList<Customer>();
	}
	
	
	
	public boolean hasCustomer(String arg) {
		boolean dummy = false;
		for (int i = 0; i < theCustomers.size(); i++) {
			if (theCustomers.get(i).getName().equals(arg)) {
				dummy = true;
			}
		}		
		return dummy;
	}
	
	
	
	
	public void addCustomer(String arg) {
		if (hasCustomer(arg)) {
			System.out.println("The customer already exists.");
		}
		else {
			theCustomers.add(new Customer(arg));
			System.out.println("Customer added.");
		}
	}
	
	
	
	
	
	public void addCurrentAccount(String arg1, double arg2) {
		if (hasCustomer(arg1)) {
			Customer dummy = getCustomer(arg1);
			if (dummy.hasCurrentAccount()) {
				System.out.println("The customer already has a current account.");
			}
			else {
				CurrentAccount newAccount = new CurrentAccount(dummy, this, arg2);
				// this, dvs den banken när är i
				// skickar med bankobjektet
				theAccounts.add(newAccount);
				dummy.addCurrentAccount(newAccount);
				System.out.println("Added a account for " + dummy.getName());
			}
		}
		else {
			System.out.println("There is no customer with that name.");
		}
	}
	
	
	
	// kollar om ett namn matchar med ett annat
	public Customer getCustomer(String arg) {
		if (!hasCustomer(arg)) return null;
		else {
			Customer dummy;
			int irun = 0;
			do {
				dummy = theCustomers.get(irun);
				irun++;
			} while (!dummy.getName().equals(arg));
			return dummy;
		}
	}
	
	
	
	
	
	
	
	public Account getAccount(int arg) {
		
		Account number = null;
			for(int j =0; j < theAccounts.size(); j++){
				
				// hämtar kontonummer, jämför med arg
				if(theAccounts.get(j).getAccountNumber()== arg) {
					number = theAccounts.get(j);
					return number;
				}
			}
			return number;
		}

	
	
	
	
	
	// addSavingsAccount(String arg) should add a savings account to the current account of the
	// customer with the name arg and attach it to theAccounts
	public void addSavingsAccount(String nameOfCustomer) {
	
		Customer aCustomer = getCustomer(nameOfCustomer);
		

		if(aCustomer == null) {
			
			System.out.println("There is no customer with that name.");
			
		}
		else
		{
			SavingsAccount nyttSparKonto = aCustomer.getCurrentAccount().createSavingsAccount();
			// en kund, hämta lönekonto, skapa sparkonto
			// returerna sparkonto	
			// man har e kund (objekt), frågar den om lönekonto(getCurrentAccount)
			// säga åt lönekontot att skapa sparkonto som hör til den kunden
			// aCustomer.getCurrentAccount() = ett kundensLönekonto
			// kundensLönekonto.createSavingsAccount()
			// från kundensLönekonto skapar man sparkonto
			
			theAccounts.add(nyttSparKonto);	
		}	
	}
	
	
	
	
	public void computeAnnualChange() throws Exception {
		
		// kopplar till metoden annualchange som:
			// sätta in årets ränta på konto
			// eller ta ut avgiften
			for(int j = 0; j < theAccounts.size(); j++) {
				
				theAccounts.get(j).annualChange();
			}
		
	}
	
	
	
	public void transfer(String asas, String ssa, double sxs) {
		
		
		
		
	}
	
	
	
	public void transactions(String cdf) {
		
		
	}
	
	
	
	
	public String toString() {
		String result = "Bank information : ";
		double totalValue = 0.0;
		for (int i = 0; i < theAccounts.size(); i++) {
			totalValue = totalValue + theAccounts.get(i).getBalance();
		}
		result = result + "\nNumber of customers : " + theCustomers.size();	
		result = result + "\nNumber of accounts : " + theAccounts.size();
		result = result + "\nIt controls a total of " + totalValue;
		return result;
	}
	
	
	
}// måsvinge till Bank


