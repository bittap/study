## オブジェクトプログラミング

# 映画予約アプリケーション

1. 概要

2. domain図

![domain](/src/main/java/com/my/study/object/chapter02/domain図.PNG)

3. UML図


# 上記の設計のメリット

- メリット
  1. 拡張しやすい。割引ポリシー(DiscountPolicy)に新しいポリシーが追加されたとしたら、Movieクラスはその割引ポリシー(DiscountPolicy)のことを知らなくてもコード追加可能。
  2. 保守性が高い。Movieクラスは割引ポリシー(DiscountPolicy)がどのように実装されたか確認せずにただDiscountPolicy#calculateメソッドを呼び出すだけで済むので保守性が高い。
- デメリット
  1. プログラムが複雑になる。Movieクラスの属性のDiscountPolicyが「AmountPolicy」か「PercentPolicy」か探すためにはMovieクラスを生成するところとまで辿り着かないと分からない。

