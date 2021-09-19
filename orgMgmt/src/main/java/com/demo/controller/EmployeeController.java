package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("Welcome");
	}

    @GetMapping(value="/employees", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value="/employee/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
    

    @PostMapping(value="/employees", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @PutMapping(value="/employee/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employeeDetails) {
    	return ResponseEntity.ok(employeeService.update(id, employeeDetails));
    }

    @DeleteMapping(value="/employee/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {        
        employeeService.delete(id);
        Map<String, Boolean> res = new HashMap<String, Boolean>();
        res.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(res);
    }
}
