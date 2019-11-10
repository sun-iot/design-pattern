package com.ci123.base.dip;

/**
 * Copyright (c) 2018-2028 Corp-ci All Rights Reserved
 * <p> 依赖倒转(倒置)原则
 * Project: design-pattern
 * Package: com.ci123.base.dependence
 * Version: 1.0
 * <p>
 * Created by SunYang on 2019/11/7 10:14
 */
public class DependenceInversionPrinciple {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new EmailIR());
        person.receive(new WeiXinIR());
    }
}

class Email {
    public String getInfo() {
        return "电子邮件信息：Hello,World";
    }
}

/**
 * 完成Person接收消息的功能
 * 方式1 分析：
 * 1. 简单，比较容易想到的
 * 2. 如果我们获取的对象是 微信，短信等，则新增类，同时Person也要增加相应的接收方法
 * 3. 解决思路： 引入一个抽象的接口 IReceiver ，表示接收者 ， 这样Person类与接口IReceiver发生依赖
 * 因为Email,WeiXin等属于接收的范围，他们各自实现IReceiver接口就OK，这样我们就符合依赖倒转原则
 */
class Person {
    public void receive(IRceiver iRceiver) {
        System.out.println(iRceiver.getInfo());
    }
}

interface IRceiver {
    String getInfo();
}

class EmailIR implements IRceiver {

    @Override
    public String getInfo() {
        return "电子邮件信息(IReceiver)：Hello,World";
    }
}

class WeiXinIR implements IRceiver {

    @Override
    public String getInfo() {
        return "微信信息(IReceiver)：Hello,World";
    }
}