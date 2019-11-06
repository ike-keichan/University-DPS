public class Turnstile extends Thread
{
	/**
	 * カウント数を入出力するフィールド。
	 */
	public static Counter count;

	/**
	 * カウントアップするメソッド。
	 */
	public void run()
	{
		// 文字列の連結に変数。
		StringBuffer aBuffer = new StringBuffer();

		for (int index = 0; index < 12; index++)
		{
			this.count.writeValue();
			try
			{
				Thread.sleep(10);
				aBuffer.append("from ");
				aBuffer.append(this.getName());
				aBuffer.append(": ");
				aBuffer.append(count.readValue());
				System.out.println(aBuffer.toString());
				aBuffer.delete(0, 100);
			}
			catch (InterruptedException anException) { ; }
		}
	}
}
