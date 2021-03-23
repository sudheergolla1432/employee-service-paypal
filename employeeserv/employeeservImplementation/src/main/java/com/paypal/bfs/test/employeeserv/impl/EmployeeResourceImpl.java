package com.paypal.bfs.test.employeeserv.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeServDao;
import com.paypal.bfs.test.employeeserv.utility.EmployeeNotFoundException;
import com.paypal.bfs.test.employeeserv.utility.IllegalArgumentFoundException;
import com.paypal.bfs.test.employeeserv.utility.ObjectHelper;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	@Autowired
	private EmployeeServDao employeeServDao;
	
	/* take employee id from pathVariable and gets employee from db using employee id
	 * If no employee found with given id it throws employee not found exception which 
	 * is handled by custom exception Handler
     */
    @Override
    public ResponseEntity<Employee> getEmployeeById(String id) {
    	
    	int idVal;
    	try {
    			idVal = Integer.parseInt(id);
    			if(idVal <= 0) {
    				throw new Exception();
    			}
    	}
    	catch(Exception e) {
    		throw new IllegalArgumentFoundException("Illegal Argument given - id should be int value greater than 0 : "+id);
    	}
    	Optional<Employee> employee = employeeServDao.findById(idVal);
    	
    	if(employee.isEmpty()) {
    		
    		throw new EmployeeNotFoundException("Employee not found with id : "+id);
    		
    	}
        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
    }

    /* take Employee details from RequestBody and performs validations on them and 
     * throws error if any validation errors
     */
    
	@Override
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		
		// creating address object we can also get address value from db
		Address address = ObjectHelper.getAddress();
		employee.setAddress(address);
		
		/* as we have cascaded address in Employee class when we save Employee
		 * automatically address also saves to db
		 */
		 employeeServDao.save(employee);
		
		 return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}
	
	/* get all employees from db
     * throws exception with exception message "No Employees found" if no employees found.
     */
	@Override
	public ResponseEntity<List<Employee>> getAllEmployees() {
		
		List<Employee> employees = (List<Employee>) employeeServDao.findAll();
		
		if(employees.size() == 0) {
			throw new EmployeeNotFoundException("No Employees found");
		}
		
		 return new ResponseEntity<>(employees, HttpStatus.OK);
	}
}
