public class Philosopher extends Process 
{
	/**
	 * PhilosopherのIDを保存するフィールド
	 */
	private Integer id = 0;

	/**
	 * PhilosopherのIDを保存するフィールド
	 */
	private Integer total;

	/**
	 * 右手に持つForkの状態を保存するフィールド
	 */
	private Fork rightFork;

	/**
	 * 左手に持つForkの状態を保存するフィールド
	 */
	private Fork leftFork;


	/**
	 * Philosopherのコンストラクタ
	 */
	public Philosopher(int id, MessageQueue mq)
	{
		super(id, mq);
		this.id = id;

		return;
	}
	
	public void run () 
	{
		this.total = super.getMessageQueue().getTotalNum();

		if(this.id == 0) {
			for(Integer count = 0; count < this.total; count++) {
				final Fork aFork = new Fork(count); // create a Fork
				send(count, new DefaultMessage(0, aFork)); // send it to a process with a certain id (count).
				System.out.println("send to " + count);
				send(((count-1)+total)%total, new DefaultMessage(0, aFork)); // send it to another process.
				System.out.println("send to "+((count-1)+total)%total); 
			}

			try {
				Thread.sleep(1000); // DO NOT REMOVE!!!
			} catch (final InterruptedException interruptedException) { ;	} 
			
		}

		Fork aFork;
		while((this.rightFork == null) || (this.leftFork == null)) {
			if((aFork = receiveFork()) != null) {
				if(aFork.getID() == this.id) {
					this.leftFork = aFork;
					System.out.println("set leftFork " + aFork.getID() + " at Phil. "+this.id);
				}
				else {
					this.rightFork = aFork;
					System.out.println("set rightFork " + aFork.getID() + " at Phil. "+this.id);
				}
			}
			try {
				Thread.sleep(1000); // DO NOT REMOVE!!!
			} catch (final InterruptedException interruptedException) { ; }
		}

		
		for (Integer index = 0; index < 3; index++) {
			this.right();
			super.yield(); // release the CPU resource.
			this.left();
			super.yield(); // release the CPU resource.
			this.eating();
		}

		System.out.println("Phil " + this.id + ": I'm full.");

		return;
	}

	/**
	 * Philosopher #0 から送られたForkを受け取ります
	 */
	private Fork receiveFork() 
	{
		Object c;
		if((c = receive()) != null) {
			final Fork aFork = (Fork) ((Message)c).getContent();

			return aFork;
		}else {
			return null;
		}
	}
	
	/**
	 * Forkを左手で掴む動作を行うメソッド
	 */
	public void right() 
	{
		while(!rightFork.hold(this.id)) {
			System.out.println("Phil " + this.id + ": failed to get a fork");
			try {
				Thread.sleep(1000);
			} catch (final InterruptedException interruptedException) { interruptedException.printStackTrace(); }
		}
		System.out.println("Phil " + this.id + ": holds right fork");

		return;
	}
	
	/**
	 * Forkを右手で掴む動作を行うメソッド
	 */	
	public void left() 
	{
		while(!leftFork.hold(this.id)) {
			System.out.println("Phil " + this.id + ": failed to get a fork");
			try {
				Thread.sleep(1000);
			} catch (final InterruptedException interruptedException) { interruptedException.printStackTrace(); }
		}
		System.out.println("Phil " + this.id + ": holds left fork");

		return;
	}
	
	/**
	 * 両手のForkを離す動作を行うメソッド
	 */	
	public void release()
	{
		rightFork.drop(rightFork.getID());
		leftFork.drop(leftFork.getID());

		return;
	}
	
	/**
	 * 両手のForkを用いて料理を食べる動作を行うメソッド
	 */
	public void eating()
	{
		System.out.println("Phil " + this.id + ": is eating...");
		try {
			Thread.sleep(1000);
		} catch (final InterruptedException interruptedException) { interruptedException.printStackTrace(); }
		this.release();

		return;
	}
}
