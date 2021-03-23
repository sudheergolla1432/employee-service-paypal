package com.paypal.bfs.test.employeeserv.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @GetMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id);

    // ----------------------------------------------------------
    // TODO - add a new operation for creating employee resource.
    // ----------------------------------------------------------
    
    /**
     * creates employee using Requestbody sent via post.
     *
     *@return employee resource
     */
    @PostMapping("/v1/bfs/create")
    ResponseEntity<Employee> createEmployee(@RequestBody Employee employee);
    
    /**
     * Retrieves all employees.
     *
     *@return list of  employees resources from db
     */
    @GetMapping("/v1/bfs/employees")
    public ResponseEntity<List<Employee>> getAllEmployees();
}
