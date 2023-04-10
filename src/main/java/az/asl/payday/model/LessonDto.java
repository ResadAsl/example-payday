package az.asl.payday.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonDto {

    private Long id;

    private String name;

    @NotNull
    private Long teacherId;
}
