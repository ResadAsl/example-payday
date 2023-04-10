package az.asl.payday.service.lesson;

import az.asl.payday.model.LessonDto;

import java.util.List;

public interface LessonService {

    List<LessonDto> getAllPage(Integer page, Integer size);

    List<LessonDto> getAll();

    LessonDto getById(Long id);

    LessonDto add(LessonDto dto);

    LessonDto update(Long id, LessonDto dto);

    void delete(Long id);
}
