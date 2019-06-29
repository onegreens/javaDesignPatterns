# 对象及变量的并发访问 - synchronized同步语句块
1. SynDefect

    Synchronized弊端
    
2. SynOneThreadIn

    使用同步代码块
    
3. SynCodeBlockSolveDefect

    用同步代码块解决Synchronized弊端
   
4. AsyncAndSync

    不在同步块里面的就是一部执行,在同步代码块里面的就是同步执行
    
5. DoubleSynBlockOneTwo 
    
    当一个线程访问Object的一个synchronized(this)同步代码块时,其他线程对Object的其他同步代码块的访问将被阻塞
    
    
    
多个线程调用同一个对象中的不同名称的synchronized方法或synchronized(this)同步代码块时,调用的效果就是按顺序执行,也就是同步/阻塞

- synchronized方法
    
    - 对其他synchronized同步方法或synchronized(this)同步代码块调用时呈阻塞状态
    
    - 同时间只有一个线程能执行synchronized同步方法
    
- synchronized(this)方法
    
    - 对其他synchronized同步方法或synchronized(this)同步代码块调用时呈阻塞状态
    
    - 同时间只有一个线程能执行synchronized(this)同步代码块方法
        