package com.xq.mybatisplus;



import com.baomidou.mybatisplus.plugins.Page;
import com.xq.mybatisplus.demo.bean.Employee;
import com.xq.mybatisplus.demo.mapper.EmployeeMapper;
import com.xq.mybatisplus.demo.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.mockito.internal.util.collections.ListUtil.filter;


@RunWith(SpringRunner.class)
@SpringBootTest
public class baseCREDTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;


    /**
     *  通用删除操作
     *      测试delete
     */
    @Test
    public void testDelete() {

        //通过id 删除
        //Integer integer = employeeMapper.deleteById(7);

        //通过封装Map 条件删除
       /* HashMap<String, Object> columnMap = new HashMap<>();
        columnMap.put("last_name","mp");
        columnMap.put("gender","1");

        Integer integer = employeeMapper.deleteByMap(columnMap);*/

       //批量删除

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(8);
        integers.add(9);
        Integer integer = employeeMapper.deleteBatchIds(integers);


        System.out.println(integer);

    }



    /**
     *  通用查询操作
     *      测试select
     */
    @Test
    public void testSelect() {

        //通过ID查询
        //Employee employee = employeeMapper.selectById(1);

        //通过多个列查询   多条件
        //selectOne 如果能查到很多数据 要报错
       /* Employee employee = new Employee();
        employee.setId(2);
        employee.setLastName("Jerry");
        Employee employee1 = employeeMapper.selectOne(employee);*/

       // 通过多个id 查询

       /* ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(5);
        List<Employee> employees = employeeMapper.selectBatchIds(integers);

        for (Employee employee : employees) {
            System.out.println(employee);
        }*/


       //通过Map封装条件查询

       /* HashMap<String, Object> columnMap = new HashMap<>();
        columnMap.put("last_name","Black");
        columnMap.put("gender","1");

        List<Employee> employees = employeeMapper.selectByMap(columnMap);
        employees.forEach(employee-> System.out.println(employee));*/

        //分页查询
        List<Employee> employees = employeeMapper.selectPage(new Page<>(2, 2), null);

        employees.forEach(employee -> {
            System.out.println(employee.getLastName());
        });
    }

    /**
     *  通用更新操作
     *      测试update
     */
    @Test
    public void testUpdate() {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setAge(22);
        employee.setEmail("xiongqi4@163.com");
        employee.setGender("0");
        employee.setLastName("tt");

      /*  ArrayList<Integer> StringList1 = new ArrayList<>();
        StringList1.add(1);
        StringList1.add(3);
        StringList1.add(5);

        ArrayList<Integer> StringList2 = new ArrayList<>();
        StringList1.add(1);
        StringList1.add(4);
        StringList1.add(6);
        StringList1.forEach(str1->{
            StringList2.forEach(str2->{
                if (str1==str2) {
                    System.out.println(str2);
                }
            });
        });*/

      List<String> fruit = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
        List<String> newFruit = filter(fruit, (s) -> s.length() != 2);

        System.out.println(newFruit);
        /*Integer integer = employeeMapper.updateById(employee);
        System.out.println(integer);*/

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
