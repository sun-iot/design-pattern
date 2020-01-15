package com.ci123.school.recruitment;

/**
 * @author Mr.Sun
 * @version v.1.0
 * @title OperatorDiv
 * @description
 * @date 2020/1/15 17:12
 */
public class OperatorDiv extends Operator {
    @Override
    public int getResult() {
        if (numB == 0){
            throw new IllegalArgumentException("The divisor cannot be 0;") ;
        }
        return numA / numB ;
    }
}
