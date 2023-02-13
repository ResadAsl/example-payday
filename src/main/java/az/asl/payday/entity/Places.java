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
@Table(name = "places")
@AllArgsConstructor
@NoArgsConstructor
public class Places {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "corpus")
    private String corpus;

    @Column(name = "room")
    private Integer room;

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Exams> exams = new ArrayList<>();
}
