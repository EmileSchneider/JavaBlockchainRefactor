package blockchain_tests;

import blockchain.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class block_tests {

	@Test
	public void test() {
		
		Block block = new Block();
		
		block.setID(1);
		block.setNonce(1);
		
		byte[] h = Blockchain.hash("123");
		byte[] ph = Blockchain.hash("321");
		
		block.setHash(h);
		block.setPrevious_hash(ph);
		
		Transaction trans = new Transaction();
		trans.setAmount(5);
		trans.setRecipient("Lazarus");
		trans.setSender("Emile");
		
		block.addTransaction(trans);
		
		assertEquals("11EmileLazarus5[-90, 101, -92, 89, 32, 66, 47, -99, 65, 126, 72, 103, -17, -36, 79, -72, -96, 74, 31, 63, -1, 31, -96, 126, -103, -114, -122, -9, -9, -94, 122, -29][-115, 35, -49, 108, -122, -24, 52, -89, -86, 110, -34, -43, 76, 38, -50, 43, -78, -25, 73, 3, 83, -116, 97, -67, -43, -46, 25, 121, -105, -85, 47, 114]"
, block.getBlockstring());
		
	}

}
