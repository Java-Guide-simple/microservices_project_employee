package in.stack.microservice.employee.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Employee_table")
@NoArgsConstructor
@AllArgsConstructor

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String designation;
    private String profile_pic;

}
