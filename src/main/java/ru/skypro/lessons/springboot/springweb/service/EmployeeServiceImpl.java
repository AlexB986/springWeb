package ru.skypro.lessons.springboot.springweb.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.springweb.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.springweb.pojo.Employee;
import ru.skypro.lessons.springboot.springweb.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

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
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


    /**
     * GET возвращать информацию о сотруднике с переданным id
     */
    @Override
    public Optional<Employee> getBuIdEmployee(int id) {
        return employeeRepository.findById(id);
    }


    /**
     * GET самой высокой зарплатой
     */
    @Override
    public List<Employee> employeeHighSalary(Integer lowBoard) {
        return employeeRepository.employeeUserHighSalary(lowBoard);
    }


    /**
     * GET возвращать информацию о сотруднике с переданным position
     */
    @Override
    public List<EmployeeFullInfo> getBuPositionToEmployee(String role) {
        return employeeRepository.buPositionToEmployee(role);
    }
    /**
     * GET возвращать полную информацию о сотруднике
     *
     */
    @Override
    public List<EmployeeFullInfo> getFull() {
        return employeeRepository.getFullEmployee();
    }


//    /**
//     * GET  возвращать всех сотрудников, зарплата
//     */
//    @Override
//    public List<Employee> employeeHighSalarySalary(Integer salary) {
//        employeeRepository.withHighestSalary(salary).stream().;
//                List<Employee> employeeSortSalaryEmployee = new ArrayList<>();
//        List<Employee> employeeList = employeeRepository.getAllEmployee();
//        for (int i = 0; i < employeeList.size(); i++) {
//            if (salary < employeeList.get(i).getSalary()) {
//                employeeSortSalaryEmployee.add((new Employee(employeeList.get(i).getId(), employeeList.get(i).getName(), employeeList.get(i).getSalary())));
//            }
//        return null;
//    }


//    /**
//     * PUT редактировать сотрудника с указанным id
//     */
//    @Override
//    public void updateByIdEmployee(Integer id, String name, Integer salary) {
//        List<Employee> employeeList = employeeRepository.getAllEmployee();
//        for (int i = 0; i < employeeList.size(); i++) {
//            if (id == employeeList.get(i).getId()) {
//                employeeList.get(i).setName(name);
//                employeeList.get(i).setSalary(salary);
//            }
//        }
//    }
//
//    /**
//     * GET возвращать информацию о сотруднике с переданным id
//     */
//    @Override
//    public String getBuIdEmployee(int id) {
//
//        List<Employee> employeeList = employeeRepository.getAllEmployee();
//        for (int i = 0; i < employeeList.size(); i++) {
//
//            if (id == employeeList.get(i).getId()) {
//                String user = employeeList.get(i).toString();
//                return user;
//            }
//        }
//        return null;
//    }
//
//    /**
//     * DELETE удалять сотрудника с переданным id
//     */
//    @Override
//    public void deleteByIdEmployee(int id) {
//        List<Employee> employeeList = employeeRepository.getAllEmployee();
//        employeeList.remove(id);
//
//    }
//
//    /**
//     * GET  возвращать всех сотрудников, зарплата
//     */
//    @Override
//    public List<Employee> employeeHighSalarySalary(Integer salary) {
//        List<Employee> employeeSortSalaryEmployee = new ArrayList<>();
//        List<Employee> employeeList = employeeRepository.getAllEmployee();
//        for (int i = 0; i < employeeList.size(); i++) {
//            if (salary < employeeList.get(i).getSalary()) {
//                employeeSortSalaryEmployee.add((new Employee(employeeList.get(i).getId(), employeeList.get(i).getName(), employeeList.get(i).getSalary())));
//            }
//        }
//        return employeeSortSalaryEmployee;
//
//    }


    @Override
    public void updateByIdEmployee(Integer id, String name, Integer salary) {

    }


    @Override
    public void deleteByIdEmployee(int id) {

    }

    //////////////////////////////////////////*



}
