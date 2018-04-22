package core;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;



public class Bank {
	private Client[] clients;
	private Logger logService;
	// account updater; leave this one for now
	private Logger logger;
	private float balance;
	private static Bank instance = new Bank();
	private static float commissionSum = 0;

	// Phase 3 - create a singleton Bank CTOR
	private Bank() {
		super();
		logService = new Logger("driverName");
		logger = new Logger("driverName");
		this.balance = balance;
		this.clients = new Client[100];
	}

	// Phase 3 - create a singleton Bank instance
	// 3. a getter method for the single instance
	public static Bank getInstance() {
		return instance;
	}

	/**
	 * Calculates the total fortune of all bank clients.
	 * 
	 * @return the calculated fortune.
	 */
	public float getFortune() {
		float fortune = 0;
		for (int i = 0; i < clients.length; i++) {
			Client currClient = clients[i];
			if (currClient != null) {
				fortune += currClient.getFortune();
			}
		}
		return fortune;
	}
	
	// Phase 3 - Calculate static commissionSum
	public static void addcommision(float commision) {
		commissionSum += commision;
	}

	public void setBalance(Bank b1) {
		float balance = 0;
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] != null) {
				balance += clients[i].getFortune();
			}
			// Phase 3 - Add the commissionSum to the Bank Balance
			//balance += commissionSum;
		}
		this.balance = balance;
		// log the operation
		Log log = new Log(System.currentTimeMillis(), 1, "set Bank Balance", b1.getBalance());
		logger.log(log);
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
		// log the operation
		Log log = new Log(System.currentTimeMillis(), 1, "set Bank Balance", balance);
		logger.log(log);
	}

	public float getBalance() {
		return balance;
	}

	public void addClient(Client client) {
		for (int i = 0; i < clients.length; i++) {
			if (client instanceof Client && clients[i] == null) {
				clients[i] = client; // add the client
				this.balance += clients[i].getBalance(); // add the client balance to the Bank Balance
				// log the operation
				Log log = new Log(System.currentTimeMillis(), client.getId(), "add account", client.getBalance());
				logger.log(log);
				//
				break;
			}
		}
	}

	
	
	// Phase 3 function gets Client instead of Id
	public void removeClient(Client client) {

		for (int i = 0; i < clients.length; i++) {
			if (clients[i] != null && clients[i].equals(client)) {
				float client_balance = clients[i].getFortune();
				this.balance -= client_balance;
				clients[i] = null; // add the account
				// log the operation
				Log log = new Log(System.currentTimeMillis(), client.getId(), "remove client", client_balance);
				logger.log(log);
				//
				break;
			}
		}
	}

	public Client[] getClients() {
		return clients;
	}

	public Client getClients(int Id) {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i].getId() == Id) {
				return clients[i];
			}
		}
		return null;
	}
	
	/**
	 * Return the specified client or null if not found.
	 */
	public Client getClient(int Id) {
		for (int i = 0; i < clients.length; i++) {
			Client currClient = clients[i];
			if (currClient != null && currClient.getId() == Id) {
				return currClient;
			}
		}
		return null;
	}

	public void viewLogs() {
		// prints all logs that are stored in the logger - leave empty for now
	}

	public void startAccountUpdater() {
		// leave empty for now
	}

	public void printClientList() {
		for (int index = 0; index < clients.length; index++) {
			if (clients[index] instanceof Client) {
				System.out.println(clients[index].getName() + ": " + clients[index].toString());
			} else {
				continue;
			}
		}

	}
}
