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
            File file = new File(filename);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int index = 0; index < this.blockChain.size(); index++) {
                bw.write(this.blockChain.get(index).getBlockNum() + "," + this.blockChain.get(index).getPrevHash().toString(16) + "," + this.blockChain.get(index).getOwnHash().toString(16));
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
