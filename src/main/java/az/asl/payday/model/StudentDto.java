package az.asl.payday.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class StudentDto {

    private Long id;

    private String name;

    private String surname;

    private Integer age;

    private Short course;

    private Long groupId;
}
