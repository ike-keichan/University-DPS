import java.util.Random;

public class Departures extends Thread {

	/**
	 * 駐車スペースの管理を行うフィールド。
	 */
	private static CarparkControl control;

	/**
	 * 待ち時間を管理するフィールド。
	 */
	private static int waitTime;

	/**
	 * 現在駐車できる車の台数と最大で駐車できる車の台数を入力するコンストラクタ。
	 */
	public Departures(CarparkControl control)
	{
		this.control = control;
	}

	/**
	 * 出発ゲートから車が出た時の処理を行うメソッド
	 */
	public void run()
	{
		Random random = new Random();
		this.waitTime = random.nextInt(100);

		for (int index = 0; index < 20; index++)
		{
			this.control.depart();
			try
			{
				Thread.sleep(this.waitTime);
			}
			catch (InterruptedException anException) { ; }
		}
	}

}
