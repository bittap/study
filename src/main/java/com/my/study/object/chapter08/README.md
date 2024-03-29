### 依存性を管理する

## 変更と依存性

クラスとクラスが協力すると依存性が発生する。    
依存性があるクラスを変更するとそれを参照するクラスにも影響が及ぼす。    
そのため、効率的に依存性を管理して変更が発生する時、影響範囲を少なくするのがとても重要。

## 依存性を効果的に管理する方法

1. 抽象化に依存する

抽象化とは多くの物や事柄や具体的な概念から、それらの範囲の**全部に共通な属性を抜き出し、これを一般的な概念としてとらえること**。    
抽象化をすると依存元のクラスが依存先のクラスに対して必要な知識の量が減る。   
そのため、依存性が低くなって変更しやすくなる。      
仮に割引をする依存先のクラスが存在して割引はパーセント割引、金額割引があるとする。  
その場合、依存元のクラスは具体化に"パーセント割引、金額割引して"と依存先のクラスにメッセージを送るのではなく、"割引して"とメッセージを送ったほうがより抽象的で依存性が低くなる。

実装のイメージとしては以下になる。    
【映画割引プログラム】    
依存元：Movie  
依存先：DiscountPolicy(割引)［親クラス］、PercentDiscountPolicy(パーセント割引)［子クラス］、AmountDiscountPolicy(金額割引)［子クラス］

2. 明示的な依存性

依存先の対象は暗黙的ではなく、明示的にすること。   
+ 明示的  
コンストラクタ、Setterメソッド、メソッドのパラメータに依存先の対象を参照すること。

```
     class Movie{
    	public Movie(... DiscountPolicy discountPolicy){
    	    this.discountPolicy = discountPolicy;
    	}
    }
```

+ 暗黙的  
コンストラクタ、Setterメソッド、メソッドの内部から依存先の対象を参照すること。

```
    class Movie{
    	public Movie(...){
    	    this.discountPolicy = new PercentDiscountPolicy();
    	}
    }
```

暗黙的な参照の場合は、依存元のクラスの内部から依存先のクラスを参照するため、依存先の変更が発生する時、依存元のクラスの内部の修正が必要。  
明示的な参照の場合は、依存元のクラスは内部から依存先のクラスを参照しないため、依存先の変更が発生する時、対象のクラスのみ変えればよく修正が不要。


3. NEWは悪い

多くのプログラミング言語ではインスタンスを生成する時、NEWを使う。   
しかし、NEWは「相手の抽象クラス/インターフェースに対し、どの実装クラスがあるか知識が必要な上その実装クラスのインスタンスにも依存することになる。」ため、悪い。
NEWではなく、ファクトリーデザインパターン(※1)を使ったほうがいい

※1 詳細な内容は[こちら](https://qiita.com/shoheiyokoyama/items/d752834a6a2e208b90ca#factory%E3%83%91%E3%82%BF%E3%83%BC%E3%83%B3)を参考

4. ケースによっては生成してもいい

上記の「2.」で暗黙的に生成することは悪いと言いました。  
しかし、運用上ほとんどのケースが特定の実装クラスを参照する場合は、上記の「2.」のコードだと他のクラスでDiscountPolicyインスタンスを生成することになるため、コード重複が発生しやすい。
その時には、暗黙的にコンストラクタ、Setterメソッド、メソッドの内部から依存先の対象を生成してもよい。

5. コンテキスト拡張する

もし、割引を行わない等例外ケースがあるとする。  
クラスの中身にその例外を実装するのではなく、コンテキストを拡張して対応する。    
そうすると、コード修正せずに例外ケースの実装ができる。  

+ 悪い例(例外ケースを作る)
```
    class Movie{
      DiscountPolicy discountPolicy;
      
      
      public Movie(){
        discountPolicy = null;
      }
      
      public Movie(DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
      }
      
      public int calculate(){
        if (discountPolicy == null){
          return 0;
        } else {
           return discountPolicy.calculate();
        }
      }
    }
```
    
+ よい例(コンテキストを拡張する)

```
    class Movie{
      DiscountPolicy discountPolicy;
      
      public Movie(DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
      }
      
      public int calculate(){
        return discountPolicy.calculate();
      }
    }
    
    new Moview(new NoneDiscountPolicy(...))
```
