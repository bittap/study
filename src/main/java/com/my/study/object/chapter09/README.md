# 柔軟な設計

この章は8章の内容「柔軟な設計をするために依存性を管理する方法」を原則として説明します。  
著者は内容は重複されるところがあると思うけど、原則を知ることで皆と設計に対して会議する時に共通の用語を知ることで設計の知識を増やしていくと思い、この章を書きました。

##原則

1. 開放・閉鎖原則

ソフトウェアは拡張には開いていて修正には閉じていることが望ましい。  
+ 拡張には開いている
アプリケーションの要件が追加されたとき、要件に合わせて動作を拡張できること
+ 修正には閉じている
既存のコードを修正せずに、アプリケーションの動作を追加・変更できる

抽象化クラスを使うと上記のことができる。  
8章と同じく映画割引プログラムで説明する。  

【映画割引プログラム】    
依存元：Movie  
依存先：DiscountPolicy(割引)［親クラス］、PercentDiscountPolicy(パーセント割引)［子クラス］、AmountDiscountPolicy(金額割引)［子クラス］

例えば、要件で割引に複数割引または割引なしの二つの動作が追加されたとする。　　　   
上記に列挙したクラスに修正せずに、OverLappedDiscountPolicy(複数割引)、ZeroDiscountPolicy(割引なし)クラスを追加するだけで拡張ができる。  

2. 生成と使用の分離

クラスの生成と使用は分離する必要がある。   
生成と使用を一緒にするとそのクラスに対し、必要な知識が増えてしまい、結合度が高く凝集度が低くなる。   

例えば、上記1の映画割引プログラムで説明する。

+ 一緒に生成と使用する

```
class Movie{
	private DiscountPolicy discountPolicy;
	
	public Movie(){
		this.discountPolicy = new DiscountPolicy(List.of(
		// 期間割引条件を追加
		new PeriodDiscountCondition(LocalTime.xxx,LocalTime.xxx), 
		// 順番割引条件を追加
		new SequenceDiscountCondition(5)))
	}
	
	public int calculate(...){
		return this.discountPolicy.calculateFee(...)
	}
}
```
MoviceクラスがDiscountPolicyだけではなく、PeriodDiscountConditionとSequenceDiscountConditionに結合することになる。

+ 分離して生成と使用する

```

class Movie{
	private DiscountPolicy discountPolicy;
	
	public Movie(DiscountPolicy discountPolicy){
		this.discountPolicy = discountPolicy;
	}
	
	public int calculate(...){
		return this.discountPolicy.calculateFee(...)
	}
}

// データクラス
class Data{
	public ... getxxxMovice(...){
		DiscountPolicy discountPolicy = new DiscountPolicy(List.of(
		// 期間割引条件を追加
		new PeriodDiscountCondition(LocalTime.xxx,LocalTime.xxx), 
		// 順番割引条件を追加
		new SequenceDiscountCondition(5)))
		Movie movie = new Movie(discountPolicy);
		return movie;
	}
}

// 予約クラス
class Reservation{
	public ... reserve(...){
		int movieFee = data.getxxxMovice(xxx).calculate;
		...
	}
}
```
MoiveクラスはDiscountPolicyだけ依存してPeriodDiscountConditionとSequenceDiscountConditionには結合しない。

3. 依存性注入

使用先のクラスのインスタンスを使用元のクラスで生成するではなく、使用先のクラスのインスタンスを生成してこれを  
使用元のクラスに渡して依存性を解決すること   

詳細な内容は[こちら](https://github.com/bittap/study/blob/main/src/main/java/com/my/study/object/chapter08/README.md)にある8章の「2. 明示的な依存性」-「明示的」を参考

4. 依存性逆転

以下のコードは問題がある。

```
class Movie{
	private AmountDiscountPolicy discountPolicy;
}
```

料金を計算をする上位モジュールMovieが割引を計算する下位モジュール(AmountDiscountPolicy)に依存している。  
そのため、上位モジュールが下位モジュールの修正に影響される。  
上位モジュールは下位モジュールの修正で影響されないべき。 
 
以下のコードのように上位モジュール(Movie)と下位モジュール(AmountDiscountPolicy)とも抽象化クラス(DiscountPolicy)に依存すべき。  

```
class Movie{
	private DiscountPolicy discountPolicy;
}
```

逆転という言葉を使った理由は従来のプログラミングは上位モジュールが下位モジュールに依存していたため。  

## 柔軟性に対し、アドバイス

1. 柔軟な設計は柔軟性が必要な時だけ使う。

柔軟な設計(抽象化)をすると複雑度が増える反面、柔軟ではない設計(従来)は単純で分かりやすい。  
人間は静的(柔軟ではない設計)のほうが理解しやすい。  
そのため、柔軟な設計は必要な時だけ使う。  
全部柔軟な設計をすると逆に複雑度を増やして保守性が落ちる。

2. まずは役割、責任、協力

クラスの生成をどうするか等細かいことを決めることは後でする。  
一番肝心なことはクラスの役割、責任、協力を考慮して設計すること。  
役割、責任、協力を考慮せず、上記の細かいことに集中すると逆に柔軟性が落ちてしまう。  

## 感想

この章(原則)で設計の用語を学んでよかったです。
特に用語の中で「依存性注入」はよく耳にした言葉だったため、嬉しかったです。  
また、「柔軟性に対し、アドバイス」が強く印象に残りました。  
オブジェクト指向だと全部抽象化して柔軟にすべきかなと思ったのですが、それは大きく間違っていました。

