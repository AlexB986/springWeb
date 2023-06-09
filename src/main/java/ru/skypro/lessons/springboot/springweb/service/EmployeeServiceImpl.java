package ru.skypro.lessons.springboot.springweb.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.lessons.springboot.springweb.pojo.Employee;
import ru.skypro.lessons.springboot.springweb.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * POST создавать множество новых сотрудников
     */
    @Override
    public void addEmployee(Integer id, String name, Integer salary) {
        List<Employee>employeeList = employeeRepository.getAllEmployee();
        employeeList.add(new Employee(id,name,salary));


    }

    /**
     * PUT редактировать сотрудника с указанным id
     */
    @Override
    public void updateByIdEmployee(Integer id, String name, Integer salary) {
        List<Employee> employeeList = employeeRepository.getAllEmployee();
        for (int i = 0; i < employeeList.size(); i++) {
            if (id == employeeList.get(i).getId()) {
                employeeList.get(i).setName(name);
                employeeList.get(i).setSalary(salary);
            }
        }
    }

    /**
     * GET возвращать информацию о сотруднике с переданным id
     */
    @Override
    public String getBuIdEmployee(int id) {

        List<Employee> employeeList = employeeRepository.getAllEmployee();
        for (int i = 0; i < employeeList.size(); i++) {

            if (id == employeeList.get(i).getId()) {
                String user = employeeList.get(i).toString();
                return user;
            }
        }
        return null;
    }
    /**
     * DELETE удалять сотрудника с переданным id
     */
    @Override
    public void deleteByIdEmployee(int id) {
        List<Employee> employeeList = employeeRepository.getAllEmployee();
        employeeList.remove(id);

    }

    /**
     * GET  возвращать всех сотрудников, зарплата
     */
    @Override
    public List<Employee> employeeHighSalarySalary(Integer salary) {
        List<Employee> employeeSortSalaryEmployee = new ArrayList<>();
        List<Employee> employeeList = employeeRepository.getAllEmployee();
        for (int i = 0; i < employeeList.size(); i++) {
            if (salary < employeeList.get(i).getSalary()) {
                employeeSortSalaryEmployee.add((new Employee(employeeList.get(i).getId(), employeeList.get(i).getName(), employeeList.get(i).getSalary())));
            }
        }
        return employeeSortSalaryEmployee;

    }
}
