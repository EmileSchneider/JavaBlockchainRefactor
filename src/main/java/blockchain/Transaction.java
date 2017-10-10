package blockchain;

public class Transaction {

	String sender;
	String recipient;
	Integer amount;
	
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * GETTERS
	 */
	
	public String getSender() {
		return this.sender;
	}
	public String getRecipient() {
		return this.recipient;
	}
	public Integer getAmount() {
		return this.amount;
	}
	/*return the transaction String*/
	public String getTransactionString() {
		return getSender() + getRecipient() + Integer.toString(getAmount());
	}
	/*======================================================================*/
	
	/*
	 * SETTERS
	 */
	
	public void setSender(String s) {
		this.sender = s;
	}
	public void setRecipient(String r) {
		this.recipient = r;
	}
	public void setAmount(Integer a) {
		this.amount = a;
	}
}
