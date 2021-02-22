package com.example;

import javax.jws.WebService;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebService(endpointInterface = "com.example.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeServiceImpl() {
        this.employees.add(new Employee(1, "Emanuele Zicola"));
        this.employees.add(new Employee(2, "Vincenza Dell'Aversana"));
        this.employees.add(new Employee(3, "Lorenzo Pompili"));
        this.employees.add(new Employee(4,"Diego Gettatelli"));
    }

    @Override
    public Employee getEmployee(int id) {
        Optional<Employee> employeeById = employees.stream().filter(employee -> employee.getId() == id).findFirst();
        if (employeeById.isPresent()) {
            return employeeById.get();
        }
        throw new EmployeeNotFoundException(id);
    }

    @Override
    public Employee updateEmployee(int id, String name) {
        Optional<Employee> employeeById = employees.stream().filter(employee -> employee.getId() == id).findFirst();
        if (employeeById.isPresent()) {
            Employee employee = employeeById.get();
            employees.remove(employee);
            employee.setFirstName(name);
            employees.add(employee);
            return employee;
        }
        throw new EmployeeNotFoundException(id);
    }

    @Override
    public boolean deleteEmployee(int id) {
        Optional<Employee> employeeById = employees.stream().filter(employee -> employee.getId() == id).findFirst();
        if (employeeById.isPresent()) {
            Employee employee = employeeById.get();
            return employees.remove(employee);
        }
        return false;
    }

    @Override
    public Employee addEmployee(int id, String name) {
        Employee employee = new Employee(id, name);
        employees.add(employee);
        return employee;
    }
}
