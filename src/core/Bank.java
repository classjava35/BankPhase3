package core;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

public class Bank {
	private Client[] clients ;
	private  Logger logService;
	//account updater; leave this one for now
	private Logger logger;
	private float balance;
	private static Bank instance = new Bank();
	private static float commissionSum=0 ;

	
	//Phase 3 - create a singleton Bank CTOR
	private Bank() {
		super();
		logService = new Logger("driverName");
		logger = new Logger("driverName");
		this.balance = balance;
		clients = new Client[100];
	}

	//Phase 3 - create a singleton Bank instance
	// 3. a getter method for the single instance
	public static Bank getInstance(){
		return instance;
	}
	
	//Phase 3 - Calculate static commissionSum
	public  static void addcommision(float commision) {
		commissionSum+=commision;
	}
	
	public void setBalance(Bank b1) {
		float balance =0;
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] != null ) {
				balance+=clients[i].getFortune();
			}
			//Phase 3 - Add the commissionSum to the Bank Balance
			balance+=commissionSum;
		}
		this.balance = balance;	
		// log the operation
		Log log = new Log(System.currentTimeMillis(), 1 , "set Bank Balance", balance);
		logger.log(log);	
	}

	public float getBalance() {
		return balance;
	}
	
	public void addClient(Client client) {
		for (int i = 0; i < clients.length; i++) {
				if (clients[i] == null) {
					clients[i] = client; // add the client
					setBalance(this); // add the client balance to the Bank Balance
					// log the operation
					Log log = new Log(System.currentTimeMillis(), client.getId(), "add account", client.getBalance());
					logger.log(log);
					//
					break;
			}
		}
		System.out.println("You have reached the maximum clients");
	}
	
	//Phase 3 function gets Client instead of Id 
	public void removeClient(Client client){

		for (int i = 0; i < clients.length; i++) {
			if (clients[i] != null && clients[i].equals(client) ) {
				float client_balance = clients[i].getFortune();
				this.balance-= client_balance;
				clients[i] = null; // add the account
				// log the operation
				Log log = new Log(System.currentTimeMillis(), client.getId() , "remove client", this.getBalance());
				logger.log(log);
				//
				break;
			}
		}
	}
	
	public Client[] getClients() {
		return clients;
	}

	public void viewLogs() {
		 //prints all logs that are stored in the logger - leave empty for now
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
