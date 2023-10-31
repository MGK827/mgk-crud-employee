package com.mgk.employee.service;

import com.mgk.employee.domain.entity.Employee;
import com.mgk.employee.domain.request.EmployeeRequest;
import com.mgk.employee.mapper.EmployeeMapper;
import com.mgk.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public void createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = EmployeeMapper.MAPPER.toEmployee(employeeRequest);
        employeeRepository.save(employee);
    }
}
