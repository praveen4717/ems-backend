package net.javaguides.ems.service.Impl;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.DepartmentRepository;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * @param employeeDto
     * @return
     */
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee =employeeMapper.mapToEmployee(employeeDto);
        Department department = departmentRepository.findById(employeeDto.getDepartmentId()).get();
        employee.setDepartment(department);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.mapToEmployeeDto(savedEmployee);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return employeeMapper.mapToEmployeeDto(employeeRepository.findById(id).get());
    }

    /**
     * @return
     */
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = employees.stream().map(employeeMapper::mapToEmployeeDto).toList();
        return employeeDtoList;
    }

    /**
     * @param employeeId
     * @param employeeDto
     * @return
     */
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) throws Exception {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new Exception("employee is not exists with given id: "+String.valueOf(employeeId)));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Department department = departmentRepository.findById(employeeDto.getDepartmentId()).get();
        employee.setDepartment(department);
        Employee updateEmployee = employeeRepository.save(employee);
        return employeeMapper.mapToEmployeeDto(updateEmployee);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public String deleteEmployee(Long id) {
       Employee employee = employeeRepository.findById(id).get();
       employeeRepository.delete(employee);
        return "Employee Deleted Successfully";
    }
}
