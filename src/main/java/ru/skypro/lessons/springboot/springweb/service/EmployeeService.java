package ru.skypro.lessons.springboot.springweb.service;

import org.springframework.web.bind.annotation.GetMapping;
import ru.skypro.lessons.springboot.springweb.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * POST создавать множество новых сотрудников
     */
    void addEmployee(Integer id, String name, Integer salary);

    /**
     * PUT редактировать сотрудника с указанным id
     */
    void updateByIdEmployee(Integer id,String name,Integer salary);

    /**
     * GET возвращать информацию о сотруднике с переданным id
     */
    String getBuIdEmployee(int id );

    /**
     * DELETE удалять сотрудника с переданным id
     */
    void deleteByIdEmployee(int id);

    /**
     * GET  возвращать всех сотрудников, зарплата
     */
    List<Employee> employeeHighSalarySalary(Integer salary);
}
