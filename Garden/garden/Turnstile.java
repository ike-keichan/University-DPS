package garden;

/**
 * 入出場ゲートのクラス
 */
public class Turnstile extends Thread
{
	/**
	 * カウント数を記憶するフィールド。
	 */
	public Counter count;

	/**
	 * カウントアップするメソッド。
	 */
	public void run()
	{
		// 文字列の連結に変数。
		final StringBuffer aBuffer = new StringBuffer();

		for (Integer index = 0; index < 12; index++)
		{
			this.count.writeValue();
			try
			{
				Thread.sleep(10);
				aBuffer.append("from ");
				aBuffer.append(this.getName());
				aBuffer.append(": ");
				aBuffer.append(this.count.readValue());
				System.out.println(aBuffer.toString());
				aBuffer.delete(0, 100);
			}
			catch (InterruptedException anException) { ; }
		}
	}
}
