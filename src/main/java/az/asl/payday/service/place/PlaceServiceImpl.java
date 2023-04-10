package az.asl.payday.service.place;

import az.asl.payday.entity.Place;
import az.asl.payday.mapper.PlaceMapper;
import az.asl.payday.model.PlaceDto;
import az.asl.payday.repository.PlaceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository repository;
    private final PlaceMapper mapper;


    @Override
    public List<PlaceDto> getAllPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Place> pages = repository.findAll(pageable);
        List<Place> entities = pages.getContent();
        return mapper.entityListToDto(entities);
    }

    @Override
    public List<PlaceDto> getAll() {
        List<Place> places = repository.findAllByOrderByIdAsc();
        return mapper.entityListToDto(places);
    }

    @Override
    public PlaceDto getById(Long id) {
        Place place = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        return mapper.entityToDto(place);
    }

    @Override
    public PlaceDto add(PlaceDto dto) {
        Place place = mapper.dtoToEntity(dto);
        Place entity = repository.save(place);
        return mapper.entityToDto(entity);
    }

    @Override
    public PlaceDto update(Long id, PlaceDto dto) {
        Place place = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        Place entity = mapper.updatePlaceEntity(place, dto);
        return mapper.entityToDto(entity);
    }

    @Override
    public void delete(Long id) {
        Place place = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found this id"));
        repository.delete(place);
    }





}
