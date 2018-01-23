# 多线程

## 线程的状态
- 新建：线程被创建时所处的状态
- 就绪：只要调度器把时间片分配给线程，线程就可以运行
- 阻塞：线程可以运行，但是某个条件阻止线程运行
- 死亡：不可调度，线程还可以被中断

进入阻塞状态：
- 调用sleep(),在预定时间内不会运行
- 调用wait(),知道线程得到了notify()/notifyAll()
- 任务在等待某个输出、输入完成
- 任务在等待锁释放

中断：
- 使用Thread对象的interrupted()方法
- Executor.shoudown()

## volatile
 - 保证可视性
   如果将一个域声明为volatile的，只要对这个域产生了写操作，那么所有的读操作都可以看到这个修改。
   即便使用了本地缓存，情况也如此，volatile域会立即被写入主存中，而读操作就发生在主存中
 - 保证原子性
