package az.asl.payday.mapper;

import az.asl.payday.entity.Group;
import az.asl.payday.model.GroupDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    List<GroupDto> entityListToDto(List<Group> entities);
    List<Group> dtoListToEntity(List<GroupDto> dtos);

    GroupDto entityToDto(Group entity);
    Group dtoToEntity(GroupDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    Group updateMapper(@MappingTarget Group entity, GroupDto dto);
}
