package az.asl.payday.service.price;

import az.asl.payday.model.PriceDto;

import java.util.List;

public interface PriceService {

    List<PriceDto> getAllPage(Integer page, Integer size);

    List<PriceDto> getAll();

    PriceDto getById(Long id);

    PriceDto add(PriceDto dto);

    PriceDto update(Long id, PriceDto dto);

    void delete(Long id);
}
