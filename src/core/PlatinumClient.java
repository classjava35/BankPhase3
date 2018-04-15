package core;

public class PlatinumClient extends Client {

	public PlatinumClient(int id, String name, float balance) {
		super(id, name, balance);
		this.commissionRate = (float) 0.01;
		this.interestRate = (float) 0.005;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " [ Client Type: Platinum , id: " + getId() + "]";

	}
	

}
