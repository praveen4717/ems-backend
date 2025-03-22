package net.javaguides.ems.controller;

import net.javaguides.ems.dto.DepartmentDTO;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO department = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") Long id){
        DepartmentDTO departmentDTO = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(departmentDTO,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        List<DepartmentDTO> departmentDTOList = departmentService.getAllDepartments();
        return new ResponseEntity<>(departmentDTOList,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable("id") Long id, @RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO department = departmentService.updateDepartment(id,departmentDTO);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long id){
        String departmentStr = departmentService.deleteDepartment(id);
        return new ResponseEntity<>(departmentStr,HttpStatus.OK);
    }
}
