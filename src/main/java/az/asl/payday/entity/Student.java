package az.asl.payday.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Transactional
//@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname", length = 100)
    private String surname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "course")
    private Short course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "student", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Price> prices = new ArrayList<>();

    public Student(Long id) {
       this.id = id;
    }
}
