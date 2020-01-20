/**
* This class is for receiving hash values and nonce values.
* 
* @author Naohiro Hayashibara
*
*/

import java.math.BigInteger;

public class Result {
	/**
	* A hashed value mined.
	*/
	BigInteger result;

	/**
	* A nonce value
	*/
	long nonce;

	/**
	* A difficulty bit
	*/
	int difficultyBits;

	Result(BigInteger r, long n, int d) {
		this.result = r;
		this.nonce = n;
		this.difficultyBits = d;
	}

	/**
	* Get a hash value that has been mined.
	* @return Returns the hash value in {@code BigInteger}.
	*/
	public BigInteger getHashValue() {
		return this.result;
	}

	/**
	* Get a nonce.
	* @return Returns the nonce in {@code long}.
	*/
	public long getNonce() {
		return this.nonce;
	}

	/**
	* Get the difficulty bits
	* @return Returns the difficulty bits.
	*/
	public int getDifficultyBits() {
		return this.difficultyBits;
	}
}