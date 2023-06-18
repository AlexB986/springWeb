package ru.skypro.lessons.springboot.springweb.dto;

public class EmployeeFullInfo {
    private String name;
    private Integer salary;
    private String positionRole;

    public EmployeeFullInfo(String name, Integer salary, String positionRole) {
        this.name = name;
        this.salary = salary;
        this.positionRole = positionRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPositionRole() {
        return positionRole;
    }

    public void setPositionRole(String positionRole) {
        this.positionRole = positionRole;
    }
}
