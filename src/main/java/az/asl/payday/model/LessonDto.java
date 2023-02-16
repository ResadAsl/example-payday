package az.asl.payday.model;

import az.asl.payday.entity.Exam;
import az.asl.payday.entity.Group;
import az.asl.payday.entity.Student;
import az.asl.payday.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto {

    private Long id;

    private String history;

    private String math;

    private String physical;

    private String geography;

    private List<Student> students = new ArrayList<>();

    private Exam exams;

    private Teacher teachers;

    private List<Group> groups = new ArrayList<>();
}
