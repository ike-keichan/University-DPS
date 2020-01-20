/**
 * The global message queue
 * The message queue is shared by all processes in a run.
 * That's why, it is created (instanciated) by Simulator at once.
 * @author naohaya
 */

import java.util.concurrent.ArrayBlockingQueue; 
import java.util.List;
import java.util.ArrayList;

public class MessageQueue {
	int num = 0;
	
	List<ArrayBlockingQueue<Message>> msgqueue;
	
	public MessageQueue(int n) {
		num = n;
	
		msgqueue = new ArrayList<ArrayBlockingQueue<Message>>();
	
		for (int i = 0; i < num; i++) {
			msgqueue.add(new ArrayBlockingQueue<Message>(2*num));
		}
	}
	
	/*
	 * return total number of processes that participate in the run.
	 */
	public int getTotalNum(){
		return num;
	}
	
	/*
	 * Enqueue a message into the global message queue.
	 * Need concurrency control.
	 */
	public synchronized void enqueue (int dest, Message m) {
		(msgqueue.get(dest)).add(m);
	}
	
	/*
	 * Dequeue a message from the global message queue.
	 */
	public Message dequeue (int id) {
		return (Message) (msgqueue.get(id)).poll();
	}

}
