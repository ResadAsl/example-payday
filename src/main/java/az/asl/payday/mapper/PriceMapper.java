package az.asl.payday.mapper;

import az.asl.payday.entity.Exam;
import az.asl.payday.entity.Price;
import az.asl.payday.entity.Student;
import az.asl.payday.enums.LetterValue;
import az.asl.payday.model.PriceDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PriceMapper {

    public abstract List<PriceDto> entityListToDto(List<Price> entities);
    public abstract List<Price> dtoListToEntity(List<PriceDto> dtos);

    @Mapping(source = "exam", target = "examId", qualifiedByName = "examIdToDto")
    @Mapping(source = "student", target = "studentId", qualifiedByName = "EntityToId")
    public abstract PriceDto entityToDto(Price entity);



    @Named("examIdToDto")
    Long examToDto(Exam exam){
        return exam.getId() != null ? exam.getId() : null;
    }

    @Named("EntityToId")
    Long toDto(Student student){
        return student.getId() != null ? student.getId() : null;
    }

    @Mapping(source = "value", target = "letterValue", qualifiedByName = "enumConvert")
    @Mapping(source = "examId", target = "exam", qualifiedByName = "dtoToExamId")
    @Mapping(source = "studentId", target = "student", qualifiedByName = "idToEntity")
    public abstract Price dtoToEntity(PriceDto dto);

    @Named("enumConvert")
    public LetterValue enumConvert(Short price) {
        if (price > 90) {
            return LetterValue.A;
        } else if (price > 80) {
            return LetterValue.B;
        } else if (price > 70) {
            return LetterValue.C;
        } else if (price > 60) {
            return LetterValue.D;
        }
        else {
            return LetterValue.E;
        }
    }


    @Named("dtoToExamId")
    Exam eToEntity(Long id){
        return id != null ? new Exam(id) : null;
    }

    @Named("idToEntity")
    Student toEntity(Long id){
        return id != null ? new Student(id) : null;
    }





    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "studentId", target = "student", qualifiedByName = "idToEntity")
    @Mapping(source = "examId", target = "exam", qualifiedByName = "dtoToExamId")
    public abstract Price updateMapper(@MappingTarget Price entity, PriceDto dto);
}
