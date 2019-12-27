
public class BankAccount {
	private int acctnum;
	private int balance = 0;
	private boolean isforeign = false;
	
	public BankAccount(int a) {
		acctnum = a;
	}

	public int getAcctNum() {
		return acctnum;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int amt) {
		this.balance = amt;
	}

	public boolean isForeign() {
		return isforeign;
	}

	public void setForeign(boolean b) {
		this.isforeign = b;
	}
	
}
