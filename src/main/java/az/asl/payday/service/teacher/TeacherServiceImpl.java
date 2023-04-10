package az.asl.payday.service.teacher;

import az.asl.payday.entity.Teacher;
import az.asl.payday.mapper.TeacherMapper;
import az.asl.payday.model.TeacherDto;
import az.asl.payday.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository repository;
    private final TeacherMapper mapper;

    @Override
    public List<TeacherDto> getAllPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Teacher> pages = repository.findAll(pageable);
        List<Teacher> entities = pages.getContent();
        return mapper.entityListToDto(entities);
    }

    @Override
    public List<TeacherDto> getAll() {
        List<Teacher> teachers = repository.findAllByOrderByIdAsc();
        return mapper.entityListToDto(teachers);
    }

    @Override
    public TeacherDto getById(Long id) {
        Teacher teacher = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        return mapper.teacherEntityToDto(teacher);
    }

    @Override
    public TeacherDto add(TeacherDto dto) {
        Teacher teacher = mapper.teacherDtoToEntity(dto);
        Teacher entity = repository.save(teacher);
        return mapper.teacherEntityToDto(entity);
    }

    @Override
    public TeacherDto update(Long id, TeacherDto dto) {
        Teacher teacher = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        Teacher entity = mapper.updateTeacher(teacher, dto);
        Teacher tc = repository.save(entity);
        return mapper.teacherEntityToDto(tc);
    }

    @Override
    public void delete(Long id) {
        Teacher teacher = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        repository.delete(teacher);
    }
}
