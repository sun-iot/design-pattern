package com.ci123.base.ocp;

/**
 * Copyright (c) 2018-2028 Corp-ci All Rights Reserved
 * <p>
 * Project: design-pattern
 * Package: com.ci123.base.ocp
 * Version: 1.0
 * <p>
 * Created by SunYang on 2019/11/7 11:20
 */
public class OCPDemo {
    public static void main(String[] args) {
        // 使用看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
        graphicEditor.drawShape(new Other());
    }
}

// 使用方，绘图
class GraphicEditor {
    public void drawShape(Shape shape) {

        shape.draw();
    }

}

// 基类
abstract class Shape {
    int m_type;

    abstract void draw();
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }

    @Override
    void draw() {
        System.out.println("矩形");
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }

    @Override
    void draw() {
        System.out.println("圆");
    }
}

// 新增三角形
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }

    @Override
    void draw() {
        System.out.println("三角形");
    }
}

class Other extends Shape {
    Other() {
        super.m_type = 4;
    }

    @Override
    void draw() {
        System.out.println("其他的");
    }
}

