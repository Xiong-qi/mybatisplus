package com.xq.mybatisplus;


import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xq.mybatisplus.demo.bean.Employee;
import com.xq.mybatisplus.demo.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityWapperCREDTests {


    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 使用条件构造器 (Condition)
     * 分页查询
     */
    @Test
    public void testConSelect() {

        // 查询 tbl_employee 表中， 年龄在 18~50 之间  性别为男且 姓名为 xx 的所有用户


        List<Employee> employees = employeeMapper.selectPage(
                new Page<Employee>(1, 2),
                Condition.create().between("age", 18, 50)
                        .eq("gender", 1)
                        .eq("last_name", "tom"));

        System.out.println(employees);
    }



    /**
     * 使用条件构造器
     * 分页查询
     */
    @Test
    public void testEntityWapperSelect() {

        // 查询 tbl_employee 表中， 年龄在 18~50 之间  性别为男且 姓名为 xx 的所有用户


       /* List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(1, 2),
                new EntityWrapper<Employee>().between("age", 18, 50)
                        .eq("gender", 1)
                        .eq("last_name", "tom"));


        System.out.println(employees);*/

        //查询  性别为女 ，名字中带有老师， 或者 邮箱中带有qi


       /* List<Employee> employees = employeeMapper.selectList(
                new EntityWrapper<Employee>()
                        .eq("gender", 0)
                        //.or()     //sql (gender = ? OR email LIKE ?)
                        .orNew()    //sql  (gender = ?)OR (email LIKE ?)
                        .like("email", "qi"));*/

        //查询  性别为女 ，根据age排序 （asc/desc）,简单分页

        List<Employee> employees = employeeMapper.selectList(
                new EntityWrapper<Employee>().eq("gender", 0)
                .orderBy("age", false)
                .last("limit 1 ,3 "));



        System.out.println(employees);
    }




    /**
     * 使用条件构造器
     *      修改操作
     */
    @Test
    public void testEntityWapperUpdate() {


        Employee employee = new Employee();
        employee.setAge(19);
        employee.setEmail("tom@163.com");
        employee.setGender("0");

        employeeMapper.update(employee,
                new EntityWrapper<Employee>()
                .eq("last_name","tom")
                .eq("age",22));

    }

    /**
     * 使用条件构造器
     *      删除操作
     */
    @Test
    public void testEntityWapperDelete() {


        employeeMapper.delete(
                new EntityWrapper<Employee>()
                        .eq("last_name","tom")
                        .eq("age",24));

    }


}
