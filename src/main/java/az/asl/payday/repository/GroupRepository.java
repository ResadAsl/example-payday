package az.asl.payday.repository;

import az.asl.payday.entity.Exam;
import az.asl.payday.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findAllByOrderByIdAsc();
}
