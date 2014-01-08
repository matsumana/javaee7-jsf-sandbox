package net.matsumana.sandbox.domain;

import net.matsumana.sandbox.dao.EmployeeDao;
import net.matsumana.sandbox.entity.Employee;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Date;

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

// create table employee (employee_id bigserial, employee_name varchar(64), file_bin bytea, version_no integer default 1, upd_dttm timestamp default current_timestamp);
// insert into employee (employee_name, file_bin) values ('Aさん', E'abc'), ('Bさん', E'abc'), ('Cさん', E'abc');

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
        employee.setFileBin(new byte[]{'a', 'b', 'c'});
        employee.setUpdDttm(new Date());
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
