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
@Table(name = "teachers")
@AllArgsConstructor
@NoArgsConstructor
public class Teachers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname", length = 100)
    private String surname;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade ={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Students> students = new ArrayList<>();

}
