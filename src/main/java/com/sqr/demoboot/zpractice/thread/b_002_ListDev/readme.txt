同步类容器

1、Vector       HashTable:所有方法使用synchronized修饰
2、ArrayList    HashSet:线程不安全
3、HashSet VS HashTable  / StringBuilder VS StringBuffer
4、Collections.synchronizedXxx() 底层也是使用synchronized实现，相比于 1 锁粒度细化

使用早期的同步容器以及Collections.synchronized***方法的不足之处，请阅读：
http://blog.csdn.net/itm_hadf/article/details/7506529

使用新的并发容器
http://xuganggogo.iteye.com/blog/321630