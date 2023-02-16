package az.asl.payday.mapper;

import az.asl.payday.entity.Exam;
import az.asl.payday.model.ExamDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamMapper {

    List<ExamDto> entityListToDto(List<Exam> entities);
    List<Exam> dtoListToEntity(List<ExamDto> dtos);

    ExamDto entityToDto(Exam entity);
    Exam dtoToEntity(ExamDto dto);
}
