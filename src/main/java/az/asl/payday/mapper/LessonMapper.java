package az.asl.payday.mapper;

import az.asl.payday.entity.Lesson;
import az.asl.payday.entity.Teacher;
import az.asl.payday.model.LessonDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class LessonMapper {

    public abstract List<LessonDto> entityListToDto(List<Lesson> entities);
    public abstract List<Lesson> dtoListToEntity(List<LessonDto> dtos);

    @Mapping(source = "teacher", target = "teacherId", qualifiedByName = "entityToId")
    public abstract LessonDto lessonEntityToDto(Lesson entity);

    @Named("entityToId")
    Long toDto(Teacher teacher){
        return teacher.getId() != null ? teacher.getId() : null;
    }



    @Mapping(source = "teacherId", target = "teacher", qualifiedByName = "idToEntity")
    public abstract Lesson lessonDtoToEntity(LessonDto dto);

    @Named("idToEntity")
    Teacher toEntity(Long id){
        return id != null ? new Teacher(id) : null;
    }


    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "teacherId", target = "teacher", qualifiedByName = "idToEntity")
    public abstract Lesson updateMapper(@MappingTarget Lesson entity, LessonDto dto);
}
