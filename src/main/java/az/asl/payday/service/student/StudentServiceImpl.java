package az.asl.payday.service.student;

import az.asl.payday.entity.Student;
import az.asl.payday.mapper.StudentMapper;
import az.asl.payday.model.StudentDto;
import az.asl.payday.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;


    @Override
    public List<StudentDto> getAll() {
        List<Student> students = repository.findAll();
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
        if (students.getGroup()!= null){

        }
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
    public StudentDto delete(Long id) {
        return null;
    }
}
