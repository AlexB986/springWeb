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
    @PostMapping("create")
    public void mapAddEmployee(@RequestParam("id") Integer id,
                               @RequestParam("name") String name,
                               @RequestParam("salary") Integer salary) {
            employeeService.addEmployee( id,  name,  salary);
    }

    /**
     * PUT редактировать сотрудника с указанным id
     */

    @PutMapping("update")
    public void mapUpdateEmployee(@RequestParam("id") Integer id,
                                  @RequestParam("name") String name,
                                  @RequestParam("salary") Integer salary) {
        try {
            employeeService.updateByIdEmployee(id, name, salary);
        }catch (Throwable t){
            String message = "Нет такого id";
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,message);
        }
    }

    /**
     * GET возвращать информацию о сотруднике с переданным id
     */
    @GetMapping("{id}")
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
    @DeleteMapping("employee-delete/{id}")
    public void deleteIdEmployee(@PathVariable int id) {
        try {
            employeeService.deleteByIdEmployee(id);
        } catch (Throwable t) {
            String message = "Нет такого id";
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,message);

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
