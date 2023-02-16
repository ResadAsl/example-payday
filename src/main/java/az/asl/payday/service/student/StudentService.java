package az.asl.payday.service.student;

import az.asl.payday.model.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAll();

    StudentDto getById(Long id);

    StudentDto add(StudentDto dto);

    StudentDto update(Long id, StudentDto dto);

    StudentDto delete(Long id);
}
