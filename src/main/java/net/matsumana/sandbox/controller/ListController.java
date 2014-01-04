package net.matsumana.sandbox.controller;

import net.matsumana.sandbox.dao.EmployeeDao;
import net.matsumana.sandbox.entity.Employee;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ListController implements Serializable {

    @Inject
    EmployeeDao employeeDao;

    String name;

    public String getName() {
        return name;
    }

    @PostConstruct
    public void init() {
        Employee employee = employeeDao.selectByEmployeeId(3);
        System.out.println(employee.getEmployeeName());
        name = employee.getEmployeeName();
    }
}
