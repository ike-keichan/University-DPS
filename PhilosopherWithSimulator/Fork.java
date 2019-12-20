public class Fork extends Object
{
	/**
	 * ForkのIDを保存するフィールド
	 */
	private Integer forkId;

	/**
	 * Philosopherが所持しているかどうかを保存するフィールド
	 */
	private Boolean occupied = false;

	/**
	 * Forkのコンストラクタ
	 * @param aNumber ForkのIDです。
	 */
	public Fork(Integer aNumber)
	{
		this.forkId = aNumber;

		return;
	}

	/**
	 * PhilosopherがForkを掴む動作を行うメソッド
	 * @param aNumber Forkを掴んだPhilosopherのIDです。
	 * @return PhilosopherがForkを掴んだかどうかの真偽値を
	 */
	public synchronized boolean hold(Integer aNumber)
	{
		if(!occupied) {
			occupied = true;
			StringBuffer aBuffer = new StringBuffer();
			aBuffer.append("--Fork ");
			aBuffer.append(this.forkId);
			aBuffer.append(": is occupied by Phil ");
			aBuffer.append(aNumber);
			System.out.println(aBuffer.toString());
			return true;
		}else { return false; }

	}

	/**
	 * PhilosopherがForkを離す動作を行うメソッド
	 * @param aNumber Forkを離したPhilosopherのIDです。
	 * @return PhilosopherがForkを離したかどうかの真偽値
	 */
	public synchronized boolean drop(Integer aNumber)
	{
		if(occupied) {
			occupied = false;
			StringBuffer aBuffer = new StringBuffer();
			aBuffer.append("--Fork ");
			aBuffer.append(this.forkId);
			aBuffer.append(": is released by Phil ");
			aBuffer.append(aNumber);
			System.out.println(aBuffer.toString());
			return true;
		}else { return false; }

	}

	/**
	 * ForkのIDを取得するゲッターメソッド
	 * @return forkId  ForkのID
	 */
	public Integer getID() {
		return this.forkId;
	}
}
