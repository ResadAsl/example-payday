package az.asl.payday.entity;

import az.asl.payday.enums.ExamEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "exam")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exam_date")
    private LocalDateTime examDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @OneToOne(mappedBy = "exam")
    private Price price;

    private ExamEnum examEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    public Exam(Long id) {
        this.id = id;
    }
}
