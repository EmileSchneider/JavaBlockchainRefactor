package blockchain_tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import blockchain.*;

public class blockchain {
	
	Blockchain bc = new Blockchain();

	@Test
	public void test() {
		assertEquals("[3, -84, 103, 66, 22, -13, -31, 92, 118, 30, -31,"
				+ " -91, -30, 85, -16, 103, -107, 54, 35, -56, -77, -120,"
				+ " -76, 69, -98, 19, -7, 120, -41, -56, 70, -12]", 
				Arrays.toString(Blockchain.hash("1234")));
		
	}
	
	@Test
	public void test_new_block() {
		bc.new_block();
		assertEquals(bc.getBlockchain().size() + 1, bc.getCurrentBlock().getID());
	}
	
	@Test
	public void test_new_transaction() {
		bc.new_transaction("Emile", "Laz", 5);
		String trans_string = bc.getCurrentBlock().getTransactionList().get(0).getTransactionString();    
		assertEquals("EmileLaz5", trans_string);
	}
	@Test 
	public void test_proof_of_work() {
		
	}

}
