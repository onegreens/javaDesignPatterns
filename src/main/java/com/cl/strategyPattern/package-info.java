/**
 * Created by cl on 2017/6/17.
 * strategyPattern 策略模式
 * 定义了算法族，分别封装起来，让他们之间可以相互转换
 * 此模式让算法独立与使用算法的客户
 *
 * 例子说明：这是一个为不同鸭子声明不同行为的例子
 *
 * 设置超类Duck.class 说明所有属性
 * 设置具体类**Duck.class 说明具体属性
 * 设置接口flyBehavier/quackBehavier并加一具体实现
 * 在**Duck.class的构造方法中设置具体属性
 * 通过调用Duck.class的set方法动态修改属性值
 *s
 */
package com.cl.strategyPattern;
