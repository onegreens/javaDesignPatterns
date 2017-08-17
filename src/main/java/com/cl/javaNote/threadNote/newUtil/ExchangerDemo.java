package com.cl.javaNote.threadNote.newUtil;


/**
 * Created by cl on 2017/8/11.
 *
 * Exchanger : 是在两个任务之间的栅栏。当这些任务进入栅栏时，它们各自拥有一个对面，当离开栅栏时，它们都拥有之前由对象持有的对象
 *
 * 应用场景：一个任务在创建对象，这些对象的生产代价很高，而另一个任务正在消费这些对象。通过这种方式，让更多的对象在创建的同时被消费
 *
 */
public class ExchangerDemo {
}
