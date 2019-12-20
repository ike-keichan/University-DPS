package garden;

/**
 * 入場者数をカウントするカウンターのクラス
 */
public class Counter extends Object
{
	/**
	 * カウント数を記憶するフィールド。
	 */
	private Integer value = 0;

	/**
	 * カウント数を出力するメソッド。
	 * @return 入場者のカウント数
	 */
	public Integer readValue()
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
