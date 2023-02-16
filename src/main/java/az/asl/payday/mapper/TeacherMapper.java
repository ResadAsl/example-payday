package az.asl.payday.mapper;

import az.asl.payday.entity.Teacher;
import az.asl.payday.model.TeacherDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    List<TeacherDto> entityListToDto(List<Teacher> entities);
    List<Teacher> dtoListToEntity(List<TeacherDto> dtos);

    TeacherDto entityToDto(Teacher entity);
    Teacher dtoToEntity(TeacherDto dto);
}
