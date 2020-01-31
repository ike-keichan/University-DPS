package carpark;

/**
 * 駐車場を管理するクラス
 */
public class CarparkControl extends Object
{
    /**
     * 現在駐車できる車の台数を記憶するフィールド
     */
    private Integer spaces;

    /**
     * 最大で駐車できる車の台数を記憶するフィールド
     */
    private Integer capacity;

    /**
     * CarparkControlコンストラクタ
     * @param inputNumber 現在駐車できる車の台数と最大で駐車できる車の台数
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

        return;
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

        return;
    }

}
