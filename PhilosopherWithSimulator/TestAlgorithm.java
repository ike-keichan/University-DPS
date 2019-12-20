/**
 * The test algorithm
 * Every process sends a message to the coordinator.
 * The coordinator waits messages from majority of processes.
 * 
 *   @author naohaya
 */

public class TestAlgorithm extends Process {
	int id;
	
	public TestAlgorithm(int id, MessageQueue mq) {
		/*
		 * call the constructor of superclass.
		 */
		super(id,mq);
		
		this.id = id;
	}
	
	public void run(){
		/*
		 * call run() method in superclass.
		 * **必須**
		 */
		super.run();	
		
		/*
		 * 以下アルゴリズム本体
		 */
		Object c = null;
		int count = 0;
		
		if (id > 0) {
			/*
			 * Worker
			 * プロセスID=0以外のプロセス
			 */
			send(0, new DefaultMessage(id, new Object()));
			System.out.println("p"+id + ": sent a msg.");
			
		} else {
			/*
			 * Coordinator
			 * プロセスID=0のプロセス
			 */
			send(0, new DefaultMessage(id, new Object()));			
			System.out.println("p"+id + ": sent a msg.");
			
			// receiving messages until majority.
			while (count < (super.getMessageQueue().getTotalNum()/2)+1) {
				
				/*
				 * receive a message
				 * if the message is not null, show the source id and count up,
				 * otherwise, retry. 
				 */
				if ((c = receive()) != null){
					System.out.println("Received a msg from p" + ((Message) c).getSource());
					
					count++;
				}
			}
			System.out.println("Received " + count + " message(s).");
			
		}
	}

}
