# 継承とコード再使用

## 重複コード

重複コードは修正の努力を何倍に増加する。  
重複コードに対し、修正が発生した場合

1. 重複コードを探す
2. 重複コードを同じく修正する
3. 重複コードをテストする  

重複コードがない場合に比べて何倍の努力が必要で重複コードを見つけなかった場合、修正漏れでバグの原因になる。

上記の例を見るために携帯のプランに対し、通話料金計算をするプログラムで重複コードを見る。  
プランには通常料金と深夜割引料金プランがあるとする。  
料金の計算はプランの料金によって計算される。  
その後、税金が加算される。

[通話履歴]

```

public class Call{
	private LocalDatetime from;
	private LocalDatetime to;
	
	public Call(LocalDatetime from, LocalDatetime to){
		this.from = from;
		this.to = to;
	}
	
	public Duration getDuration(){
		return Duration.between(from, to);
	}
}
```

[通常料金プラン]

```

public class Phone {
	private Money amount;
	private Duration seconds;
	private List<Call> calls = new ArrayList<>();
	private double taxRate;
	
	...
	
	public Money calculateFee() {
		Money result = Money.ZERO;
		
		for(Call call : calls){
			result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds())));
		}
		
		return result.plus(result.times(taxRate));
	}
}

```

[深夜割引料金プラン]

```

public class NightlyDiscountPhone {
	private static final int LATE_NIGHT_HOUR = 23;
	private Money amount;
	private Money NigthlyAmount;

	...
	
	public Money calculateFee() {
		Money result = Money.ZERO;
		
		for(Call call : calls){
			if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
				result = result.plus(NigthlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds())));
			} else {
				result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds())));
			}
		}
		
		return result.plus(result.times(taxRate));
	}
}

```

上記のコードは通常料金計算と税金計算ロジックで重複が発生している。

[通常料金計算重複]

```
result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds())));

```

[税金計算重複]

```
result.times(taxRate)

```


## 継承

上記の「携帯プランの料金計算プログラム」を継承を使って変える。

[通常料金プラン(親クラス)]

```

public class Phone {
	private Money amount;
	private Duration seconds;
	private List<Call> calls = new ArrayList<>();
	private double taxRate;
	
	...
	
	public Money calculateFee() {
		Money result = Money.ZERO;
		
		for(Call call : calls){
			result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds())));
		}
		
		return result.plus(result.times(taxRate));
	}
	
	public Money getAmount{
		return this.amount;
	}
	
	public double getTaxRate{
		return this.taxRate;
	}
}

```

[深夜割引料金プラン(子クラス)]

```

public class NightlyDiscountPhone extend Phone {
	private static final int LATE_NIGHT_HOUR = 23;
	private Money amount;
	private Money NigthlyAmount;

	...
	
	public Money calculateFee() {
		Money result = super.calculateFee();
		
		Money nigthlyResult = Money.ZERO;
		
		for(Call call : calls){
			if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
				result = result.plus(super.getAmount().minus(NigthlyAmount).times(call.getDuration().getSeconds() / seconds.getSeconds())));
			}
		}
		
		return result.minus(nigthlyResult.times(getTaxRate));
	}
}

```

継承により、[深夜割引料金プラン]クラスから通常料金プラン計算(Phone#calculateFee)という重複コードはなくなったのですが、[深夜割引料金プラン]クラスの料金計算(#calculateFee)は強く通常料金プラン計算(Phone#calculateFee)のロジックに依存している。  

```
public Money calculateFee() {
		Money result = super.calculateFee();
		...
```

## 継承の問題

1. 子クラスのメソッド中でsuperで親クラスのメソッドを参照する場合、強く依存してしまう。

2. 間違って継承すると親クラスのメソッドにより、子クラスの仕様が変わってしまう。  
例えば、マップの機能を使うために親クラスMapを継承してStringMapを作ったとする。  
StringMapはマップのキー:String,値:String型である。  
マップに要素を追加する時、親クラスのメソッド(Map#put)を使うが親クラスのMapはキーと値にString以外の型も入れられるため、子クラスの仕様(String型だけ扱う)に違反することになる。


## 継承の問題改善

継承を使った通話料金計算プログラムを例で説明する

1. 抽象化に依存する

NightlyDiscountPhoneの問題はPhoneに強く依存していてPhoneが変更されるとNightlyDiscountPhoneも変更される可能性がある。  
解決方法は親実装クラスに依存するのではなく、親抽象クラスに依存するようにする

2. 違いをメソッドに抽出する
   
　　① 変更されるところと変更されないところを分離する。  
　　　　・ 変更されるところ(通話(Call)に対し、料金計算)

[通常料金プラン(親クラス)]

```
result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds
```

[深夜割引料金プラン(子クラス)]

```
result = result.plus(super.getAmount().minus(NigthlyAmount).times(call.getDuration().getSeconds() / seconds.getSeconds())));
```

　　　　・ 変更されないところ(全通話の料金計算)
	 
```
public Money calculateFee() {
	Money result = Money.ZERO;
		
	for(Call call : calls){
		result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds())));
	}
			
	return result.plus(result.times(taxRate));
}
```

　　② メソッドに抽出する。


```

public class Phone {
	private Money amount;
	private Duration seconds;
	private List<Call> calls = new ArrayList<>();
	private double taxRate;
	
	...
	
	public Money calculateFee() {
		Money result = Money.ZERO;
		
		for(Call call : calls){
			result = result.plus(calculateFee(call));
		}
		
		return result.plus(result.times(taxRate));
	}
	
	public Money calculateFee(Call call) {
		return amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
	}
	
	public Money getAmount{
		return this.amount;
	}
	
	public double getTaxRate{
		return this.taxRate;
	}
}

```

[深夜割引料金プラン(子クラス)]

```

public class NightlyDiscountPhone {
	private static final int LATE_NIGHT_HOUR = 23;
	private Money amount;
	private Money NigthlyAmount;

	...
	
	public Money calculateFee() {
		Money result = Money.ZERO;
		
		for(Call call : calls){
			result = result.plus(calculateFee(call));
		}
		
		return result.plus(result.times(taxRate));
	}
	
	public Money calculateFee(Call call) {
		if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
			result = result.plus(super.getAmount().minus(NigthlyAmount).times(call.getDuration().getSeconds() / seconds.getSeconds())));
		} else {
			return amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
		}
		
	}
}

```

3. 重複コードを抽象化クラスに移動する

抽象化クラスを作って上記2.で抽象したメソッドとインスタンスをを移動する

[料金プラン(抽象化クラス)]

```

public abstract AbstractPhone {
	private List<Call> calls = new ArrayList<>();
	private double taxRate;

	public Money calculateFee() {
		Money result = Money.ZERO;
		
		for(Call call : calls){
			result = result.plus(calculateFee(call));
		}
		
		return result.plus(result.times(taxRate));
	}
	
	public abstract Money calculateFee(Call call);
 
}
```

[基本料金プラン(子クラス)]

```

public class Phone extend AbstractPhone {
	private Money amount;
	private Duration seconds;
	
	...
	
	@Overrride
	public Money calculateFee(Call call) {
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
	public Money calculateFee(Call call) {
		if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
			result = result.plus(super.getAmount().minus(NigthlyAmount).times(call.getDuration().getSeconds() / seconds.getSeconds())));
		} else {
			return amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
		}
		
	}
}

```

これにより一つのクラスが一つの責任を持つようになりました。
+ 全体料金計算：抽象クラス(AbstractPhone)
+ 基本料金計算：子クラス(Phone)
+ 深夜料金計算：子クラス(NightlyDiscountPhone)

## 継承のメリットとデメリット

+ メリット
1. 重複コードを削除できる
2. コードを拡張できる
3. コード再使用できる

+ デメリット
1. 親クラスに強く依存するため誤って継承を使った場合、逆に保守性が低く修正が難しい


## 感想

この章で最後に著者は継承の無理やりな使用はやめるべきだと述べている。  
継承は簡単に重複コード削除・コード再使用ができる反面、子クラスが親クラスに強く依存するため、間違って継承すると
逆に保守性を上げるために継承したのですが、保守性が下がってしまう。    
私も最初継承を学んだ時は継承=オブジェクト指向と考えたのですが、大間違いでした。   
継承を使うときには副作用を考えた上で使うべきだと思うようになりました。
