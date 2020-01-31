package carpark;

import java.util.Random;

/**
 * 入場ゲートのクラス
 */
public class Arrivals extends Thread
{
    /**
     * 駐車スペースの管理をするフィールド
     */
    private CarparkControl control;

    /**
     * 待ち時間を記憶するフィールド
     */
    private Integer waitTime;

    /**
     * Arrivalsのコンストラクタ
     * @param control 現在駐車できる車の台数と最大で駐車できる車の台数
     */
    public Arrivals(CarparkControl control)
    {
        this.control = control;
    }

    /**
     * 入場ゲートから車が入った時の処理を行うメソッド
     */
    public void run()
    {
        Random random = new Random();
        this.waitTime = random.nextInt(100);

        for (Integer index = 0; index < 20; index++)
        {
            this.control.arrive();
            try
            {
                Thread.sleep(this.waitTime);
            }
            catch (InterruptedException anException) { ; }
        }

        return;
    }
}
