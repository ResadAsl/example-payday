package az.asl.payday.model;

import az.asl.payday.enums.LetterValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {

    private Long id;

    private Short value;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LetterValue letterValue;

    @NotNull
    private Long studentId;

    @NotNull
    private Long examId;
}
