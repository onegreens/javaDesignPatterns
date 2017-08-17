## 免锁容器
对容器的修改可以与读取操作同时发生，只要读取这只能看到完成修改的结果即可

常见的：CopyOnWriteArrayList/CopyOnWriteArraySet/ConcurrentHashMap/ConcurrentLinkedQueue

在ssm框架中应用多线程可以使用内部类的方式

```java
@Service("systemService")
@Transactional
public class SystemServiceImpl implements SystemService {

   

    @Resource
    private UserAddressDao userAddressDao;

    @Override
    public void testThread1() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Thread(new Thread1()));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdown();
    }

    private  int count = 5920;
    public class Thread1 implements Runnable{
        @Override
        public void run() {
            while (!Thread.interrupted()){
                String phone = userAddressDao.queryUserPhoneById(count);
                if (!"".equals(phone)){
                    System.out.println("userId = " + count + " [ phone = " + phone + "]");
                }else{
                    System.out.println("userId = " + count + " [ phone = 无]");
                }
                count++;
            }

        }
    }

}

```

其他方式：
将需要的Bean作为线程的的构造函数的参数传入
使用ApplicationContext.getBean方法来静态的获取Bean