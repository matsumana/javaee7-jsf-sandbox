package net.matsumana.sandbox.dao;

import net.matsumana.sandbox.entity.Employee;
import net.matsumana.sandbox.infra.DaoConfig;
import net.matsumana.sandbox.infra.DomaConfig;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;

@Dao(config = DomaConfig.class)
@DaoConfig
public interface EmployeeDao {
    @Select
    Employee selectByEmployeeId(Integer employeeId);

    @Insert
    int insert(Employee employee);
}
