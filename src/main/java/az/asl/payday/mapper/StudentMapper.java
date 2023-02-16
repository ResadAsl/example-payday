package az.asl.payday.mapper;

import az.asl.payday.entity.Group;
import az.asl.payday.entity.Student;
import az.asl.payday.model.GroupDto;
import az.asl.payday.model.StudentDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    public abstract List<StudentDto> entityListToDto(List<Student> entities);
    public abstract List<Student> dtoListToEntity(List<StudentDto> dtos);

    @Mapping(source = "group", target = "groupId", qualifiedByName = "entityToGroupId")
    public abstract StudentDto entityToDto(Student entity);

    @Named("entityToGroupId")
    Long ToDto(Group group){
        return group.getId() != null ? group.getId() : null;
    }

    @Mapping(source = "groupId", target = "group", qualifiedByName = "groupIdToEntity")
    public abstract Student dtoToEntity(StudentDto dto);

    @Named("groupIdToEntity")
    Group ToEntity(Long id){
        return id != null ? new Group(id) : null;
    }


    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "groupId", target = "group", qualifiedByName = "groupIdToEntity")
    public abstract Student updateStEntity(@MappingTarget Student entity, StudentDto dto);
}
