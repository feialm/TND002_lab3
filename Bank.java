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
				CurrentAccount newAccount = new CurrentAccount(dummy, this, arg2); // this, dvs den banken när är i
				theAccounts.add(newAccount);
				dummy.addCurrentAccount(newAccount);
				System.out.println("Added a account for " + dummy.getName());
			}
		}
		else {
			System.out.println("There is no customer with that name.");
		}
	}
	
	
	
	
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
	
	
	
	
	
	// addSavingsAccount(String arg) should add a savings account to the current account of the
	// customer with the name arg and attach it to theAccounts
	public void addSavingsAccount(String nameOfCustomer) {
		
		
		// forloopen för att kolla igenom alla customer, om det matchar namn
		// om det matchar, add saving account to current account
		for(int j = 0; j < theCustomers.size(); j++) {
			if (nameOfCustomer.equals(theCustomers.get(j).getName())) {
				
				
				Account myAccount = new Account();
				theAccounts.add(myAccount);
				
			}
			else {
				System.out.println("There is no customer with that name.");
			}
		}	
	}
	
	
	
	public Account getAccount(int hsfdvdf) {
		

		
		
	}
	
	
	
	public void computeAnnualChange() throws Exception {
		
		// Är det rätt med for loop här ?
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


