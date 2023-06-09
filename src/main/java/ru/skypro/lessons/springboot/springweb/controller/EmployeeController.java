package ru.skypro.lessons.springboot.springweb.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.lessons.springboot.springweb.pojo.Employee;
import ru.skypro.lessons.springboot.springweb.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private static EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * POST создавать множество новых сотрудников
     */
    @GetMapping("create")
    public String mapAddEmployee() {
        try {
            return employeeService.addEmployee();

        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * PUT редактировать сотрудника с указанным id
     */

//    @GetMapping("{id}/{name}/{salary}")
    @GetMapping("update")
    public void mapUpdateEmployee(@RequestParam("id") Integer id,
                                  @RequestParam("name") String name,
                                  @RequestParam("salary") Integer salary) {
        employeeService.updateByIdEmployee(id, name, salary);
    }

    /**
     * GET возвращать информацию о сотруднике с переданным id
     */
    @GetMapping("employees-id/{id}")
    public String mapGetBuIdEmployee(@PathVariable int id) {
        try {
            return employeeService.getBuIdEmployee(id);
        } catch (Throwable t) {
            String message = "Нет такого id";
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,message);
        }
    }

    /**
     * DELETE удалять сотрудника с переданным id
     */
    @GetMapping("employee-delete/{id}")
    public void deleteIdEmployee(@PathVariable int id) {
        try {
            employeeService.deleteByIdEmployee(id);
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
    }

    /**
     * GET  возвращать всех сотрудников, зарплата
     */
    @GetMapping("high")
    public List<Employee> showeHighSalarySalary(@RequestParam("salary") Integer salary) {
        return employeeService.employeeHighSalarySalary(salary);
    }

}
