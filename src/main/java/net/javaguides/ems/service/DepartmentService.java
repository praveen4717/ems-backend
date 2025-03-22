package net.javaguides.ems.service;

import net.javaguides.ems.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    public DepartmentDTO getDepartmentById(Long id);

    public List<DepartmentDTO> getAllDepartments();

    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO);

    public  String deleteDepartment(Long id);
}
