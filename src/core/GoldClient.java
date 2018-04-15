package core;

public class GoldClient extends Client{

	public GoldClient(int id, String name, float balance) {
		super(id, name, balance);
		this.commissionRate= (float) 0.02;
		this.interestRate= (float) 0.003;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " [ Client Type: Gold , id: " + getId() + "]";
	}
	
}
