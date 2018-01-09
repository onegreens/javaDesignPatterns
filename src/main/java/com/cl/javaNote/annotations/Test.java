package com.cl.javaNote.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by cl on 2017/12/21.
 * 自定义注解
 * @Target 定义你的注解将应用于声明地方 method方法
 * @Retention 用来定义该注解在哪一个级别使用
 * RUNTIME 运行时 CLASS 类 SOURCE 源代码
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
