package net.matsumana.sandbox.dao;

import net.matsumana.sandbox.entity.Employee;
import net.matsumana.sandbox.infra.DomaConfig;
import org.seasar.doma.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Dao(config = DomaConfig.class)
@AnnotateWith(annotations = {
//        @Annotation(type = Singleton.class, target = AnnotationTarget.CLASS),
        @Annotation(type = RequestScoped.class, target = AnnotationTarget.CLASS),
        @Annotation(type = Inject.class, target = AnnotationTarget.CONSTRUCTOR)
})
public interface EmployeeDao {
    @Select
    Employee selectByEmployeeId(Integer employeeId);

    @Insert
    int insert(Employee employee);
}
