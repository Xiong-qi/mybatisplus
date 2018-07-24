package com.xq.mybatisplus.demo.bean;


import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * tbl_employee
 * @author  xq
 */
@Data
@TableName(value = "tbl_employee")
public class Employee  {

    private Integer id;

    private String lastName;

    private String email;

    private String gender;

    private Integer age;


}