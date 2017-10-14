package blockchain;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.common.hash.Hashing;

//import org.apache.commons.codec.digest.DigestUtils.sha256Hex(stringText);


public class Blockchain {
	
	Block  current_block;
	ArrayList<Block> blockchain = new ArrayList<>();
	
	public void main(String[] args) {
		Block genesis_block = new Block();
		
		genesis_block.setID(0);
		genesis_block.setPrevious_hash("0");
		Transaction gift_from_gods = new Transaction();
		gift_from_gods.setSender("JHV");
		gift_from_gods.setRecipient("Emile");
		gift_from_gods.setAmount(50);
		genesis_block.addTransaction(gift_from_gods);
		
		current_block = genesis_block;
		this.mine();
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
	
	public void mine() {
		/*
		//check if block is complete.
		if(current_block.getID() == (int)current_block.getID()) {
		} else {
			break;
		}
		
		if(current_block.getTransactionList().size() == 0) {
			break;
		}
		//somethin..
		if(current_block.getPrevHash()) {
			
		}
		*/
		
		int nonce = 0;
		String block_string = current_block.getBlockstring();
		String hash = Blockchain.hash(block_string);
		
		while(valid_proof(hash) == false) {
			nonce += 1;
			current_block.setNonce(nonce);
			block_string = current_block.getBlockstring();
			hash = Blockchain.hash(block_string);
		}
		
		blockchain.add(current_block);
	}
	
	public static int proof_of_work(Integer last_proof) {
		/*
        Simple Proof of Work Algorithm:
         - Find a number p' such that hash(pp') contains leading 4 zeroes, where p is the previous p'
         - p is the previous proof, and p' is the new proof
        :param last_proof: <int>
        :return: <int> 
		 */
		Integer proof = 0;
		while (valid_proof(last_proof, proof) == false) {
			System.out.print(proof);
			System.out.print(Blockchain.hash(Integer.toString(last_proof) + Integer.toString(proof)));
			proof += 1;
		}
		return proof;
	}
	
	
	public static boolean valid_proof(String hash) {
		/*        
		Validates the Proof
        	:param: <String> gets a hash as a string         	
        	:return: <bool> True if hash proofs work
		 */
		
		/* the hash is "valid" if it starts with a 0 (could be also 5 or 120)*/
		if(hash.substring(0, 1) == "0") {
			return true;
		} else {
			return false;
		}
	}
	
	public static String hash(String input) {
		return Hashing.sha256().hashString(input, StandardCharsets.UTF_8).toString();	}
}


































