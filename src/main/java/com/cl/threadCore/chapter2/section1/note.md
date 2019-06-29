# 对象及变量的并发访问 - synchronized同步方法

## 目录
1. HasSelfPrivateNum

    - 方法私有变量不会出现非线程安全

2. HasPrivateNum

    - 类私有变量会出现非线程安全

3. HasSynchronizedPrivateNum

    - 通过synchronized同步方法

4. TwoObjectTwoLock

    - synchronized是针对对象的 多个对象访问同一个对象才会生效

5. SynchronizedMethodLockObject

    - 访问同一个对象的同步或非同步方法
    
6. SynchronizedTwoMethodLockObject

    - 两个对象访问一个对象的不同方法 
    
7. PublicVar

    - 线程A占有对象的锁方法时,其他线程可以执行该对象的非锁方法
    
8. SynLockIn

    - 可重入锁
    
9. SynLockInExtends

    - 可重入锁在继承中的应用
    
10. ThrowExceptionNoLock

    - 线程出现异常会释放锁
    
11. SynNoExtends

     - 同步不可继承
