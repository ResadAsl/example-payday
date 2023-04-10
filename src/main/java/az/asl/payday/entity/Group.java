package az.asl.payday.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String name;

    @ManyToMany
    @JoinTable(name = "group_lesson",
            joinColumns = {@JoinColumn(name = "lesson_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private List<Lesson> lessons = new ArrayList<>();

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "group", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Exam> exams = new ArrayList<>();



    public Group(Long groupId) {
        this.id = groupId;
    }

}
