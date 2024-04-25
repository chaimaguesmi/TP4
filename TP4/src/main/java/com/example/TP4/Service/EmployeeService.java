package com.example.TP4.Service;

import com.example.TP4.Dto.EmployeeDTO;
import com.example.TP4.Dto.LoginDTO;
import com.example.TP4.response.LoginResponse;

public interface EmployeeService {

    String addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
}
