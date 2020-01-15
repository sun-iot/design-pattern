package com.ci123.school.recruitment;

/**
 * @author Mr.Sun
 * @version v.1.0
 * @title OperatorFactory
 * @description
 * @date 2020/1/15 17:14
 */
public class OperatorFactory {

    public static Operator createOperatorFactory(String operate){
        switch (operate){
            case "+" :
                return new OperatorAdd() ;
            case "-":
                return new OperatorSub() ;
            case "*":
                return new OperatorMul() ;
            case "/":
                return new OperatorDiv() ;
            default:
                throw new IllegalArgumentException("Are you kidding ? ") ;
        }
    }
}
