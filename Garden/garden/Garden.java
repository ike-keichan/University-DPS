package garden;

/**
 * 植物園のクラス、メインクラス
 */
public class Garden extends Object
{
	/**
	 * カウント数を記憶するフィールド。
	 */
	public static Counter count;

	/**
	 * メインプログラム
	 * @param arguments 引数の文字列の配列
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
