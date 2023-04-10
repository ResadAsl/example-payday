package az.asl.payday.service.lesson;

import az.asl.payday.entity.Lesson;
import az.asl.payday.mapper.LessonMapper;
import az.asl.payday.model.LessonDto;
import az.asl.payday.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository repository;
    private final LessonMapper mapper;


    @Override
    public List<LessonDto> getAllPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Lesson> pages = repository.findAll(pageable);
        List<Lesson> entities = pages.getContent();
        return mapper.entityListToDto(entities);
    }

    @Override
    public List<LessonDto> getAll() {
        List<Lesson> lessons = repository.findAllByOrderByIdAsc();
        return mapper.entityListToDto(lessons);
    }

    @Override
    public LessonDto getById(Long id) {
        Lesson lesson = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        return mapper.lessonEntityToDto(lesson);
    }

    @Override
    public LessonDto add(LessonDto dto) {
        Lesson lesson = mapper.lessonDtoToEntity(dto);
        Lesson entity = repository.save(lesson);
        return mapper.lessonEntityToDto(entity);
    }

    @Override
    public LessonDto update(Long id, LessonDto dto) {
        Lesson lesson = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        Lesson entity = mapper.updateMapper(lesson, dto);
        Lesson less = repository.save(entity);
        return mapper.lessonEntityToDto(less);
    }

    @Override
    public void delete(Long id) {
        Lesson lesson = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        repository.delete(lesson);
    }
}
