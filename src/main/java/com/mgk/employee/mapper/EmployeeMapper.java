package com.mgk.employee.mapper;

import com.mgk.employee.domain.entity.Employee;
import com.mgk.employee.domain.request.EmployeeRequest;
import com.mgk.employee.domain.response.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface EmployeeMapper {
    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    Employee toEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse toEmployeeResponse(Employee employee);
}
