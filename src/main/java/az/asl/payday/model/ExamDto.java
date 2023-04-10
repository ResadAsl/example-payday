package az.asl.payday.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamDto {

    private Long id;

    private LocalDateTime examDate;

    @NotNull
    private Long lessonId;

    @NotNull
    private Long placeId;


}
