package com.xq.mybatisplus.demo.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xq.mybatisplus.demo.bean.Employee;
import com.xq.mybatisplus.demo.mapper.EmployeeMapper;
import com.xq.mybatisplus.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {


    @Override
    public Integer insertEmployee() {

        Employee employee = new Employee();
        employee.setAge(18);
        employee.setEmail("xiongqi@163.com");
        employee.setGender("1");
        employee.setLastName("mp");

        Integer insert = baseMapper.insert(employee);
        return insert;
    }
}
