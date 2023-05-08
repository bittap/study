## チケット販売アプリケーションの改善後

# 概要

[こちらを参考](https://github.com/bittap/study/tree/main/src/main/java/com/my/study/object/chapter01/before#%E6%A6%82%E8%A6%81)

# UML図

1. 改善前

![UML](/src/main/java/com/my/study/object/chapter01/before/uml.PNG)

2. 改善後

![UML](/src/main/java/com/my/study/object/chapter01/after/uml.PNG)

# 問題点

[こちらを参考](https://github.com/bittap/study/tree/main/src/main/java/com/my/study/object/chapter01/before#%E6%A6%82%E8%A6%81)

# 改善されたメリット

1. 変更しやすいコードになりました。Theater(劇場)クラスが依存するクラスがTicketSeller(チケット販売員)しかないため、Bag(バック)クラスやAudience(観覧者)クラスが修正されても影響をされなくなりました。そのため、修正が発生する際に修正する範囲が少なくなりました。

2. 現実世界の動きになり理解しやすくなりました。最初Theater(劇場)クラスがTicketSeller(チケット販売員)クラスのTicketOffice(チケットオフィス)クラスを操作したため、現実的ではなかったのですが、変更後はTicketSeller(チケット販売員)クラスがTicketOffice(チケットオフィス)クラスを操作することになりもっと理解しやすくなりました。


