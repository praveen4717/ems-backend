package net.javaguides.ems.service.Impl;

import net.javaguides.ems.dto.DepartmentDTO;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.mapper.DepartmentMapper;
import net.javaguides.ems.repository.DepartmentRepository;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * @param departmentDTO
     * @return
     */
    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
       Department department= departmentMapper.mapDTOtoDepartment(departmentDTO);
      Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.mapDepartmentTODTO(savedDepartment);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow( () -> new ResourceAccessException("Given Id not found in Department"+id));
        return departmentMapper.mapDepartmentTODTO(department);
    }

    /**
     * @return
     */
    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList.stream().map(departmentMapper::mapDepartmentTODTO).toList();
    }

    /**
     * @param id
     * @param departmentDTO
     * @return
     */
    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(id).orElseThrow( () -> new ResourceAccessException("Given Id not found in Department"+id));
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setDepartmentDescription(departmentDTO.getDepartmentDescription());
        Department updatedDepartment = departmentRepository.save(department);
        return departmentMapper.mapDepartmentTODTO(updatedDepartment);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public String deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow( () -> new ResourceAccessException("Given Id not found in Department"+id));
        departmentRepository.delete(department);
        return "Department Deleted Successfully";
    }
}
