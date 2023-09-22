package com.gl.client;


import com.gl.model.Employee;

import com.gl.service.EmployeeServiceImpl;

public class ClientMain {

	public static void main(String[] args) {
		EmployeeServiceImpl employeeService=new EmployeeServiceImpl();
		
		//inserting 5 records
		Employee e1=new Employee(1, "Raja", "raja@gmail.com", "7337373587");
		Employee e2=new Employee(2, "vikas", "vikas@gmail.com", "8333999699");
		Employee e3=new Employee(3, "Rakesh", "rakesh@gmail.com", "8608062322");
		Employee e4=new Employee(4, "Rajith", "rajith@gmail.com", "7713413641");
		Employee e5=new Employee(5, "kumar", "kumar@gmail.com", "4813849171");
		employeeService.insertRecords(e1);
		employeeService.insertRecords(e2);
		employeeService.insertRecords(e3);
		employeeService.insertRecords(e4);
		employeeService.insertRecords(e5);
		//modifying email column
		employeeService.modifyEmailColumn();
		//adding two records and checking 
		Employee e6=new Employee(6, "uma", "uma@gmail.com", "6281345487");
		Employee e7=new Employee(2, "raghu", "raghu@gmail.com", "9440457829");
		employeeService.insertRecords(e6);
		employeeService.insertRecords(e7);
		employeeService.display();
		//updating the name of the employee and phone_number of given id
		employeeService.updateEmployee(3, "karthik", "1234567890");
		employeeService.display();
		//deleting a particular employee id 
		employeeService.deleteEmployee();
		employeeService.display();
		//removing all the records
		employeeService.removeAllRecords();
		
		
	}

}
