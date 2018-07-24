package com.xq.mybatisplus.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.xq.mybatisplus.demo.bean.Employee;

public interface EmployeeService extends IService<Employee> {

    Integer insertEmployee();
}
