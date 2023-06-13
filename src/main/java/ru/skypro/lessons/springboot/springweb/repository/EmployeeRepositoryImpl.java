package ru.skypro.lessons.springboot.springweb.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.springweb.pojo.Employee;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private final static List<Employee> EMPLOYEE_LIST = List.of(
            new Employee(1,"Катя", 90_000),
            new Employee(2,"Дима", 102_000),
            new Employee(3,"Олег", 80_000),
            new Employee(4,"ОлЬга", 40_000),
            new Employee(5,"Вика", 165_000)
    );



    @Override
    public List<Employee> getAllEmployee() {
        return new ArrayList<>(EMPLOYEE_LIST);
    }

}
