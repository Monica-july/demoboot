创建一个map容器
启动100个线程
写入 1000000 长度的数据
读出 1000000 的数据

三者执行结果比较：
HashTable
write时间：749   read时间：17671

ConcurrentHashMap
write时间：500   read时间：3172

SynchronizedHashMap
write时间：625   read时间：18545

结论：ConcurrentHashMap读数据时效率更高
     SynchronizedHashMap写数据效率更高