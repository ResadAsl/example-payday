package az.asl.payday.repository;

import az.asl.payday.entity.Exam;
import az.asl.payday.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAllByOrderByIdAsc();
}
