package blockchain;

import java.util.ArrayList;
import java.util.Arrays;


public class Block {

	Integer ID;
	Integer nonce;
	/* timestamp */
	ArrayList<Transaction> transaction_list = new ArrayList<>();
	byte[] hash; /* no need */
	String previous_hash;
	
	
	public static void main(String[] args) {
		
	}

	/*
	 * SETTERS
	 */
	public void setID(Integer i) {
		this.ID = i;
	}
	public void setNonce(Integer n) {
		this.nonce = n;
	}
	public void setHash(byte[] h) {
		this.hash = h;
	}
	public void setPrevious_hash(String h) {
		this.previous_hash = h;
	}
	/* add Transaction to List */
	public void addTransaction(Transaction trans) {
		transaction_list.add(trans);
	}
	/*
	 * GETTERS
	 */
	public int getID() {
		return this.ID;
	}
	public int getNonce() {
		return this.nonce;
	}
	public ArrayList<Transaction> getTransactionList(){
		return this.transaction_list;
	}
	public byte[] getHash() {
		return this.hash;
	}
	public String getPrevHash() {
		return this.previous_hash;
	}
	/* returns the String of the Block*/
	public String getBlockstring() {
		String stringOfTransactions = "";
		for(int i = 0; i < transaction_list.size(); i++) {
			stringOfTransactions += transaction_list.get(i).getTransactionString();
		}
		
		String hash_string = Arrays.toString(hash);
		String prev_hash_string = previous_hash;
		
		return Integer.toString(this.ID) + Integer.toString(this.nonce) + stringOfTransactions + hash_string + prev_hash_string;
	}

	
	
}
