# University-DPS

## status
作成期間：2019.10~2020.1　3回生秋学期

## about
京都産業大学 コンピュータ理工学部 2019年度秋 開講の「分散処理システム」の課題を解いたプログラム。

## Version
### Java
```
$ (export JAVA_HOME=`/usr/libexec/java_home -v "14"` ; java -version ; javac -version)
Picked up _JAVA_OPTIONS: -Dfile.encoding=UTF-8
java version "14.0.1" 2020-04-14
Java(TM) SE Runtime Environment (build 14.0.1+7)
Java HotSpot(TM) 64-Bit Server VM (build 14.0.1+7, mixed mode, sharing)
Picked up _JAVA_OPTIONS: -Dfile.encoding=UTF-8
javac 14.0.1
```

### Apache Ant
```
$ ant -version
Picked up _JAVA_OPTIONS: -Dfile.encoding=UTF-8
Apache Ant(TM) version 1.10.8 compiled on May 10 2020
```

### Make
```
$ make --version
GNU Make 3.81
Copyright (C) 2006  Free Software Foundation, Inc.
This is free software; see the source for copying conditions.
There is NO warranty; not even for MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE.

This program built for i386-apple-darwin11.3.0
```

## program
### Ltsa
授業で作成したltsaファイル。

### ThreadPractice
JavaのThreadの練習に用いたプログラム。

### CountDown
課題1「カプセル化を実現したままで正しくThreadを止めよ」
※Apache Antを用いている。

### Garden
課題2「植物園を模倣したプログラムの作成。入場者を並列的にカウントせよ」
※Apache Antを用いている。

### CarPrak
課題3「駐車場を模倣したプログラムの作成。車の入退出、駐車数を並列的にカウントし、駐車台数が満タンになったときに車が入場しないように制御せよ」
※Apache Antを用いている。

### PhilosopherWithSimulator
課題4「哲学者問題を模倣したプログラムの作成。デッドロックを自分なりに回避せよ」
※PhilosopherWithSimulatorはシュミレータを用いている。

### BlockChainWithSimulator
最終課題「ブロックチェーンプログラムの作成。実行時間を計測せよ。」
※BlockChainWithSimulatorはシュミレータを用いている。

### BlockChainReport
最終課題のレポート。upLatexで作成。

## 実行方法
### Apache Ant
+ 実行
```
$make test
```

+ Applicationの生成
```
$make install
```

+ JavaDocの生成
```
$make clean
```

### シュミレータ（PhilosopherWithSimulator）
```
$javac *.java
$java Simulator -c Philosopher -p 3
```

### シュミレータ（BlockChainWithSimulator）
```
$sh javac.sh *.java
$sh java.sh Simulator -c Philosopher -p 3 -t
```
