package com.xq.mybatisplus;



import com.xq.mybatisplus.demo.bean.Employee;
import com.xq.mybatisplus.demo.mapper.EmployeeMapper;
import com.xq.mybatisplus.demo.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class demoTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     *  通用更新操作
     *      测试update
     */
    @Test
    public void testUpdate() {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setAge(25);
        employee.setEmail("xiongqi@163.com");
        employee.setGender("1");
        employee.setLastName("tt");


    }





    /**
     *  测试新增
     */
    @Test
    public void testInsert() {
        Integer integer = employeeService.insertEmployee();

        System.out.println(integer);


    }

    /**
     *  测试查询所有
     */
    @Test
    public void testSelectAll() {
        List<Employee> employees = employeeMapper.selectList(null);

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    /**
     *  测试新增返回主键
     */
    @Test
    public void testInsertKey() {
        Employee employee = new Employee();
        employee.setAge(25);
        employee.setEmail("xiongqi@163.com");
        employee.setGender("1");
        employee.setLastName("mp");

        Integer insert = employeeMapper.insert(employee);

        System.out.println(insert);

        Integer key=employee.getId();

        System.out.println("key: " + key);
    }


}
