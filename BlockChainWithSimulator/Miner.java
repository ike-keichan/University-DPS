
/**
* This class is for mining hash values.
* Once created a mining object, it should be shared among processes.
*
* @author Naohiro Hayashibara
*
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.math.BigInteger;
import org.apache.commons.codec.digest.DigestUtils;

class Miner extends Object
{

    private Block latestBlock = null; // latest block in the chain.
    private Integer hitCounter = 0; // Num. of mining results that match the target.
    private Integer maxMiningValues = 100; // Num. of values return to each client.
    private Integer difficultyBits = 1;	 // The difficulty bit.
    private Long baseTarget = 2L;
    private Long nonce = 0L;
    private BigInteger target;

    /**
     * Constructor
     * @param block is the current latest block.
     * @param diffbits is the current difficulty bits.
     */
    Miner(Block block, Integer diffbits)
    {
        this.difficultyBits = diffbits;
        this.target = this.generatingTarget(this.difficultyBits);
        this.latestBlock = block;

        return;
    }



    /**
     * Obtaining hash values from outside.
     * It requires mutual exclusive access.
     * @return Return a list of {@link Result}s mined with the size defined at {@code maxMiningValues} (100 as a default).
     */
    public synchronized ArrayList<Result> getHashValues()
    {
        return mining(this.latestBlock);
    }

    /**
    * obsolete
    public String createDigest() {
        return createDigest(this.latestBlock);
    }
    */

    /**
     * Creates a digest string from a block.
     * @param block is the block to generate hash values by using its block header.
     * @return Return a digest string as {@code String}.
     */
    public static String createDigest(Block block)
    {
        String digest = Integer.toString(block.getBlockNum())
        + Long.toString(block.getNonce())
        + block.getPrevHash().toString()
        + block.getOwnHash().toString()
        + block.getTimestamp();

        return digest;
    }

    /**
     * Sets new block as the latest block.
     * @param block is the current latest block.
     */
    public void setBlock(Block block)
    {
        if(this.latestBlock == null)
            this.latestBlock = block;

        if(this.latestBlock.getBlockNum() < block.getBlockNum())
            this.latestBlock = block;

        return;
    }

    /**
     * Updates the latest block.
     * @param block is the block set as the latest block.
     */
    public void updateBlock(Block block)
    {
        setBlock(block);

        return;
    }

    /**
     * Gets the latest block.
     * @return Return the latest block registered.
     */
    public Block getBlock()
    {
        if (latestBlock != null) {
            return latestBlock;
        }
        else {
            return null;
        }
    }

    /**
     * Reset the nonce counter.
     *
     */
    private void resetNonce()
    {
        this.nonce = 0L;

        return;
    }

    /**
     * To get the current nonce.
     * @return Return the current nonce value as {@code long}.
     */
    public long getNonce()
    {
        return this.nonce;
    }

    /**
     * Sets new difficulty bits.
     * @param bits is a new difficulty bits.
     */
    public void setDifficultyBits(Integer bits)
    {
        this.difficultyBits = bits;

        return;
    }

    /**
     * To get the current difficulty bits.
     * @return Return the current difficulty bits as {@code int}.
     */
    public Integer getDifficultyBits()
    {
        return this.difficultyBits;
    }

    /**
     * Increments the difficulty bits (but it is not used this time...).
     */
    private void incDifficultyBits()
    {
        this.difficultyBits++;

        return;
    }

    /**
     * Creates an initial block by using mining().
     * @return Return an initial block.
     */
    public Block createInitialBlock()
    {
        Boolean flag = true;
        Block initBlock = new Block(1, 1, 0L,
                                    new Data("This is the first block in the chain."),
                                    new BigInteger("0", 16),
                                    new BigInteger("0", 16),
                                    Calendar.getInstance().getTime().toString());
        while(flag) {
            ArrayList<Result> results = mining(initBlock);

            for(Result r : results) {
            //	System.out.println(r.getHashValue().toString(16));
                if(this.isHit(this.generatingTarget(r.getDifficultyBits()), r.getHashValue())){
            //	if(Miner.isHit(m.getTarget().toString(16), r.getHashValue().toString(16))){
                    System.out.println("Result: "+r.getHashValue().toString(16));
                    System.out.println("Nonce: "+r.getNonce());

                    initBlock.setOwnHash(r.getHashValue());
                    initBlock.setTimestamp(Calendar.getInstance().getTime().toString());
                    flag = false;
                    break;
                }
            }
        }

        return initBlock;
    }

    /**
     * Creates a hash value using the sha3_256 algorithm from a digest and a nonce.
     * @param digest is a digest of a block header.
     * @param nonce is the current nonce.
     * @return Return a hashed digest as {@code String}.
     */
    public static String createHashedDigest(String digest, Long nonce) {
        String result = DigestUtils.sha3_256Hex(digest + Long.toString(nonce));

        return result;
    }

    /**
     * Generates a target for mining.
     * The value should be the block hash if it is smaller than the target.
     * @param diffbits is the difficulty bits to generate the corresponding target.
     * @return Return the generated criterion of mining as {@code BigInteger}.
     */
    public static BigInteger generatingTarget(Integer diffbits)
    {
        BigInteger new_target = BigInteger.valueOf(2);
        new_target = new_target.pow(256-diffbits); // target should be 2^(256-diffbits)
        //		System.out.println("New target: " + tgt.toString(16) + " diffbits: " + diffbits);

        return new_target;
    }

    /**
    * getTarget is to get the current target.
    * @return Return the current criterion of mining as {@code BigInteger}.
    */
    public BigInteger getTarget() {
        return this.target;
    }

    /**
     * Mining hash values using the latest block.
     * It generates the designated num. of hash values declared as maxMiningValues.
     * @param block is the current latest block in the chain.
     * @return Return a list of {@link Result} including mined hash values and nonce values.
     */
    private ArrayList<Result> mining(Block block) {
        ArrayList<Result> results = new ArrayList<Result>();
        String digest = this.createDigest(block);
        String result_string = null;
        BigInteger result;
        //long l_target = Math.pow(2, 256-this.difficultyBits);

        for(int count = 0; count < this.maxMiningValues; count++) {
            result_string = this.createHashedDigest(digest, nonce);
            result = new BigInteger(result_string, 16);
            results.add(new Result(result,nonce,getDifficultyBits()));
            if(target.compareTo(result) == 1){
                hitCounter++; // increment hitCounter whenever a result matches the requirement.
                if(hitCounter%10 == 0) {
                    // increment difficltyBits every 10 hits.
                    // incDifficultyBits();
                }

            }

            nonce++; // increment the nonce

        }

        return results;
    }

    /**
     * Judgeing the hash value is eligible or not according to the target.
     * @param target is the target to judge hash values.
     * @param hashValue is a mined hash value.
     * @return Returns {@code true} if the hash value is smaller than the target and it is eligible as new block hash.
     */
    public static boolean isHit(BigInteger target, BigInteger hashValue)
    {
        if(target.compareTo(hashValue) == 1) {
            return true;
        }
        else {
            return false;
        }

    }

}