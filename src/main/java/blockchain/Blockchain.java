package blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Blockchain {
	
	Block current_block = new Block();
	ArrayList<Block> blockchain = new ArrayList<>();
	
	public static void main(String[] args) {
	}
	
	/*
	 * GETTERS
	 */
	public ArrayList<Block> getBlockchain(){
		return this.blockchain;
	}
	public Block getCurrentBlock() {
		return this.current_block;
	}
	
	/* =================================== */
	
	public void register_node() {
		/*
		 * Add a new nod to the list of nodes
		 * 
		 * :param address: <str> Address of node. Eg. 'http://192.168.0.5:5000'
         * :return: None
		 * */
	}
	
	public boolean valid_chain() {
		/*
		 *    Determine if a given blockchain is valid
        		:param chain: <list> A blockchain
        		:return: <bool> True if valid, False if not
		 */
		Block last_block = blockchain.get(0);
		int current_index = 1;
		
		while(current_index < blockchain.size()) {
			Block block = blockchain.get(current_index);
			
			/* check that the hash of the block is correct*/
			if(block.getPrevHash() != hash(last_block.getBlockstring())) {
				return false;
			}
			
			/* check that the proof of work is correct */
			if(!valid_proof(1,2 /* check the inputs man*/)) {
				return false;
			}
			
			last_block = block;
			current_index += 1;
		}
		
		return true;
	}
	
	
	
	public boolean resolve_conflicts() {
		/* 
			This is our consensus algorithm, it resolves conflicts
        	by replacing our chain with the longest one in the network.
        	:return: <bool> True if our chain was replaced, False if not 
		 */
		return true;
	}
	
	public void new_block() {
		/*        
		Create a new Block in the Blockchain
        	:param proof: <int> The proof given by the Proof of Work algorithm
        	:param previous_hash: (Optional) <str> Hash of previous Block
        	:return: <dict> New Block 
		 */
		Block block = new Block();
		block.setID(blockchain.size() + 1);
		current_block = block;		
	}
	
	public void new_transaction(String s, String r, Integer a) {
		/*
        Creates a new transaction to go into the next mined Block
        :param sender: <str> Address of the Sender
        :param recipient: <str> Address of the Recipient
        :param amount: <int> Amount
        :return: <int> The index of the Block that will hold this transaction
		 */
		
		Transaction trans = new Transaction();
		trans.setAmount(a);
		trans.setRecipient(r);
		trans.setSender(s);
		current_block.addTransaction(trans);
	}
	
	public int proof_of_work(Integer last_proof) {
		/*
        Simple Proof of Work Algorithm:
         - Find a number p' such that hash(pp') contains leading 4 zeroes, where p is the previous p'
         - p is the previous proof, and p' is the new proof
        :param last_proof: <int>
        :return: <int> 
		 */
		Integer proof = 0;
		while (valid_proof(last_proof, proof) == false) {
			proof += 1;
		}
		return proof;
	}
	
	
	public boolean valid_proof(Integer last_proof, Integer nonce) {
		/*        
		Validates the Proof
        	:param last_proof: <int> Previous Proof
        	:param proof: <int> Current Proof
        	:return: <bool> True if correct, False if not.
		 */
		String guess = Integer.toString(last_proof) + Integer.toString(nonce);
		byte[] hash = hash(guess);
		String h = hash.toString();
		if(h.substring(0, 4) == "0000") {
			return true;
		} else {
			return false;
		}
	}
	public static byte[] hash(String input) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
		return hash;
	}
}