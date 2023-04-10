package az.asl.payday.service.group;


import az.asl.payday.model.GroupDto;

import java.util.List;

public interface GroupService {

    List<GroupDto> getAllPage(Integer page, Integer size);

    List<GroupDto> getAll();

    GroupDto getById(Long id);

    GroupDto add(GroupDto dto);

    GroupDto update(Long id, GroupDto dto);

    void delete(Long id);
}
