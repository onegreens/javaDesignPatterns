制作远程服务的步骤：
1. 制作远程接口
 - 扩展java.rmi.Remote
 - 声明所有的方法都会抛出RemoterException
 - 确定返回值和变量是属于primitive类型或者Serializable类型
2. 制作远程的实现
 - 实现远程接口
 - 扩展UnicastRemoteObject
 - 设计一个不带变量的构造器，并声明RemoteException
 - 使用RMI Registry注册此服务
3. 利用rmic产生的stub和skeleton
4. 启动 RMI registry
5. 开始远程服务
 
 
 
代理模式：为另一个对象提供一个替身或者占位符以控制对这个对象的访问

    使用代理模式创建代表（representative）对象,让代表对象控制对象的访问，被代理的对象可以是远程的对象、开销大的对象、需要安全控制的对象