package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.DepartmentDTO;
import net.javaguides.ems.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public Department mapDTOtoDepartment(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setDepartmentDescription(departmentDTO.getDepartmentDescription());
        return department;
    }

    public DepartmentDTO mapDepartmentTODTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setDepartmentName(department.getDepartmentName());
        departmentDTO.setDepartmentDescription(department.getDepartmentDescription());
        return departmentDTO;
    }
}
