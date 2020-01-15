package com.ci123.advance.single;

/**
 * Copyright (c) 2018-2028 Corp-ci All Rights Reserved
 * <p>
 * Project: design-pattern
 * Package: com.ci123.advance.sl
 * Version: 1.0
 * <p> 单例模式
 * Created by SunYang on 2019/11/7 16:25
 */
public class Singleton {
    public static void main(String[] args) {

    }
}


/**
 * 饿汉式（静态变量）
 * 1. 优点： 写法简单，就是在类装载的时候完成实例化。避免了线程同步问题
 * 2. 缺点：
 * （1） 在类装载的时候完成实例化，没有达到 Lazy Loading 的效果。如果从未使用过这个实例，则会造成内存浪费
 * （2） 这种方法基于 classloader 机制避免了多线程的同步问题，不过，instance在类装载时就实例化，在单例模式中大多数都是调用
 * getInstance()方法。但是导致类装载的原因有很多种，因此不能确定有其他方式（或者其他的静态方法）导致类装载，这时候初始化 instance
 * 就没有达到 Lazy Loading 的效果
 */
class Singleton01 {
    // 1. 构造器私有化，外部不能用 new
    private Singleton01() {
    }

    // 2. 本类内部创建对象实例
    private final static Singleton01 instance = new Singleton01();

    // 3. 提供一个公有的静态方法，返回实例对象
    public static Singleton01 getInstance() {
        return instance;
    }
}

/**
 * 饿汉式（静态代码块）
 */
class Singleton02 {
    // 1. 构造器私有化，外部不能用 new
    private Singleton02() {
    }

    // 2. 本类内部创建对象实例
    private final static Singleton02 instance;

    static {
        instance = new Singleton02();
    }

    // 3. 提供一个公有的静态方法，返回实例对象
    public static Singleton02 getInstance() {
        return instance;
    }
}

/**
 * 起到了Lazy Loading 的效果，但是只能在单线程下使用
 * 在多线程下，该方式不安全，同步效率太低了
 * 开发中，不推荐使用
 */
class Singleton03 {
    private static Singleton03 instance;

    private Singleton03() {
    }

    // 提供一个静态的公有方法，当使用该方法是=时，才会去创建instance
    // 即懒汉式
    public static Singleton03 getInstance() {
        if (null == instance) {
            instance = new Singleton03();
        }
        return instance;
    }
}

/**
 * 懒汉式（线程安全，同步方法）
 * 开发中，不推荐使用
 */
class Singleton04 {
    private static Singleton04 instance;

    private Singleton04() {
    }

    // 提供一个静态的公有方法，当使用该方法是=时，才会去创建instance
    // 即懒汉式
    public static synchronized Singleton04 getInstance() {
        if (null == instance) {
            instance = new Singleton04();
        }
        return instance;
    }
}

/**
 * 懒汉式（线程安全，同步代码块）
 * 开发中，不推荐使用
 */
class Singleton05 {
    private static Singleton05 instance;

    private Singleton05() {
    }

    // 提供一个静态的公有方法，当使用该方法是=时，才会去创建instance
    // 即懒汉式
    public static Singleton05 getInstance() {
        if (null == instance) {
            synchronized (Singleton05.class) {
                instance = new Singleton05();
            }
        }
        return instance;
    }
}

/**
 * 双重检查
 * 提供了一个静态的公有方法，加入双重检查代码，解决线程安全问题，同时解决家在问题
 * 同时保证效率，推荐使用
 * 优点：
 * 1. Double-Check概念是多线程开发中常使用到的，如代码中，我们进行了两次 if 的校验，可以保证线程安全
 * 2. 实例化代码只用执行一次，后面再次访问时，判断 if (null == instance) , 直接 return 实例化对象，也避免了反复进行方法同步
 * 3. 线程安全，延迟加载，效率高
 */
class Singleton06 {
    private static Singleton06 instance;

    private Singleton06() {
    }

    // 提供一个静态的公有方法，当使用该方法是=时，才会去创建instance
    // 即懒汉式
    public static Singleton06 getInstance() {
        if (null == instance) {
            synchronized (Singleton06.class) {
                if (null == instance) {
                    instance = new Singleton06();
                }
            }
        }
        return instance;
    }
}

/**
 * 1. 采用了类加载的机制料保护初始化实例只有一个线程
 * 2. 静态内部类方法在类加载的时候不会立即呗实例化，而是在需要实例化的时候，调用 getInstance()方法，才会在装载SingleInstance类，从而完成实例化
 * 3. 类的静态属性只会在第一次加载类的时候初始化，所以在这里， JVM帮助我们保证了线程的安全性，在类进行初始化的时候，别的线程是无法进入的
 * 4. 优点： 避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
 * 5. 推荐使用
 */
class Singleton07 {
    private static Singleton07 instance;

    private Singleton07() {
    }

    // 写一个静态内部类，该类中有一个静态属性 Singleton07
    private static class SingleInstance {
        private static final Singleton07 SINGLETON_07 = new Singleton07();
    }

    // 提供一个静态的公有方法，直接返回实例
    public static synchronized Singleton07 getInstance() {
        return SingleInstance.SINGLETON_07;
    }
}

/**
 * 推荐使用
 */
enum Singleton08 {
    INSTANCE; // 属性

    public void sayOK() {
        System.out.println("ok ~ ");
    }
}


