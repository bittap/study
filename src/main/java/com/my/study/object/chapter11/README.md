# コンポジション(Composition)と柔軟な設計

## 継承とコンポジション

設計の観点では継承よりコンポジションを使うべき。  
継承は子クラスが親クラスに強く依存する(is-a)関係の反面、コンポジションはクラスとクラスの間に依存する(has-a)関係になり、保守性が高いです。

## 継承による副作用

継承は色んな問題を抱えている。  
仮に、[10章](https://github.com/bittap/study/tree/main/src/main/java/com/my/study/object/chapter10)の通話料金計算プログラムで以下の要件が追加されたとする。

> 料金プラン計算後パーセントに割引をするサービス

今の料金プランは二つ[通常料金プラン]と[深夜割引料金プラン]がある。  
![10章クラス図](10章クラス図.PNG)

上記の要件が追加された時のクラス図
![継承による副作用クラス図](継承による副作用クラス図.PNG)

以下の問題点が存在する。
+ 一つの機能を追加・修正するために多くのクラスを追加・修正することになる。  

上記のクラス図の赤枠を見ると一つの機能追加のために二つのクラスが追加されました。  
もし、料金プランが二つ[通常料金プラン]と[深夜割引料金プラン]ではなく、三つまたは四つの場合はその分クラスが増えてしまう。

+ 重複コードが発生する

上記のクラス図の青枠を見るとoverrideしたメソッドが存在する。  
そのメソッドの中の処理は「固定に割引をする」だけで他のクラスでも同様ですが、overrideのために重複コードが発生する。

## 継承をコンポジション(Composition)に変更

上記の問題を解くコンポジション(Composition)に通話料金計算プログラムを変更する。  

まず、継承のクラス図
![継承による副作用クラス図(枠なし)](継承による副作用クラス図(枠なし).PNG)

継承をコンポジションに変更したクラス図。  
![コンポジションクラス図](コンポジションクラス図.PNG)

料金プラン計算後の割引をするサービスが他のクラス、RatePolicyとRateDiscountablePolicy(パーセントに割引)に変更されました。


コンポジションクラスのコード

[料金プラン(抽象化クラス)]

```

public abstract AbstractPhone {
	private List<Call> calls = new ArrayList<>();
	private double taxRate;

	public Money calculateFee() {
		Money result = Money.ZERO;
		
		for(Call call : calls){
			result = result.plus(calculateCallFee(call));
		}
		
		return result.plus(result.times(taxRate));
	}
	
	public abstract Money calculateCallFee(Call call);
}
```

[基本料金プラン(子クラス)]

```

public class Phone extend AbstractPhone {
	private Money amount;
	private Duration seconds;
	
	...
	
	@Overrride
	public Money calculateCallFee(Call call) {
		return amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
	}
}

```

[深夜割引料金プラン(子クラス)]

```

public class NightlyDiscountPhone extend AbstractPhone {
	private static final int LATE_NIGHT_HOUR = 23;
	private Money amount;
	private Money NigthlyAmount;
	

	@Overrride
	public Money calculateCallFee(Call call) {
		if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
			result = result.plus(super.getAmount().minus(NigthlyAmount).times(call.getDuration().getSeconds() / seconds.getSeconds())));
		} else {
			return amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
		}
		
	}
}

```

[割引ポリシー]

```

public abstract RatePolicy extend AbstractPhone {
	private AbstractPhone phone;
	
	public RatePolicy(AbstractPhone phone){
		this.phone = phone;
	}
	
	@Overrride
	public Money calculateFee(){
		Money money = super.calculateFee();
		return money.plus(this.afterCalculateFee(call));
	}
	
	public abstract Money afterCalculateFee(Money money);
}
```

[パーセント割引ポリシー]

```

public RateDiscountablePhone RatePolicy extend RatePolicy {
	private AbstractPhone phone;
	private Percent percent;
	
	public RatePolicy(AbstractPhone phone, Percent percent){
		this.phone = phone;
		this.percent = percent;
	}
	
	@Overrride
	public Money afterCalculateFee(Money money){
		return money.times(percent);
	}
}
```

TODO 

1. 上記コンポジションクラス見直し
2. RatePolicy#calculateFeeこれだとプラスしかできない、税金の場合どうやってマイナスするんだ？






## 変更後の比較

クラスを追加してみる。

「継承による副作用」の問題点二つがなくなるのが分かる。





## 感想

実は本の中では「継承による副作用」の内容はもっとクラスと割引ポリシーがあって長くて複雑だったのです。  
しかし、 それを全部書くと長くなりますし、読みづらくなるかと思って私が必要なところだけ考えて少し変更を加えて書きました。  
それによりもっと理解しやくなったら、嬉しいです。  