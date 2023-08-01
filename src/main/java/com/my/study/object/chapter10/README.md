# 継承とコード再使用

## 重複コード

重複コードは修正の努力を何倍に増加する。  
重複コードに対し、修正が発生した場合

1. 重複コードを探す
2. 重複コードを同じく修正する
3. 重複コードをテストする  

重複コードがない場合に比べて何倍の努力が必要で重複コードを見つけなかった場合、修正漏れでバグの原因になる。

### 携帯のプランに対し、通話料金計算プログラム

通話料金計算プログラムで重複コードを見る。  
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



## 継承の問題

## 継承の問題改善

## 感想













## 継承と重複コード

### DRY原則

### 重複と変更

### 継承を使って重複コードを削除する	

## 弱い上部クラス問題

### 不要なインターフェース継承問題

### メソッドオーバーライドの副作用

### 親クラスと子クラスの同時修正問題

## Phoneをもう一回見る

### 抽象化に依存する

### 違いをメソッドに抽出する

### 重複コードを親クラスに移動する

### 抽象化が肝心だ

### 意図を示す

## 違いによるプログラミング

## 感想