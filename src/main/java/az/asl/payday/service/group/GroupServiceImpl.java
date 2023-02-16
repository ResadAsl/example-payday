package az.asl.payday.service.group;

import az.asl.payday.entity.Group;
import az.asl.payday.mapper.GroupMapper;
import az.asl.payday.model.GroupDto;
import az.asl.payday.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;
    private final GroupMapper mapper;


    @Override
    public List<GroupDto> getAll() {
        List<Group> groups = repository.findAll();
        List<GroupDto> dtos = mapper.entityListToDto(groups);
        return dtos;
    }

    @Override
    public GroupDto getById(Long id) {
        Group groups = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        GroupDto dto = mapper.entityToDto(groups);
        return dto;
    }

    @Override
    public GroupDto add(GroupDto dto) {
        Group groups = mapper.dtoToEntity(dto);
        Group entity = repository.save(groups);
        return mapper.entityToDto(entity);
    }

    @Override
    public GroupDto update(Long id, GroupDto dto) {
        Group groups = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        mapper.updateMapper(groups, dto);
        repository.save(groups);
        return mapper.entityToDto(groups);
    }

    @Override
    public GroupDto delete(Long id) {
        Group groups = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        repository.delete(groups);
        GroupDto dto = mapper.entityToDto(groups);
        return dto;
    }
}
