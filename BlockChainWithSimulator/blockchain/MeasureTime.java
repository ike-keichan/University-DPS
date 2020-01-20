/**
 * A class for measuring execution time.
 * @author naohaya
 * @version 1.2
 */
public class MeasureTime {
	long startTime;
	long endTime;

	MeasureTime(){}

	/**
	* 計測開始時に呼び出す
	*/
	void start(){
		this.startTime = System.currentTimeMillis();
//		this.startTime = System.nanoTime();
	}

	/**
	* 計測終了時に呼び出す
	*/
	void end(){
		this.endTime = System.currentTimeMillis();
//		this.endTime = System.nanoTime();
	}

	/**
	* 計測した時間を表示する（ミリ秒）
	*/
	long getTime(){
		return endTime - startTime;
	}
}