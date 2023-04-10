package az.asl.payday.mapper;

import az.asl.payday.entity.Teacher;
import az.asl.payday.model.TeacherDto;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TeacherMapper {


    @Autowired
    private  LessonMapper mapper;

    public abstract List<TeacherDto> entityListToDto(List<Teacher> entities);
    public abstract List<Teacher> dtoListToEntity(List<TeacherDto> dtos);


    public abstract TeacherDto teacherEntityToDto(Teacher teacher);
    public abstract Teacher teacherDtoToEntity(TeacherDto dto);


    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    public abstract Teacher updateTeacher(@MappingTarget Teacher entity, TeacherDto dto);
}
