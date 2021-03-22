package com.paypal.bfs.test.employeeserv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

public interface EmployeeServDao extends CrudRepository<Employee, Integer> {

}
