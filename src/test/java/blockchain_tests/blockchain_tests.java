package blockchain_tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import blockchain.*;

public class blockchain_tests {
	
	Blockchain bc = new Blockchain();

	@Test 
	public void testGenesisBlock() {
		assertTrue(bc.getBlockchain().size() > 0);
		// because the genesis block was created
		Transaction genesis_transaction = bc.getBlockchain().get(0).getTransactionList().get(0);
		assertEquals("Emile", genesis_transaction.getRecipient());
		assertEquals("JHV", genesis_transaction.getSender());
		assertEquals("50", genesis_transaction.getAmountAsString());
		
	}

}
