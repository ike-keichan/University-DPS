/**
* This class is the implementation of a block.
* The blockchain is represented as a list of blocks.
* 
* @author Naohiro Hayashibara
*
*/

import java.math.BigInteger;

public class Block
{

	/*
	* Block header
	*/
	private int blockNum = -1;
	private int difficultyBits = 0;
	private long nonce = -1;
	private BigInteger prevHash = null;
	private BigInteger ownHash = null;
	private String timestamp = null; // TODO: to be Date instead of String

	/*
	* Block content
	*/
	private Data data = null;


	public Block(){

	}

	/**
	* The constructor of the class {@link Block}.
	* @param blockNum the sequence number of the block.
	* @param diffbits the difficulty bits.
	* @param nonce the nonce value.
	* @param data data that is represented as {@code String}.
	* @param prevHash the hash value of the previous block in {@code BigInteger}.
	* @param ownHash the hash value of the block in {@code BigInteger}.
	* @param ts the timestamp that is represented as {@code String}.
	*/
	public Block(int blockNum, int diffbits, long nonce, Data data, BigInteger prevHash, BigInteger ownHash, String ts) {
		this.blockNum = blockNum;
		this.difficultyBits = diffbits;
		this.nonce = nonce;
		this.data = data;
		this.prevHash = prevHash;
		this.ownHash = ownHash;
		this.timestamp = ts;
	}

	/**
	* Get the sequence number of a block.
	* @return Returns the sequence num in {@code int}.
	*/
	public int getBlockNum() {
		return this.blockNum;
	}

	/**
	* Set a sequence number of a block.
	* @param bnum a seq. number to be set.
	*/
	public void setBlockNum(int bnum) {
		this.blockNum = bnum;
	}

	/**
	* Get the difficulty bits when the block has been mined. 
	* @return Returns the difficulty bits in {@code int}.
	*/
	public int getDifficultyBits() {
		return this.difficultyBits;
	}

	/**
	* Set a difficulty bit
	* @param diffbits a difficulty bit to be set.
	*/
	public void setDifficultyBits(int diffbits) {
		this.difficultyBits = diffbits;
	}
	
	/**
	* Get data from the block.
	* @return Returns {@link Data} from the block.
	*/
	public Data getData() {
		return this.data;
	}

	/**
	* Set data to a block.
	* @param d data to be set in a block.
	*/
	public void setData(Data d) {
		this.data = d;
	}

	/**
	* Get the hash value of the previous block.
	* @return Returns the hash value in {@code BigInteger}.
	*/
	public BigInteger getPrevHash() {
		return this.prevHash;
	}

	/**
	* Set the hash value of the previous block.
	* @param prevhash the previous hash value to be set.
	*/
	public void setPrevHash(BigInteger prevhash) {
		this.prevHash = prevhash;
	}

	/**
	* Get the hash value of the block.
	* @return Returns the hash value of the block in {@code bBigInteger}.
	*/
	public BigInteger getOwnHash() {
		return this.ownHash;
	}

	/**
	* Set a hash value that has been mined for the block.
	* @param ownhash a hash value for the block.
	*/
	public void setOwnHash(BigInteger ownhash) {
		this.ownHash = ownhash;
	}

	/**
	* Set a nonce value.
	* @param nonce a nonce value.
	*/
	public void setNonce(long nonce) {
		this.nonce = nonce;
	}

	/**
	* Get a nonce value.
	* @return Returns the nonce value in {@code long}. 
	*/
	public long getNonce() {
		return this.nonce;
	}

	/**
	* Set a timestamp of the block.
	* @param ts a timestamp of the block.
	*/
	public void setTimestamp(String ts) {
		this.timestamp = ts;
	}

	/**
	* Get a timestamp of the block.
	* @return Returns the timestamp in {@code String}.
	*/
	public String getTimestamp() { // return Date instead of String
		return this.timestamp;
	}
	
}
