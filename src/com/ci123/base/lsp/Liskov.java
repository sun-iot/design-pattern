package com.ci123.base.lsp;

/**
 * Copyright (c) 2018-2028 Corp-ci All Rights Reserved
 * <p>
 * Project: design-pattern
 * Package: com.ci123.base.liskov
 * Version: 1.0
 * <p> 这里可以看到，我们的B重写了A的func1(int num1,int num2)方法，无意中将减法改成了加法，但是我们的整个继承体系
 * 是已经被破坏了的，会导致继承体系的复用性会比较差，特别是运行多态比较繁琐的时候
 * <p>
 * 改进：
 * 通用的做法是：原来的父类和子类都继承一个更通俗的基类，原有的继承关系去掉，采用依赖，聚合，组合等关系替代。
 * 即：
 * base <- A
 * base <- B
 * B <<- A
 * <p>
 * Created by SunYang on 2019/11/7 10:55
 */
public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("5-3=" + a.func1(5, 3));
        B b = new B();
        System.out.println("5-3=" + b.func1(5, 3)); // 这里原本是要输出 5-3 的
        System.out.println("/************************************************/");
        AA aa = new AA();
        System.out.println("5-3=" + aa.func1(5, 3));
        BB bb = new BB();
        System.out.println("5-3=" + bb.func(5, 3)); // 这里原本是要输出 5-3 的
    }
}

class Base {
    // 这里放很基础的方法和成员
}

/********************************************************************************************/
class A {
    // 返回两个数的差
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

// B 继承A
// 增加一个新的功能，完成两个数相加
class B extends A {
    // 这里重写 A类方法
    @Override
    public int func1(int num1, int num2) {
        // 这里是无意识的重写，是我们不需要的重写，我们本意是要求 减法的
        return num1 + num2;
    }

    public int func2(int num1, int num2) {
        return func1(num1, num2) * 8;
    }
}

/********************************************************************************************/
class AA {

    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}
class BB extends Base {
    // 这里重写 A类方法
    public int func1(int num1, int num2) {
        // 这里是无意识的重写，是我们不需要的重写，我们本意是要求 减法的
        return num1 + num2;
    }

    public int func2(int num1, int num2) {
        return func1(num1, num2) * 8;
    }

    private AA aa = new AA();
    // 这里想要用AA方法
    public int func(int num1 , int num2){
        return this.aa.func1(num1 , num2) ;
    }
}