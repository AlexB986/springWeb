package ru.skypro.lessons.springboot.springweb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.skypro.lessons.springboot.springweb.pojo.Employee;

public interface PagingEmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {

}
