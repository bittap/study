# 6章から10章の復習

## 6章(メッセージとインタフェース)

### 内容

6章ではメッセージとインタフェースの違いについて説明します。   
その後、よいインタフェースを作る4個の規則を紹介します。


### 感想

4個の規則についてすっかり忘れていました。   
次回からは忘れないように以下の4個の規則について簡単にまとめました。   

1. ディミッター法則(Law of Demeter)   
実装で言うとAクラスがBクラスのインスタンスCクラスを使わないこと。例) B.C.xx() (NG)
2. 聞かずに命令する  
メッセージを送信する際にはメッセージを受信する側の状態(Instance)は考慮せず送ること。
例) if(B.getxxx) B.B1() else B.B2()
3. 意図を表すインタフェース  
インタフェースの名前を付ける際にはgetXXX等にするのではなく、hasXXX,holdXXX等にしてその意図を表す名前にすること   
4. 命令とクエリの分離
命令はクラスの状態を変更すること、クエリはクラスの状態により結果を表示すること。    
命令は結果を表してはいけない。また、クエリはクラスの状態を変更してはいけない。  
例) 出力メソッドprintがクラスの状態を変更し、結果が変わる等

※ 詳細な内容は[6章](https://github.com/bittap/study/tree/main/src/main/java/com/my/study/object/chapter06)を参考

## 7章(設計方法の歴史)

### 内容

7章では以下の順で設計方法を紹介してそれの発展について説明します。  
+ トップダウン型
+ モジュール型
+ オブジェクト型
発展した理由は昔の設計方法は問題を抱えているためです。   
今まで抱えている問題を解決した設計方法が「オブジェクト型」です。   

### 感想

トップダウンとモジュール型のコードを見た時少し問題があるように感じました。
昔は何が問題か全く分からなかったですが、少し成長した気がして嬉しいです。

## 8章(結合度の管理)

### 内容

この章は結合度が低くする方法を紹介します。     
結合度を低くする方法は以下になります。   
+ abstractとinterfafceのクラスに依存する   
+ クラスの内部でnewを使わないこと ※ 正し、newする対象のクラスを大抵使う場合はOK   
  ⇒理由は内部でnewを使って隠すとどのクラスを使うか把握しにくいし、他のクラスに依存したい場合はコードを修正する必要があるため
+ 処理に例外を置かないこと   
  ⇒例外を設けるとだめな話ではない。   
  例えば、映画料金割引計算クラスがあって割引の種類は固定とパーセント、なしがあるとする。   
  なしの場合処理の中にこのようなコードを追加して実装しがちですが、この例外コードはコードの修正が発生するし、パラメータ等で割引なしの意図が見えないためよくない。  
  ```
  if(discountPolicy === null) 
      return 0;
  ```


### 感想

この章について前回から身につけている内容だと思いました。   
実際にもよく意識している内容でした。  

## 9章(柔軟な設計)

### 内容

この章は8章の方法を原則として説明します。
原則で言うことによって設計について話す相手と共通の用語で話せるようになるといいます。  
[原則]  
1. 開放・閉鎖  
  ⇒要件の変更には開放、コードの修正には閉鎖
2. 生成と使用の分離  
  ⇒クラス中で他のクラスの生成と使用をしないこと
3. 依存性の注入  
  ⇒他のクラスをインストラクター、setter、メソッドで受け取って協力すること
4. 依存性の逆転   
  ⇒従来は上位クラスが下位クラスに依存する。オブジェクト指向では上位クラスは上位クラスに依存する。


### 感想

この章は8章と似てっている内容の上に8章については自身があったため、苦労せずに読み取れました。    
オブジェクト指向では[原則]1(開放・閉鎖 )が特に魅了的でした。   
その理由はコードを修正せずに要件の変更ができるのは知らない人には魔法のように見えるからです。

## 10章(継承とコード再使用)

### 内容

継承はコードを再使用できる強いメリットがあります。   
しかし、そのために継承を使うと親と子クラスの結合度が強くなって逆に変更に柔軟に対応できないことになります。   

継承はコードを再利用するために使うのではなく、変更しないところを変更するところから切り分けて変更するところを継承する時こそ力を発揮します。   



### 感想

昔は重複するコードがあると継承を使って重複コードをなくしたりしました。   
しかし、前回この本を読んでからは重複コードをなくすために継承は使わないようにしました。   
身に着けた内容だったのですが、もう一回覚えているか確かめる機会になってよかったです。