public class CarparkControl {

	/**
	 * 現在駐車できる車の台数を記憶するフィールド。
	 */
	private int spaces;

	/**
	 * 最大で駐車できる車の台数を記憶するフィールド。
	 */
	private int capacity;

	/**
	 * 現在駐車できる車の台数と最大で駐車できる車の台数を入力するコンストラクタ。
	 */
	public CarparkControl(int inputNumber)
	{
		this.capacity = inputNumber;
		this.spaces = inputNumber;
	}

	/**
	 * 到着ゲートから車が入った時の処理を行うメソッド
	 */
	public synchronized void arrive()
	{
		if(this.spaces > 0){
			this.spaces -= 1;
			StringBuffer aBuffer = new StringBuffer();
			aBuffer.append("IN ｜spaces：");
			aBuffer.append(this.spaces);
			System.out.println(aBuffer.toString());
		}else {
			System.out.println("No parking space!!!");
		}
	}

	/**
	 * 出発ゲートから車が出た時の処理を行うメソッド
	 */
	public synchronized void depart()
	{
		if(this.spaces < this.capacity){
			this.spaces += 1;
			StringBuffer aBuffer = new StringBuffer();
			aBuffer.append("OUT｜spaces：");
			aBuffer.append(this.spaces);
			System.out.println(aBuffer.toString());
		}else {
			System.out.println("No car in the parking space!!!");
		}
	}

}
