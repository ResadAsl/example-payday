package az.asl.payday.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDto {

    private Long id;

    private String corpus;

    private Integer room;
}
