package carpark;

import java.util.Random;

/**
 * 出発ゲートのクラス
 */
public class Departures extends Thread 
{

	/**
	 * 駐車スペースの管理をするフィールド。
	 */
	private CarparkControl control;

	/**
	 * 待ち時間を記憶するフィールド。
	 */
	private Integer waitTime;

	/**
	 * 現在駐車できる車の台数と最大で駐車できる車の台数を入力するコンストラクタ。
	 * @param control 現在駐車できる車の台数と最大で駐車できる車の台数
	 */
	public Departures(final CarparkControl control)
	{
		this.control = control;
	}

	/**
	 * 出発ゲートから車が出た時の処理を行うメソッド
	 */
	public void run()
	{
		final Random random = new Random();
		this.waitTime = random.nextInt(100);

		for (int index = 0; index < 20; index++)
		{
			this.control.depart();
			try
			{
				Thread.sleep(this.waitTime);
			}
			catch (final InterruptedException anException) { ; }
		}

		return;
	}

}
