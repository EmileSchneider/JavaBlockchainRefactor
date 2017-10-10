package blockchain_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import blockchain.Transaction;

public class transaction {

	@Test
	public void test() {
		
		Transaction trans = new Transaction();
		trans.setSender("Emile");
		trans.setRecipient("Lazarus");
		trans.setAmount(5);
		
		System.out.println(trans.getTransactionString());
		assertEquals("EmileLazarus5", trans.getTransactionString());
	}

}
