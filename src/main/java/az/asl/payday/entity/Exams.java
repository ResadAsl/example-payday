package az.asl.payday.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public enum Exams {

     examName,

     monthly,
     semestr,
     finalExam;

     LocalDateTime examDate;

    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Students> students = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Places place;
}
