## チケット販売アプリケーションの改善前

# 概要

劇場のチケットを販売するアプリケーションがある。

チケットを購入する方法は以下二つがある。

1. イベントに当たって招待状と交換する。

2. お金を出してチケットを買う

# UML図

![UML](/src/main/java/com/my/study/object/chapter01/before/uml.PNG)

# 問題点

1. Thater(劇場)クラスが知っているクラスが多い。そのため、Audience(観客)クラスとBag(バック)クラス、TicketSeller(チケット販売員)クラス、TicketOffice(チケットオフィス)が修正されるとThater(劇場)クラスも修正が必要になる。


