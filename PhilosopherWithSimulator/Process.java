/**
 * An implementation of process entity.
 * Algorithm implementation has to be extended this class.
 * @author naohaya
 */

public class Process extends Thread {
	/**
	 * メッセージキュー
	 */
	MessageQueue mq;
	
	/**
	 * プロセスID
	 */
	int id;
	
	/**
	 * 遅延時間指定
	 */
	long delay = 0;	// Delay time till start.
	
	/**
	 * 故障するまでの時間指定
	 */
	long ttf = 0; 	// Time to failure.
	
	/**
	 * The constructor receives process id and message queue.
	 * @param id プロセスID
	 * @param mq メッセージキュー
	 * @throws InterruptedException 
	 */
	Process(int id, MessageQueue mq) {
		this.id = id;
		this.mq = mq;
	}
	
	/**
	 * send() method realizes sending a message to another process.
	 * sending a message is actually implemented as enqueuing the message
	 * into message queue of the destination process. 
	 * TODO: make another send method without destination argument (broadcast)
	 * @param dest 宛先のプロセスID
	 * @param m メッセージ本体
	 */
	public void send(int dest, Message m) {
		mq.enqueue(dest,m);
	}
	
	/**
	 * receive() method realizes receiving a message from another process.
	 * receiving a message is actually implemented as dequeuing the message
	 * from own message queue.
	 * receiving messages may fail and return null because of empty of the message queue. 
	 * @return a message dequeued from the message queue and cast it into Message class.
	 */
	public Message receive() {
		return (Message) mq.dequeue(id);
	}
	
	/**
	 * Set the MessageQueue
	 * @param mq
	 */
	public void setMessageQueue(MessageQueue mq) {
		this.mq = mq;
	}
	
	/**
	 * Get the MessageQueue
	 * @return MessageQueue
	 */
	public MessageQueue getMessageQueue(){
		return mq;
	}
	
	/**
	 * To set a delay time.
	 * @param msec
	 */
	public void setDelayTime(long msec) {
		delay = msec;
	}
	
	/**
	 * To get a delay time.
	 * @return delay
	 */
	public long getDelayTime(){
		return delay;
	}
	
	/**
	 * The method is to delay a process initiation.
	 * 
	 */
	public void delayStart() {
		try {
			Thread.sleep(delay);
		} catch(InterruptedException ie) {
			
		}
	}

	/**
	 * The method is to delay a process initiation.
	 * @param msec
	 */	
	public void delayStart(long msec) {
		setDelayTime(msec);
		delayStart();
//		System.out.println("p"+id+" is delayed for "+msec+" msec.");
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		// delayed start with random generated time.
		delayStart((long) Math.ceil(Math.random()*100)); 
				

	}

}
