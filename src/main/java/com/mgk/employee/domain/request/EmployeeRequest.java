package com.mgk.employee.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class EmployeeRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String email ;
    @NotBlank private String bloodGroup;
}
