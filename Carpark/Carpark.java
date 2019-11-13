public class Carpark {

	/**
	 * メインプログラム。
	 */
	public static void main(String[] arguments)
	{
		//入力値を格納する変数
		int inputNumber = 0;

		//入力値の判別
		if(arguments.length == 1){
			inputNumber = Integer.parseInt(arguments[0]);
		}else {
			System.out.println("input single number");
		}

		CarparkControl control = new CarparkControl(inputNumber);
		Arrivals arrivals = new Arrivals(control);
		Departures departures = new Departures(control);

		// それぞれのスレッド開始する。
		arrivals.start();
		departures.start();
	}

}
