package com.ci123.base.dp;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.management.monitor.Monitor;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * Copyright (c) 2018-2028 Corp-ci All Rights Reserved
 * <p> 迪米特法则
 * Project: design-pattern
 * Package: com.ci123.base.dp
 * Version: 1.0
 * <p>
 * Created by SunYang on 2019/11/7 11:50
 */
// 有一个学校，下属有各个学院和总部，现要求打印出学校总部员工ID和学院员工ID
public class DemeterDemo {
    public static void main(String[] args) {
        // 先创建一个 SchoolManager 对象
        SchoolManager schoolManager = new SchoolManager();

        // 输出学院的员工 ID 和 学校总部的员工信息
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

// 学校总部的员工类
class Employee{
    private String id ;
    public void setId(String id){
        this.id = id ;
    }
    public String getId(){
        return id ;
    }
}
// 学院员工类
class CollegeEmployee{
    private String id ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

// 管理学院员工的管理类
class CollegeManager{
    // 返回学院的所有员工
    public List<CollegeEmployee> geAllEmployee(){
        List<CollegeEmployee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee employee = new CollegeEmployee();
            employee.setId("学院员工ID=" + i);
            list.add(employee) ;
        }
        return list ;
    }
    public void printEmployee(){
        // 获取到学院员工
        List<CollegeEmployee> list = this.geAllEmployee();
        System.out.println("========== 学院员工 ============");
        for (CollegeEmployee employee : list) {
            System.out.println(employee.getId());
        }
    }
}
// 分析SchoolManager类的直接朋友有哪些，Employee,CollegeManager
// CollegeEmployee 不是直接朋友关系，而是一个陌生类，这样违背了 迪米特法则
class SchoolManager{

    // 返回学校的总员工
    public List<Employee> getAllEmployees(){
        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Employee employee = new Employee();
            employee.setId("学校ID=" + i);
            list.add(employee) ;
        }
        return list ;
    }
    // 该方法完成输出学校总部和学院员工信息 ID
    void printAllEmployee(CollegeManager manager){
        // 封装到 CollegeManager 里面
        manager.printEmployee();

        // 获取到学校员工
        List<Employee> allEmployee = this.getAllEmployees();
        System.out.println("========== 学校员工 ============");
        for (Employee employee : allEmployee) {
            System.out.println(employee.getId());
        }
    }
}
