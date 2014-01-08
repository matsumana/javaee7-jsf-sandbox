package net.matsumana.sandbox.domain;

import net.matsumana.sandbox.dao.EmployeeDao;
import net.matsumana.sandbox.entity.Employee;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RequestScoped
public class ListDomain {

    @Inject
    EmployeeDao employeeDao;

    @Inject
    private DataSource dataSource;

    public String init() {
        Employee employee = employeeDao.selectByEmployeeId(3);
        System.out.println(employee.getEmployeeName());

        String name = employee.getEmployeeName();

        // getConnectionすればするほどコネクションが貼られる。。。
//        Connection conn1 = null;
//        Connection conn2 = null;
//        try {
//            conn1 = dataSource.getConnection();
//            conn2 = dataSource.getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        return name;
    }

    public void create() {
        Employee employee = new Employee();
        employee.setEmployeeName("Hogeさん");
        employee.setVersionNo(1L);
        employeeDao.insert(employee);

        // 非チェック例外はちゃんとロールバックされる。
        // チェック例外でもロールバックされるようにした方が良い。
//        if (true) {
//            throw new RuntimeException("Fuga-!");
//        }

        // getConnectionすればするほどコネクションが貼られる。。。
//        Connection conn1 = null;
//        Connection conn2 = null;
//        try {
//            conn1 = dataSource.getConnection();
//            conn2 = dataSource.getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}
