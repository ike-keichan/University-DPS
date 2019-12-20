１.取扱説明 (コンパイル&実行方法)

ディレクトリ設計は以下のようになっている。
$ tree g1744069_carpark
g1744069_carpark
├── Arrivals.java
├── Carpark.java
├── CarparkControl.java
├── Departures.java
├── README.txt
├── carpark_g1744069.jar
└── g1744069_CARPARK.lts

<実行方法①>
g1744069_carparkディレクトリ内で、以下のコマンドを入力してコンパイルを行う。
$ javac Carpark.java.

g1744069_carparkディレクトリ内で、以下のコマンドを入力して実行を行う。
$ java Carpark "任意の数字"

<実行方法②>
g1744069_carparkディレクトリ内で、以下のコマンドを入力して実行を行う。
$ java -jar carpark_g1744069.jar "任意の数字"


"任意の数字"には駐車場の最大駐車可能数を入力すること。


2.プログラムの説明
・Carpark.java
メインプログラム。正しい入力値を受け取り、CarparkControlに受け渡している。
他のクラスをインスタンス化し、スレッドの実行を行っている。

・CarparkControl.java
現在駐車できる車の台数と最大で駐車できる車の台数を管理しているプログラム。
現在駐車できる車の台数の変動もメソッドで操作している。

・Arrivals.java
Threadを継承したプログラム。到着ゲートのスレッド処理を担当している。
到着ゲートに車が入場した際にCarparkControlに処理を促す。

・Departures.java
同じく、Threadを継承したプログラム。出発ゲートのスレッド処理を担当している。
出発ゲートから車が出場した際にCarparkControlに処理を促す。


3.拡張した点
・StringBufferを用いて文字列連結の速度を早めている。
・ターミナルでの出力がわかりやすいようにしている。
  

