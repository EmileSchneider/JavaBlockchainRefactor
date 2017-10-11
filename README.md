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

