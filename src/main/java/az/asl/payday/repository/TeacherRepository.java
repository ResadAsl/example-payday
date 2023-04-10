package az.asl.payday.repository;

import az.asl.payday.entity.Exam;
import az.asl.payday.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByOrderByIdAsc();
}
