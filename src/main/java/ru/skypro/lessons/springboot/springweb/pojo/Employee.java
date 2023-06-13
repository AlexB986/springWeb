package ru.skypro.lessons.springboot.springweb.pojo;

public class Employee {
    private Integer id;
    private String name;
    private Integer salary;
    public Employee(Integer id,String name,Integer salary){
        this.id=id;
        this.name = name;
        this.salary = salary;
    }
    public Integer getId(){return id;}
    public String getName(){return name;}
    public Integer getSalary(){return salary;}



    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "id=" + id +
               ", Имя' " + name + '\'' +
                ", Зарплата =" + salary +
                '}';
    }
}