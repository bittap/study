### 責任を割り当てる

## 役割中心の設計のために

データ中心の設計ではなく、役割中心の設計するためには以下の二つの原則を従う必要があります。

+ データよりは挙動にフォーカスする。

  クラスに最も重要なことはデータではなく、他のクラスに提供する挙動。
  
+ 協力という文脈から役割を決める。

  クラスから考えるのではなく、メッセージを先に考える。  
そうすれば、データ中心の設計を避けるようになり結合度は低く凝集度が高くなる。  
仮にクライアントクラス(A)が相手のクラス(B)に料金計算してもらいたい。   
メッセージだけ考えればAクラスはBクラスの実装は考えなくてもいいし、Bクラスの中身はAクラスからカプセル化され、結果として結合度は低く凝集度が高くなる。

## GRASP

上記の責任中心の設計するためにCraig LarmanはGRASP(General Responsibility Assignment Software Pattern(一般的に責任を割り当てるためのソフトウェアパターン))原則を作りました。   
その原則は複数のパターンにより説明しています。   

+ INFORMATION EXPERT(情報専門家)

  責任割り当てる時にはその情報を一番分かっている専門家に委任する。

+ LOW COUPLING(低い結合度)

  クラスとクラスの依存性を低くする。

+ HIGH COHESION(高い凝集度)

  関連があるクラス同士で協力する。

+ CREATOR(生成者)

  仮にAクラスを生成する時にはどのクラスで生成するかを決めるパターン  
以下の条件を多く満たす場合に割り当てる

  1. Aクラスを含んだり参照している。

  2. Aクラスを記録している。

  3. Aクラスをよく使っている。

  4. Aクラスを生成するための情報を持っている。


## 感想

本で作っていたプログラムを見るとどうやってこのように作れたんだろうと疑問があったのですが、上記のパターン等を念頭にした結果でした。  
私も上記のパターンを頭の片隅に入れておいて常にいいトレードオフを選択して設計したいと思いました。

