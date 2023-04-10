package az.asl.payday.service.student;

import az.asl.payday.entity.Group;
import az.asl.payday.entity.Student;
import az.asl.payday.mapper.StudentMapper;
import az.asl.payday.model.StudentDto;
import az.asl.payday.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;


    @Override
    public List<StudentDto> getAllPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> pages = repository.findAll(pageable);
        List<Student> entities = pages.getContent();
        return mapper.entityListToDto(entities);
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = repository.findAllByOrderByIdAsc();
        List<StudentDto> dtos = mapper.entityListToDto(students);
        return dtos;
    }

    @Override
    public StudentDto getById(Long id) {
        Student students = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not Found This id"));
        StudentDto dto = mapper.entityToDto(students);
        return dto;
    }

    @Override
    public StudentDto add(StudentDto dto) {
        Student students = mapper.dtoToEntity(dto);
        students.setGroup(new Group(dto.getGroupId()));
        Student entity = repository.save(students);
        return mapper.entityToDto(entity);
    }

    @Override
    public StudentDto update(Long id, StudentDto dto) {
        Student students = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not Found This id"));
        Student entity = mapper.updateStEntity(students, dto);
        Student st = repository.save(entity);
        return mapper.entityToDto(st);
    }

    @Override
    public void delete(Long id) {
        Student students = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not Found This id"));
        repository.delete(students);
    }


    @Override
    public List<StudentDto> searchByName(String name) {
        List<Student> student = repository.getStudentByNameContainsIgnoreCase(name);
        return mapper.entityListToDto(student);
    }
}
