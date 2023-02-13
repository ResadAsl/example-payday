package az.asl.payday.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname", length = 100)
    private String surname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "course")
    private Short course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teachers teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    private Exams exam;

    @ManyToMany
    @JoinTable(name = "stud_less",
            joinColumns = {@JoinColumn(name = "p_lessons_id")},
            inverseJoinColumns = {@JoinColumn(name = "p_student_id")})
    private List<Lessons> lessons  =  new ArrayList<>();
}
