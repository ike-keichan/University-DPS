/**
* This class is for outputting the hash values of blocks in the chain at the process 0 in CSV format.
* 
* @author Naohiro Hayashibara
*
*/

import java.io.*;
import java.util.ArrayList;

public class OutputBlocks {
	ArrayList<Block> blockChain;
	int id;

	public OutputBlocks(int id, ArrayList<Block> bc) {
		this.blockChain = bc;
		this.id = id;
	}

	/**
	* Output the prev. hash values and the own hash values of blocks in the chain.
	*/
	public void output() {
		String filename = "process" + this.id + ".csv";
		try{
			File file = new File(filename);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Block block : blockChain) {
				bw.write(block.getBlockNum() + "," + block.getPrevHash().toString(16) + "," + block.getOwnHash().toString(16));
				bw.newLine();
			}
			bw.close();
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}

	}

}