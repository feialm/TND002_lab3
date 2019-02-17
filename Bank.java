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
	
	
	
	
	public void computeAnnualChange() {
		
		// kopplar till metoden annualchange som:
			// sätta in årets ränta på konto
			// eller ta ut avgiften
			for(int j = 0; j < theAccounts.size(); j++) {
				
				theAccounts.get(j).annualChange();
			}
		
	}
	
	
	
	public void transfer(String CustomersName, String command, double belopp) {
		
		Customer enCustomer = this.getCustomer(CustomersName);
		
		if (enCustomer == null) {
			
			return; //avsluta
		}
		
		// frågar om kundens CurrentAccount
		// enCustomer = kunden
		CurrentAccount getCurrentAccountAvCustomer = enCustomer.getCurrentAccount();
		
		
		// kollaro m kund har ett konto
		if ( getCurrentAccountAvCustomer == null) {
			
			return; //avsluta
		}
			
		// input is save, do this:
			// check if customer has Saving Account
		boolean CustomerHaveSavingAccount;
		
		if(command.equals("save")) {
			
			CustomerHaveSavingAccount = getCurrentAccountAvCustomer.hasSavingsAccount();
			
			if(CustomerHaveSavingAccount==false) {
			
				this.addSavingsAccount(CustomersName);
				// anropar metoden addSavingsAccount
				// skapar nytt sparkonto

			}		
			// för över pengar till saving account
			getCurrentAccountAvCustomer.send(belopp);	
		}
		
		

		
		if(command.equals("withdraw")) {
			
			CustomerHaveSavingAccount = getCurrentAccountAvCustomer.hasSavingsAccount();
			
			if(CustomerHaveSavingAccount==true) {
				
				getCurrentAccountAvCustomer.receive(belopp);
				// pengar från saving account till lönekontot
			}	
			
		}
		
		
		// pengar från console
		// inga pengar som förs över mellan konton
		// nya utomstående pengar sätts in via input av den som kör programmet
		if(command.equals("external")) {

			getCurrentAccountAvCustomer.receive(0,belopp);
		}
		
		
		Customer customerFromCommand = getCustomer(command);
		
		// om en kund med namnet från input command
		if(customerFromCommand != null) {
		
				CurrentAccount Account1 = enCustomer.getCurrentAccount();
				CurrentAccount Account2 = customerFromCommand.getCurrentAccount();
				
				//int number1 = Account1.getAccountNumber();
				//number1 behövs inte
				int number2 = Account2.getAccountNumber();
				
				//int number2 = customerFromCommand.getCurrentAccount().getAccountNumber();
				// samma sak
				
				
				// You call the method send(number2, arg3) of
				//the current account number1.
				Account1.send(number2, belopp);	
		}
	}
	
	
	
	public void transactions(String CustomerName) {
		
		Customer enCustomerName = this.getCustomer( CustomerName);
		
		if (enCustomerName == null) {
			
			return; //avsluta
		}

		CurrentAccount getCurrentAccountAvCustomer = enCustomerName.getCurrentAccount();
	
		if(getCurrentAccountAvCustomer!=null) {
			// skriver ut strängen
			System.out.println(getCurrentAccountAvCustomer.listTransactions());
		}	
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


