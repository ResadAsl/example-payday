package az.asl.payday.service.price;

import az.asl.payday.entity.Price;
import az.asl.payday.mapper.PriceMapper;
import az.asl.payday.model.PriceDto;
import az.asl.payday.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository repository;
    private final PriceMapper mapper;


    @Override
    public List<PriceDto> getAllPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Price> pages = repository.findAll(pageable);
        List<Price> entities = pages.getContent();
        return mapper.entityListToDto(entities);
    }

    @Override
    public List<PriceDto> getAll() {
        List<Price> prices = repository.findAllByOrderByIdAsc();
        return mapper.entityListToDto(prices);
    }

    @Override
    public PriceDto getById(Long id) {
        Price price = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        return mapper.entityToDto(price);
    }

    @Override
    public PriceDto add(PriceDto dto) {
        Price price = mapper.dtoToEntity(dto);
        repository.save(price);
        return mapper.entityToDto(price);
    }

    @Override
    public PriceDto update(Long id, PriceDto dto) {
        Price price = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        Price entity = mapper.updateMapper(price, dto);
        Price pr = repository.save(entity);
        return mapper.entityToDto(pr);
    }

    @Override
    public void delete(Long id) {
        Price price = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        repository.delete(price);
    }
}
