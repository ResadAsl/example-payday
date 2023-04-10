package az.asl.payday.service.exam;

import az.asl.payday.model.ExamDto;
import az.asl.payday.model.PlaceDto;

import java.util.List;

public interface ExamService {

    List<ExamDto> getAllPage(Integer page, Integer size);

    List<ExamDto> getAll();

    ExamDto getById(Long id);

    ExamDto add(ExamDto dto);

    ExamDto update(Long id, ExamDto dto);

    void delete(Long id);

    List<ExamDto> searchByCriteria(Long id);
}
