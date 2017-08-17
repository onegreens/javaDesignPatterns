package com.cl.javaNote.threadNote.simulation;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/11.
 * <p>
 * 银行出纳员仿真
 * <p>
 * 情景：对象随机出现，并且要求由数量有限的服务器提供数据集的访问时间
 * <p>
 * 在本例中，每个银行顾客要求一定数量的服务时间，这是出纳员必须花费在顾客身上，以服务顾客需求的时间单位的数量。
 */
public class BankTellerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
        executorService.execute(new CustomerGenertor(customers));
        executorService.execute(new TellerManager(executorService,customers,ADJUSTMENT_PERIOD));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

/**
 * 一个顾客 拥有固定的服务时间
 */
class Customer {
    private final int servicerTime;

    public Customer(int servicerTime) {
        this.servicerTime = servicerTime;
    }

    public int getServicerTime() {
        return servicerTime;
    }

    @Override
    public String toString() {
        return "{" + servicerTime +
                '}';
    }
}

/**
 * 顾客队列
 */
class CustomerLine extends ArrayBlockingQueue<Customer> {

    public CustomerLine(int maxLineSize) {
        super(maxLineSize);
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "[ empty ]";
        }
        StringBuffer result = new StringBuffer();
        for (Customer customer : this) {
            result.append(customer);
        }
        return "CustomerLine{} = " + result;
    }
}

/**
 * 完成添加顾客
 */
class CustomerGenertor implements Runnable {
    private CustomerLine customers;
    private Random r = new Random(47);

    public CustomerGenertor(CustomerLine customers) {
        this.customers = customers;
    }

    public void run() {

        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(r.nextInt(300));
                customers.put(new Customer(r.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            System.out.println("CustomerGenertor interrupting ");
        }
        System.out.println("CustomerGenertor finish terminating");
    }
}

/**
 * 出纳员
 */
class Teller implements Runnable, Comparable<Teller> {
    private static int count = 0;
    private final int id = count++;

    private CustomerLine customers;
    private int customerServed = 0;
    private boolean servingCustomerLine = true;

    public Teller(CustomerLine customers) {
        this.customers = customers;
    }

    //应该是用于排序，避免单个出纳员招待过多顾客
    public synchronized int compareTo(Teller o) {
        return customerServed < o.customerServed ? -1 : (customerServed == o.customerServed ? 0 : 1);
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                //为顾客提供服务 没有顾客时自动阻塞
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServicerTime());
                synchronized (this) {
                    customerServed++;
                    while (!servingCustomerLine)
                        wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupting ");
        }
        System.out.println(this + " terminating ");
    }

    public synchronized void doSomethingsElse() {
        customerServed = 0;
        servingCustomerLine = false;
    }

    public synchronized void serveCustomerLine() {
        assert !servingCustomerLine : "already serving : " + this;
        servingCustomerLine = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Teller{" +
                "id=" + id +
                '}';
    }

    public String shortString() {
        return "T :" + id;
    }
}

/**
 * 综合管理
 */
class TellerManager implements Runnable {
    private ExecutorService executorService;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<Teller>();//正在工作的
    private Queue<Teller> tellersDoOtherThings = new LinkedList<Teller>();//未工作的
    private int adjustmentPeriod;//调整时间
    private static Random random = new Random(47);

    public TellerManager(ExecutorService executorService, CustomerLine customers, int adjustmentPeriod) {
        this.executorService = executorService;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;
        Teller teller = new Teller(customers);
        executorService.execute(teller);
        workingTellers.add(teller);
    }

    public void adjustTellerNumber() {
        if (customers.size() / workingTellers.size() > 2) {//如果顾客的数量远远超过服务人员
            if (tellersDoOtherThings.size() > 0) {//如果有空闲人员
                Teller t = tellersDoOtherThings.remove();
                t.serveCustomerLine();
                workingTellers.offer(t);//把他叫去工作
                return;
            }
            Teller teller = new Teller(customers);//添加服务人员
            executorService.execute(teller);
            workingTellers.add(teller);
            return;
        }
        if (workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2)
            reassignOneTeller();
        if (customers.size() == 0)
            while (workingTellers.size()>1)
                reassignOneTeller();
    }

    //修正未工作的和工作的人数
    public void reassignOneTeller() {
        Teller teller = workingTellers.poll();
        teller.doSomethingsElse();
        tellersDoOtherThings.offer(teller);
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                //时刻调整
               TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
               adjustTellerNumber();
                System.out.println(customers + " { ");
                for (Teller teller: workingTellers){
                    System.out.println(teller.shortString() + " ");
                }
                System.out.println(" } ");
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupting ");
        }
        System.out.println(this + " terminating ");
    }

    @Override
    public String toString() {
        return "TellerManager{}";
    }
}