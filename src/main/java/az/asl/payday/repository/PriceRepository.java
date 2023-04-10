package az.asl.payday.repository;

import az.asl.payday.entity.Exam;
import az.asl.payday.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findAllByOrderByIdAsc();
}
