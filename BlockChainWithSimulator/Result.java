/**
* This class is for receiving hash values and nonce values.
*
* @author Naohiro Hayashibara & update: Keisuke Ikeda
*
*/

import java.math.BigInteger;

public class Result extends Object
{
    /**
     * A hashed value mined.
     */
    private BigInteger result;

    /**
     * A nonce value
     */
    private Long nonce;

    /**
     * A difficulty bit
     */
    private Integer difficultyBits;

    /**
     *
     * @param r
     * @param n
     * @param d
     */
    public Result(BigInteger r, long n, int d)
    {
        this.result = r;
        this.nonce = n;
        this.difficultyBits = d;

        return;
    }

    /**
     * Get a hash value that has been mined.
     * @return Returns the hash value in {@code BigInteger}.
     */
    public BigInteger getHashValue()
    {
        return this.result;
    }

    /**
     * Get a nonce.
     * @return Returns the nonce in {@code long}.
     */
    public long getNonce()
    {
        return this.nonce;
    }

    /**
     * Get the difficulty bits
     * @return Returns the difficulty bits.
     */
    public Integer getDifficultyBits()
    {
        return this.difficultyBits;
    }
}