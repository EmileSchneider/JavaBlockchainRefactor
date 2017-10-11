# JavaBlockchainRefactor

# A Simple Blockchain Written In Java

## How A Blockchain Works

A blockchain is a linked list of so called blocks.

Each block consists of:
  * an ID
  * a number called NONCE
  * a copy of the HASH from the previous block
  * DATA e.g. in form of transactions like bitcoin
  * and a hash with a PROOF OF WORK
  
# Design

The software consists of three different classes.

1. a Blockchain class
2. a Block class
3. a Transaction class

The Blockchain class (BC) holds an `ArrayList<Blocks>`. The Block class (BL) holds
an `ArrayList<Transaction>`. The Transaction class (TC) holds a `String` sender, a `String` recipient, and a `int` amount.


## BC
The BC creates a new BL and access it with `current_block`. The BC **will soon** organize the networking and messaging with different nodes of the network. Currently it just handles the creation of blocks, the creation and writing of transactions, and checks the validity of his own blockchain.

###### `valid_chain()`

###### `new_block()`

###### `proof_of_work()`

###### `valid_proof()`

###### `hash()`

## BL
The `addTransaction(Transaction trans)` takes in a transaction and appends it to the list
The BL has a `getBlockstring()` method.It returns a `String` made up by all the elements of a block. 
```
it would probably better to put a hashing method inside the block and not out-source it to the BC
```

## TC

Self explaining

