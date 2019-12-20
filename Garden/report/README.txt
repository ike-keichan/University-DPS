１.取扱説明 (コンパイル&実行方法)

ディレクトリ設計は以下のようになっている。
$ tree Garden
Garden
├── Counter.class
├── Counter.java
├── Garden.asta
├── Garden.class
├── Garden.java
├── README.txt
├── Turnstile.class
└── Turnstile.java

Gardenディレクトリ内で、以下のコマンドを入力してコンパイルを行う。
$ javac Garden.java

Gardenディレクトリ内で、以下のコマンドを入力して実行を行う。
$ java Garden

2.実行結果 (どのような実行結果になるか？)

実行結果は以下のようになった。

Picked up _JAVA_OPTIONS: -Dfile.encoding=UTF-8
from east: 2
from west: 2
from east: 4
from west: 4
from west: 6
from east: 6
from west: 8
from east: 9
from east: 10
from west: 11
from east: 12
from west: 12
from east: 14
from west: 14
from west: 16
from east: 16
from west: 18
from east: 18
from east: 20
from west: 20
from east: 22
from west: 22
from east: 24
from west: 24

3.考察 (なぜそのような結果になったか？問題点と改善策，類似問題などを書く, 300字以上)
　各スレッドに名前をつけて、どの門から来場者が入ったか（どのスレッドが実行したか）を可視化できるようにプログラムを書き、上記のように、来場した門と来場者数を一度に確認できるような結果を出力した。
　上記の結果を見ると同じ数字が連続している箇所が多く存在する。このような問題が起きる理由として、スレッドが高速に動き、各門に来場者が入り、ターミナルに出力するまでのわずかな時間の間にもう片方の門から来場者が入り、来場者数が増えた状態で出力されるからだと考える。
また、プログラム上ではGardenがもってるカウントが一つではあるが、実際出力してるのはそれぞれのスレッドに対してカウントを出力させるように書いている。しかし、出力される値は両方のスレッドのカウント数の合計になっている。これは、二つのスレッドが同じ変数（メモリ？）に対して値を参照していることになる。
　改善点としては、複数のスレッドの起動タイミングをずらす、それぞれのスレッドのsllep時間を増やすなどが効果的だと推測する。
　類似問題として、並列かつ入出力が複数ある場合が挙げられる。並列状態で入力や出力が行われると今回と同じ問題点が起こりうるだろう。
　以上で考察を終える。
  

