package ru.skypro.lessons.springboot.springweb.service;

import ru.skypro.lessons.springboot.springweb.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.springweb.pojo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    /**
     * POST создавать множество новых сотрудников
     */
    void addEmployee(Employee employee);

    /**
     * PUT редактировать сотрудника с указанным id
     */
    void updateByIdEmployee(Integer id, String name, Integer salary);

    /**
     * GET возвращать информацию о сотруднике с переданным id
     */
    Optional<Employee> getBuIdEmployee(int id);

    /**
     * DELETE удалять сотрудника с переданным id
     */
    void deleteByIdEmployee(int id);

    /**
     * GET  возвращать самой высокой зарплатой
     */
    List<Employee> employeeHighSalary (Integer salary);
    /**
     * GET возвращать информацию о сотруднике с переданным position
     */
    List<EmployeeFullInfo>getBuPositionToEmployee(String role);
    List<EmployeeFullInfo> getFull();

}
