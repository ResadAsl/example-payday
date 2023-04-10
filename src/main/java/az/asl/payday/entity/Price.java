package az.asl.payday.entity;

import az.asl.payday.enums.LetterValue;
import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Type;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "price")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private Short value;

    @Enumerated(EnumType.STRING)
    private LetterValue letterValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;
}
