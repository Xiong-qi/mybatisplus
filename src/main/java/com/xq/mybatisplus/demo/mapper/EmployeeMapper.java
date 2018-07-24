package com.xq.mybatisplus.demo.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xq.mybatisplus.demo.bean.Employee;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface EmployeeMapper extends BaseMapper<Employee>{

}
