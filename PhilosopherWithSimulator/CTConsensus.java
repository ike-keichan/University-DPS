/**
 * This class implements Chandra-Toueg Consensus Algorithm [CT96]
 * 
 * [CT96] T. D. Chandra and S. Toueg, "Unreliable Failure Detectors for Reliable Distributed Systems", 
 * JACM 43(2):225-267, 1996. 
 * 
 * @author naohaya
 *
 */
public class CTConsensus extends Process {
	int id;
	
	public CTConsensus(int id, MessageQueue mq) {
		super(id,mq);		
		this.id = id;
	}
	
	public void run () {
		
	}

}
