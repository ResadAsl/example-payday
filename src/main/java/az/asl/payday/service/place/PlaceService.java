package az.asl.payday.service.place;

import az.asl.payday.model.PlaceDto;

import java.util.List;

public interface PlaceService {

    List<PlaceDto> getAllPage(Integer page, Integer size);

    List<PlaceDto> getAll();

    PlaceDto getById(Long id);

    PlaceDto add(PlaceDto dto);

    PlaceDto update(Long id, PlaceDto dto);

    void delete(Long id);
}
