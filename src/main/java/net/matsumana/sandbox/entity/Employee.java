package net.matsumana.sandbox.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name = "EMPLOYEE")
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequence = "employee_employee_id_seq")
    Integer employeeId;

    String employeeName;

    @Version
    Long versionNo;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Long getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }
}
