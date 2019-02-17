package lab3;

public class Transaction {

	// the class Transaction store the information about each transfer in the class Transaction.
	// klassen Transaction GÖR INTE TRANSAKTIONEN
	private int otherAccount = 0;
	private double money = 0.0;
	private double balance = 0.0; // balance = saldo
	
	public Transaction(int kontonumb, double belopp, double saldo) {
		
		// sparar undan värden från en transaktion
		otherAccount = kontonumb;
		money = belopp;
		balance= saldo;	
	}
	
	
	
	
	
	public String toString() {
		//The constructor initializes the three instance variables and toString() writes them out
		//The return value of toString()
		
		String result_transaction = String.format("Account: %2d" + "\n" + "Transferred money: %7.2d" +
									"\n"+ "Balance: %7.2d", otherAccount, money, balance );
		
		return result_transaction ;

		
	}
	
	
	
} // måsvinge till Transaction
