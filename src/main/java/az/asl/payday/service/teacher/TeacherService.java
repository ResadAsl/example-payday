package az.asl.payday.service.teacher;

import az.asl.payday.model.TeacherDto;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> getAllPage(Integer page, Integer size);

    List<TeacherDto> getAll();

    TeacherDto getById(Long id);

    TeacherDto add(TeacherDto dto);

    TeacherDto update(Long id, TeacherDto dto);

    void delete(Long id);
}
