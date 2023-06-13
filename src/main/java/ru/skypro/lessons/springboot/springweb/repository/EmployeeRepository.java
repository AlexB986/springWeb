package ru.skypro.lessons.springboot.springweb.repository;

import ru.skypro.lessons.springboot.springweb.pojo.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> getAllEmployee();
}
