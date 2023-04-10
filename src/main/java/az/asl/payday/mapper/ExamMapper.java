package az.asl.payday.mapper;

import az.asl.payday.entity.Exam;
import az.asl.payday.entity.Group;
import az.asl.payday.entity.Lesson;
import az.asl.payday.entity.Place;
import az.asl.payday.model.ExamDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ExamMapper {

    public abstract List<ExamDto> entityListToDto(List<Exam> entities);
    public abstract List<Exam> dtoListToEntity(List<ExamDto> dtos);


    @Mapping(source = "place", target = "placeId", qualifiedByName = "placeIdToDto")
    @Mapping(source = "lesson", target = "lessonId", qualifiedByName = "lessEntityToDto")
    public abstract ExamDto entityToDto(Exam entity);


    @Named("placeIdToDto")
    Long placeToDto(Place place){
        return place.getId() != null ? place.getId() : null;
    }

    @Named("lessEntityToDto")
    Long toDto(Lesson lesson){
        return lesson.getId() != null ? lesson.getId() : null;
    }

    @Mapping(source = "placeId", target = "place", qualifiedByName = "placeDtoToId")
    @Mapping(source = "lessonId", target = "lesson", qualifiedByName = "lessDtoToEntity")
    public abstract Exam dtoToEntity(ExamDto dto);

    @Named("placeDtoToId")
    Place dtoToPlace(Long id){
        return id != null ? new Place(id) : null;
    }


    @Named("lessDtoToEntity")
    Lesson toEntity(Long id){
        return id != null ? new Lesson(id) : null;
    }

    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "lessonId", target = "lesson", qualifiedByName = "lessDtoToEntity")
    @Mapping(source = "placeId", target = "place", qualifiedByName = "placeDtoToId")
    public abstract Exam updateExamEntity(@MappingTarget Exam entity, ExamDto dto);

}
