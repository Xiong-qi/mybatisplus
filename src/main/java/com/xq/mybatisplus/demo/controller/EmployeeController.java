package com.xq.mybatisplus.demo.controller;


import com.xq.mybatisplus.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService EmployeeService;


    @GetMapping("/userList")
    public Integer getInfo(){

        return EmployeeService.insertEmployee();
    }
}
