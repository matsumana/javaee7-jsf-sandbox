package net.matsumana.sandbox.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name = "EMPLOYEE")
@Setter
@Getter
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
}
