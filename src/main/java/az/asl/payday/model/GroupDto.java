package az.asl.payday.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class GroupDto {

    private Long id;


    private String name;
}
