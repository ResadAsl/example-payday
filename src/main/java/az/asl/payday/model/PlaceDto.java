package az.asl.payday.model;

import az.asl.payday.entity.Exam;
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
public class PlaceDto {

    private Long id;

    private String corpus;

    private Integer room;

    private List<Exam> exams = new ArrayList<>();
}
