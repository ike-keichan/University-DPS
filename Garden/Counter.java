public class Counter
{
	/**
	 * カウント数を記憶するフィールド。
	 */
	private int value = 0;

	/**
	 * カウント数を出力するメソッド。
	 */
	public int readValue()
	{
		return this.value;
	}

	/**
	 * カウント数を入力するメソッド。
	 */
	public void writeValue()
	{
		this.value += 1;
	}
}
