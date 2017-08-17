package com.cl.javaNote.threadNote.newUtil;

/**
 * Created by cl on 2017/8/11.
 *
 * DelayQueue ：是一个无界的BlockingQueue，用于放置了实现了Delayed接口的对象，其中的对象只有在其到期时才能从队列中取出
 *
 * 这种队列是有序的，即对头对象的延迟到期的时间最长，如果没有任何延迟到期，那么就不会有任何头元素，并且poll()会返回null
 *
 */
public class DelayQueueDemo {
}
