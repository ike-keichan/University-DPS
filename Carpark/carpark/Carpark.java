package carpark;

/**
 * 駐車場のクラス、メインクラス
 */
public class Carpark extends Object
{
	/**
	 * メインプログラム
	 * @param arguments 引数の文字列の配列
	 */
	public static void main(String[] arguments)
	{
		//入力値を格納する変数
		int inputNumber = 20;

		//入力値の判別
		if(arguments.length == 0){
			System.out.println("入力がなかったため、コマンドライン引数を「20」とします");
		}else {
			inputNumber = Integer.parseInt(arguments[0]);
		}

		CarparkControl control = new CarparkControl(inputNumber);
		Arrivals arrivals = new Arrivals(control);
		Departures departures = new Departures(control);

		// それぞれのスレッド開始する。
		arrivals.start();
		departures.start();
		
	}

}
