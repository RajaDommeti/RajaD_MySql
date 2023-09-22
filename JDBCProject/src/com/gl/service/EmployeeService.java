package com.gl.service;

import com.gl.model.Employee;

public interface EmployeeService {
	void insertRecords(Employee employee);
	void modifyEmailColumn();
	void updateEmployee(int id ,String newName,String newPhnNum);
	void deleteEmployee();
	void removeAllRecords();
	void display();
}
