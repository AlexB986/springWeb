package ru.skypro.lessons.springboot.springweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.lessons.springboot.springweb.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.springweb.pojo.Employee;
import ru.skypro.lessons.springboot.springweb.service.EmployeeService;

import java.util.List;
import java.util.Optional;

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
    @PostMapping("/")
    public void mapAddEmployee(@RequestParam("id") Integer id,
                               @RequestParam("name") String name,
                               @RequestParam("salary") Integer salary){
            employeeService.addEmployee(new Employee(id, name, salary));
    }

    /**
     * PUT редактировать сотрудника с указанным id
     */

    @PutMapping("/{id}/{name}/{salary}")
    public void mapUpdateEmployee(@PathVariable Integer id,String name, Integer salary) {
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
    @GetMapping("/{id}/fullinfo")
    public Optional<Employee> mapGetBuIdEmployee(@PathVariable int id) {
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
    @DeleteMapping("/{id}")
    public void deleteIdEmployee(@PathVariable int id) {
        try {
            employeeService.deleteByIdEmployee(id);
        } catch (Throwable t) {
            String message = "Нет такого id";
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,message);

        }
    }

////////////////*
    /**
     * GET  возвращать самой высокой зарплатой
     */
    @GetMapping("withHighestSalary")
    public List<Employee> withHighestSalary(@RequestParam(value = "salary",required = false) Integer salary) {
        return employeeService.employeeHighSalary(salary);
    }

    /**
     * GET возвращать информацию о сотруднике с переданным position
     */
    @GetMapping("/employees?position=")
    public List<EmployeeFullInfo> GetBuIdEmployee(@RequestParam("position") String position) {
//        try {
            return employeeService.getBuPositionToEmployee(position);
//        } catch (Throwable t) {
//            String message = "Нет такого position";
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,message);
//        }
    }

    @GetMapping("/full")
    public List<EmployeeFullInfo>getFull(){return employeeService.getFull();}


}
