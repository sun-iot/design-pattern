package com.ci123.school.recruitment;

import java.util.Scanner;

/**
 * @author Mr.Sun
 * @version v.1.0
 * @title Calculator
 * @description
 * @date 2020/1/15 16:11
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;

        System.out.println("请输入数字 A ： ");
        int numA = scanner.nextInt();
        System.out.println("输入操作符： ");
        String operate = scanner.next();
        System.out.println("输入数字 B ： ");
        int numB = scanner.nextInt();

        Operator operator = OperatorFactory.createOperatorFactory(operate) ;
        operator.setNumA(numA);
        operator.setNumB(numB);
        int result = operator.getResult();
        System.out.println(result);

    }


}
