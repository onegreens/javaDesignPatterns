## 目录

### DirList

通过使用Arrays.sort()以及String.CASE_INSENSITIVE_ORDER

对结果进行排序

###DirList2

改写DirList

通过匿名内部类的方式

###DirList3

改进DirList2

定义一个作为list()参数的匿名内部类

###Directory

目录实用工具

作用：

通过local()方法产生本地目录中的文件构成的File对象数组，

或者通过使用walk()方法产生给定目录下的整个目录树中的所有文件构成的list<File>

### DirectoryDemo

将Directory作为工具使用

### BufferedInputFile
缓冲输入文件

读取文件内容

关键词：BufferedReader

### MemoryInput
从内存中输出
 
 * 从BufferedInputFile.read()读入的String结果被用来创建一个StringReader.
 * 然后调用read()每次读取一个字符
 
 关键词：StringReader
 
 ###FormattedMemoryInput
 
 格式化内存输出

  * 输出字节
  
 关键词：ByteArrayInputStream、DataInputStream
 
 ### BasicFileOutput
 
 基本的文件输出

 关键词： PrintWriter
 
 ### StoringAndRecoveringData
 
 存储和恢复数据
  * 
  * DataOutputStream 输出
  * DataInputStream 输入
  
 ### Echo
从标准输入中读取
  * 
  * 将System.in 包装成 BufferedReader 
  * 前提是 使用InputStreamReader将System.in 转换成 Reader
  
### ChangeSystemOut
将System.out 转换成 PrintWriter

### SerializableFile
对象序列化的常用方法

在序列化中，将对象序列化称为文件，反序列化时，需要有对应的对象类，否则会出现ClassNotFoundException

### Blips
验证Externalizable在对象构造器上的影响

### Blip3
示范如何完整的保存和恢复一个Externalizable对象

### Logon
在Serializable中使用transient 实现类似Externializable的效果

### SerialCtl 
另一中方法实现Externalizable
 * 通过添加writeObject()和readObject()方法