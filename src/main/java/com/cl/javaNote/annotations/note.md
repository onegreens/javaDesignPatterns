注解
为我们在代码中添加信息提供了一种形式化的方法，使我们可以在稍后某个时刻非常方便地只用这些数据


格式：@annotation

常见注解

- @Override：表示当前的方法定义将覆盖超类中的方法
- @Deprecated：如果程序员使用了注解为它的元素，那么编译器会发出警告信息
- @SuppressWarnnings：关闭不当的编译器警告信息



元注解

- @Target
  表示该注解用于什么地方。
  可选参数：
  1. CONSTRUCTOR
     构造器的声明
  2. FIELD
     域的声明（包括enum实例）
  3. LOCAL_VARIABLE
     局部变量的声明
  4. METHOD
     方法声明
  5. PACKAGE
     包声明
  6. PARAMETER
     参数声明
  7. TYPE
     类、接口（包括注解类型）或enum声明
- @Retention
  表示在什么级别需要保存该注解信息。
  可选参数：
  1. SOURCE
     注解将被编译器丢弃
  2. CLASS
     注解在class文件中可用，但是会被VM丢弃
  3. RUNTIME
     VM将在运行期也保留注解，因此可以通过反射机制读取注解信息
- @Documented
  将此注解包含在Javadoc中
- @Inherited
  允许子类继承父类中的注解



注解元素

类型：

- 所有基本类型
- String
- Class
- enum
- Annotation
- 以上类型的数组



默认值限制

- 元素不能有不确定的值
- 对于非基本类型元素，无论是在源代码中声明时，或是在注解接口中定义默认值，都不能以null作为其值
























