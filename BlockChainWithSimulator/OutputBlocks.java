/**
* This class is for outputting the hash values of blocks in the chain at the process 0 in CSV format.
*
* @author Naohiro Hayashibara & update: Keisuke Ikeda
*
*/

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class OutputBlocks
{
    /**
     *
     */
    private List<Block> blockChain = new ArrayList<Block>();

    /**
     *
     */
    private Integer id;

    /**
     * @param id
     * @param blockChain
     */
    public OutputBlocks(Integer id, List<Block> blockChain)
    {
        this.blockChain = blockChain;
        this.id = id;

        return;
    }

    /**
     * Output the prev. hash values and the own hash values of blocks in the chain.
     */
    public void output()
    {
        final String filename = "process" + this.id + ".csv";
        try{
            final File file = new File(filename);
            final FileWriter fw = new FileWriter(file);
            final BufferedWriter bw = new BufferedWriter(fw);
            for(final Block block : blockChain) {
                bw.write(block.getBlockNum() + "," + block.getPrevHash().toString(16) + "," + block.getOwnHash().toString(16));
                bw.newLine();
            }
            bw.close();
        }
        catch (final IOException ioException) {
            System.out.println(ioException);
        }

        return;

    }

}
