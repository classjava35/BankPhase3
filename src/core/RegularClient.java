package core;

public class RegularClient extends Client{

	public RegularClient(int id, String name, float balance) {
		super(id, name, balance);
		this.commissionRate= (float) 0.03;
		this.interestRate= (float) 0.001;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " [ Client Type: Regular , id: " + getId() + "]";

	}
	
	

}
