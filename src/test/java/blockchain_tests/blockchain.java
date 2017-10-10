package blockchain_tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import blockchain.*;

public class blockchain {
	
	Blockchain blockchain = new Blockchain();

	@Test
	public void test() {
		assertEquals("[3, -84, 103, 66, 22, -13, -31, 92, 118, 30, -31,"
				+ " -91, -30, 85, -16, 103, -107, 54, 35, -56, -77, -120,"
				+ " -76, 69, -98, 19, -7, 120, -41, -56, 70, -12]", 
				Arrays.toString(Blockchain.hash("1234")));
		
	}
	
	@Test
	public void test2() {
		blockchain.new_block();
		assertEquals(0, blockchain.getBlockchain().size());
	}
	
	@Test
	public void test3() {
		blockchain.new_block();
		blockchain.new_transaction("Emile", "Lazarus", 5);
		Block b = blockchain.getCurrentBlock();
		System.out.println(b.getTransactionList().get(0).getTransactionString());
		b.setHash(blockchain.hash("123"));
		b.setPrevious_hash(blockchain.hash("321"));
		
		//System.out.println(b.getBlockstring());
	}

}
