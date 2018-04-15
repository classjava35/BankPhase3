package core;

import javax.security.auth.login.AccountNotFoundException;

public abstract class Client {

	// fields
	private int id;
	private String name;
	private float balance;
	private Account[] accounts;
	protected float commissionRate;
	protected float interestRate;
	private Logger logger ;

	// CTOR
	public Client(int id, String name, float balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		accounts = new Account[5];
		logger= new Logger("driverName");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public Account getAccounts(int index) {
		for (int i = 0; i < accounts.length; i++) {
			if (i == index && accounts[i]!=null ) {
				return accounts[i];
			}
		}
		return null;
	}

	public void addAccount(Account account) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				accounts[i] = account; // add the account
				// log the operation
				Log log = new Log(System.currentTimeMillis(), this.id, "add account", account.getBalance());
				logger.log(log);
				//
				break;
			}
		}
	}

	public void removeAccount(Account account) {

		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null && accounts[i].equals(account)) {
				setBalance(getBalance()+accounts[i].getBalance());
				accounts[i] = null; // remove the account
				// log the operation
				Log log = new Log(System.currentTimeMillis(), this.id, "remove account", this.getBalance());
				logger.log(log);
				//
				break;
			}
		}
	}

	public void deposit(float amount) {
		float commision = amount * commissionRate;
		setBalance(getBalance()+(amount - commision));
		Log log = new Log(System.currentTimeMillis(), getId(), "deposit money + commissionRate ", amount);
		logger.log(log);
	}

	public void withdraw(float amount) {
		float commision = amount * commissionRate;
		setBalance(getBalance()-(amount - commision));
		Bank.addcommision(commision);
		Log log = new Log(System.currentTimeMillis(), getId(), "withdraw money + commissionRate ", amount);
		logger.log(log);
	}

	public void autoUpdateAccounts() {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				accounts[i].setBalance(accounts[i].getBalance()*(interestRate+1)); // add the interestRate
				// log the operation
				Log log = new Log(System.currentTimeMillis(), accounts[i].getId(), "add the interestRate to the account ", accounts[i].getBalance()*(interestRate+1));
				logger.log(log);
				//
			}
		}
	}

	public float getFortune() {
		float balance = getBalance();
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				balance += accounts[i].getBalance(); // add the client
			}
		}
		return balance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
