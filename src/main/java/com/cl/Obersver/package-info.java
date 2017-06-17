/**
 * Created by cl on 2017/6/17.
 * 实现气象站的实况更新
 *
 * subject和observer是一对多的关系，当subject发生数据变动时，将数据反馈给所有的observer
 * observe通过subject中的注册和移除方法建立关系
 *
 * 带有java声明的类是通过java内置的观察者模式实现相关代码
 */
package com.cl.Obersver;