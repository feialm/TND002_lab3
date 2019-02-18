package lab3;

public class Transaction {

	// the class Transaction store the information about each transfer in the class Transaction.
	// klassen Transaction G�R INTE TRANSAKTIONEN
	private int otherAccount = 0;
	private double money = 0.0;
	private double balance = 0.0; // balance = saldo
	
	public Transaction(int kontonumb, double belopp, double saldo) {
		
		// sparar undan v�rden fr�n en transaktion
		otherAccount = kontonumb;
		money = belopp;
		balance= saldo;	
	}
	
	
	
	
	
	public String toString() {
		//The constructor initializes the three instance variables and toString() writes them out
		//The return value of toString()
		
		String result_transaction = String.format( "%-9s%-2d%-19s%-8.2f%-9s%-8.2f", "Account: ", otherAccount, "Transferred money: " ,  money,"Balance: ", balance );
	
		return result_transaction ;	
	}
	
	
	
} // m�svinge till Transaction
