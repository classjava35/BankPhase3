package core.testings;

import core.Account;
import core.Bank;
import core.Client;
import core.GoldClient;
import core.Log;
import core.Logger;
import core.PlatinumClient;
import core.RegularClient;

public class Test2 {

	public static void main(String[] args) {

		// Bank b1 CTOR
		System.out.println("** Creation of New Bank b1 **");
		Bank b1 = Bank.getInstance();
		
		
		// Client CTOR
		System.out.println();
		System.out.println("** Creation of New Client c1 for 'Moshe Levi' id 101 with 5,000 balance **");
		Client c1 = new RegularClient(101, "Moshe Levi", 5_000);
		System.out.println();
		
		System.out.println("** Creation of New Client c2 for 'Sara Levi' id 102 with 10,000 balance **");
		Client c2 = new GoldClient(102, "Sara levi", 10_000);
		System.out.println();
		
		System.out.println("** Creation of New Client c3 for 'Lior Levi' id 103 with 15,000 balance **");
		Client c3 = new PlatinumClient(103, "Lior levi", 15_000);
		System.out.println();
		
		//Adding Clients to Banks
		System.out.println("*** Adding Clients to Banks ***");
		System.out.println();
		System.out.println("*******   adding Moshe Levi client 1 to Bank 1  b1************");
		b1.addClient(c1);//adding Moshe Levi client 1 to Bank 1
		System.out.println();

		System.out.println();
		System.out.println("*******   adding Sara Levi client 2 to Bank 1 b1 ************");
		b1.addClient(c2);//adding Sara Levi client 2 to Bank 1
				
				
		System.out.println("Bank b1 current Balance is : "+b1.getBalance()); 
		

		
		System.out.println();

		//Adding or removing  accounts to the Customers
		System.out.println("** Add first Account Under customer 'Moshe Levi' id 101 with 25,000 balance **");
		Account a1 =new Account(5001, 25_000);
		c1.addAccount(a1);
		System.out.println();
		
		System.out.println("** Get account ID at for Account in index 0 **");
		System.out.println(c1.getAccounts(0).getId());
		System.out.println();

		System.out.println("** Add Second Account Under customer 'Moshe Levi' id 101 with 45,000 balance **");
		Account a2 =new Account(6001, 45_000);
		c1.addAccount(a2);
		System.out.println();
		
		System.out.println("** Get account ID at for Account in index 1 **");
		System.out.println(c1.getAccounts(1).getId());
		System.out.println();
		
		
		System.out.println("** Remove account ID 6001 **");
		c1.removeAccount(a1);
		System.out.println();
		
		
		System.out.println("** Add three Accounts Under customer 'Sara Levi' id 102 with 10,000 balance each**");
		c2.addAccount(new Account(7001, 10_000));
		c2.addAccount(new Account(8001, 10_000));
		c2.addAccount(new Account(9001, 10_000));
		System.out.println();
		
		c2.deposit(60) ;
		c2.withdraw(20);

		
		System.out.println("Client 2 - 'Sara Levi' Total balance All accounts+ balance is : "+c2.getFortune());
		


		//Bank Balance before setting
		System.out.println();
		System.out.println("***Bank 1 b1 Balance before setting***");
		System.out.println(b1.getBalance());
		System.out.println();


		//Set Bank Balance
		System.out.println("***Set Bank 1 b1 Balance including all Sub-Accounts***");
		b1.setBalance(b1);

		//Bank Balance After setting
		System.out.println();
		System.out.println("***Bank 1 b1 Balance After setting***");
		System.out.println(b1.getBalance());
		
		//remove Client
		System.out.println("***  remove Client 102 Sara Levi *****");
		b1.removeClient(c2);
	}
}
