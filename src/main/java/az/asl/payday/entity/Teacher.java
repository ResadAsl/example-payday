package az.asl.payday.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname", length = 100)
    private String surname;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Lesson> lessons = new ArrayList<>();

    public Teacher(Long id) {
        this.id = id;
    }
}
