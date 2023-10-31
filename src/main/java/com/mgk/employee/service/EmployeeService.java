package com.mgk.employee.service;

import com.mgk.employee.domain.entity.Employee;
import com.mgk.employee.domain.request.EmployeeRequest;
import com.mgk.employee.domain.response.EmployeeResponse;
import com.mgk.employee.mapper.EmployeeMapper;
import com.mgk.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public void createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = EmployeeMapper.MAPPER.toEmployee(employeeRequest);

        employeeRepository.save(employee);
    }

    public EmployeeResponse getEmployee(int id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            return EmployeeMapper.MAPPER.toEmployeeResponse(employeeOptional.get());
        }else{
            throw new RuntimeException("RecordNotFound");
        }
    }
}
