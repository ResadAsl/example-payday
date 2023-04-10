package az.asl.payday.service.exam;

import az.asl.payday.entity.Exam;
import az.asl.payday.entity.Place;
import az.asl.payday.mapper.ExamMapper;
import az.asl.payday.model.ExamDto;
import az.asl.payday.repository.ExamRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService{



    private final ExamRepository repository;
    private final ExamMapper mapper;

    @PersistenceContext
    EntityManager entityManager;



    @Override
    public List<ExamDto> getAllPage(Integer page, Integer size) {
       Pageable pageable = PageRequest.of(page, size);
       Page<Exam> pages = repository.findAll(pageable);
       List<Exam> entities = pages.getContent();
       return mapper.entityListToDto(entities);
    }

    @Override
    public List<ExamDto> getAll() {
        List<Exam> exams = repository.findAllByOrderByIdAsc();
        return mapper.entityListToDto(exams);
    }

    @Override
    public ExamDto getById(Long id) {
        Exam exam = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        return mapper.entityToDto(exam);
    }

    @Override
    public ExamDto add(ExamDto dto) {
        Exam exam = mapper.dtoToEntity(dto);
        exam.getLesson().setExam(exam);
        Exam entity = repository.save(exam);
        return mapper.entityToDto(entity);
    }

    @Override
    public ExamDto update(Long id, ExamDto dto) {
        Exam exam = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        Exam entity = mapper.updateExamEntity(exam, dto);
        Exam ex = repository.save(entity);
        return mapper.entityToDto(ex);
    }

    @Override
    public void delete(Long id) {
        Exam exam = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        repository.delete(exam);
    }


    @Override
    public List<ExamDto> searchByCriteria(Long placeId) {

        CriteriaBuilder cb  = entityManager.getCriteriaBuilder();
        CriteriaQuery<ExamDto> query = cb.createQuery(ExamDto.class);
        Root<Exam> examRoot = query.from(Exam.class);
        Predicate predicate = cb.equal(examRoot.get("place"), new Place(placeId));
        query.multiselect(
                examRoot.get("id").alias("id"),
                examRoot.get("examDate").alias("examDate"),
                examRoot.get("lesson").get("id").alias("lessonId"),
                examRoot.get("place").get("id").alias("placeId")
                );
        query.where(predicate);
        TypedQuery<ExamDto> tq = entityManager.createQuery(query);

        return tq.getResultList();
    }
}
