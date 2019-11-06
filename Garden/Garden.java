public class Garden
{
	/**
	 * カウント数を入出力するフィールド。
	 */
	public static Counter count;

	/**
	 * メインプログラム。
	 */
	public static void main(String[] arguments)
	{
		Turnstile eastTurnstile = new Turnstile();
		Turnstile westTurnstile = new Turnstile();
		count = new Counter();

		// Gardenの持つcountをTurnstileのcountに参照させる。
		eastTurnstile.count = count;
		westTurnstile.count = count;

		// それぞれのスレッドを命名する。
		eastTurnstile.setName("east");
		westTurnstile.setName("west");

		// それぞれのスレッド開始する。
		eastTurnstile.start();
		westTurnstile.start();
	}
}
