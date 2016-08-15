package com.test;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    public EmployeeBean createEmployee() {
        EmployeeBean employeeBean = new EmployeeBean();
        employeeBean.setFullName("sdfs");
        employeeBean.setAge(28);
        return employeeBean;
    }
}
