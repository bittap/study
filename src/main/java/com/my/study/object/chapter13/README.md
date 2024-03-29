# サブクラスとサブタイピング

## 継承の目的

継承は二つの目的により使われる。    

1. サブクラス(コード再利用)

継承は簡単な方法で親クラスのコードを子クラスで再利用できる。   
しかし、コード再利用だけで継承を使うと親クラスと子クラスが強く結合するため変更しにくいコードになる。

2. サブタイピング(タイプの階層)

タイプの階層の中で親クラスは一般的な概念を子クラスは特殊な概念を実装する。   
親クラスは子クラスの一般化で子クラスは親クラスの特殊化である。   
タイプを意識せず子クラスを利用するために使う。


## 継承を使う時の条件

いつ継承を使えばいいのか?

1. 継承関係が is-a 関係であるか?

is-a つまり 子クラスは親クラスだと言っても過言ではない場合

2. クライアントからすると親クラスと子クラスの行動が同じか？

クライアントは親クラスだろうがある子クラスだろうが意識せず使える  
例えば、javaのReaderクラスを継承するBufferedReader,InputStreamReaderは親クラスと子クラスの行動が同じである。


## 感想

今まで継承を使う目的は「1. サブクラス(コード再利用)」が強かった。  
しかし、この章を読んで継承は「1. サブクラス(コード再利用)」だけ考えて使うと保守性が低いコードが生まれる恐れがあることを感じました。   
継承を使う目的が「2. サブタイピング(タイプの階層)」であるか確認するようにしたいと思います。



