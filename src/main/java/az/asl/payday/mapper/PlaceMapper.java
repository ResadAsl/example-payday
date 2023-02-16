package az.asl.payday.mapper;

import az.asl.payday.entity.Place;
import az.asl.payday.model.PlaceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaceMapper {

    List<PlaceDto> entityListToDto(List<Place> entities);
    List<Place> dtoListToEntity(List<PlaceDto> dtos);

    PlaceDto entityToDto(Place entity);
    Place dtoToEntity(PlaceDto dto);
}
