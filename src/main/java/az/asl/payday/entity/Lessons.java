package az.asl.payday.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lessons")
@AllArgsConstructor
@NoArgsConstructor
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "history")
    private String history;

    @Column(name = "math")
    private String math;

    @Column(name = "physical")
    private String physical;

    @Column(name = "geography")
    private String geography;

    @ManyToMany(mappedBy = "lessons")
    private List<Students> students;
}
