package com.ci123.school.recruitment;

/**
 * @author Mr.Sun
 * @version v.1.0
 * @title Operator
 * @description
 * @date 2020/1/15 16:52
 */
public abstract class Operator {
    public int numA ;
    public int numB ;


    public int getNumA() {
        return numA;
    }

    public void setNumA(int numA) {
        this.numA = numA;
    }

    public int getNumB() {
        return numB;
    }

    public void setNumB(int numB) {
        this.numB = numB;
    }

    public abstract int getResult();
}
