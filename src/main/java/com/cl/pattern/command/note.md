命令模式：将“请求”封装成对象，以便使用不同的请求、队列或日志来参数化其实其他对象。命令模式也支持可撤销的操作

依赖抽象 不依赖具体类

- 命令模式将发出请求的对象和执行请求的对象解耦
- 在被解耦的两者之间是通过命令对象进行沟通的。命令对象封装了接收者和一个或一组对象
- 调用者通过调用命令对象的execute()发出请求，这会使接收者的动作被调用
- 调用者可以接收命令当做参数，甚至在运行时动态的进行
- 命令可以支持撤销，做法是实现一个undo（）方法来货到execute()方法被执行签到状态
- 宏命令是命令的一种简单的延伸，允许调用多个命令。宏方法也可以支持撤销
- 命令也可以用来实现日志和事务系统

实例：
将请求封装成对象，使用时执行对应的对象即可

实例中将请求请求对象组合成数组，无论是多请求还是单一请求都执行便捷