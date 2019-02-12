package lab3;

public class Transaction {

	//store the information about each transfer in the class Transaction.
	// GÖR INTE TRANSAKTIONEN
	private int otherAccount = 0;
	private double money = 0.0;
	private double balance = 0.0; // balance = saldo
	
	public Transaction(int a, double b, double c) {
		
		// sparar undan värden från en transaktion
		otherAccount = a;
		money = b;
		balance= c;
		
	}
	
	
	
	
	
	public String toString() {
		
		
		return "hejhejhej";
	
		/**
		”Account : ” followed by the value of otherAccount (two
				digits) followed by ”Transferred money : ” followed by money (5 digits before and 2 after the
				radix point) followed by ”Balance : ” followed by balance (same format as money).
		*/
		
		
	}
	
	
	
}
