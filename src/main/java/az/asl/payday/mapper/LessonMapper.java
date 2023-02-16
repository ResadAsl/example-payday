package az.asl.payday.mapper;

import az.asl.payday.entity.Lesson;
import az.asl.payday.model.LessonDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    List<LessonDto> entityListToDto(List<Lesson> entities);
    List<Lesson> dtoListToEntity(List<LessonDto> dtos);

    LessonDto entityToDto(Lesson entity);
    Lesson dtoToEntity(LessonDto dto);
}
