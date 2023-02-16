package az.asl.payday.model;

import az.asl.payday.entity.Lesson;
import az.asl.payday.entity.Place;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamDto {

    private Long id;

    private String examName;

    private LocalDateTime examDate;

    private Place places;

    private List<Lesson> lessons = new ArrayList<>();
}
