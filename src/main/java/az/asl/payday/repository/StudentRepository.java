package az.asl.payday.repository;

import az.asl.payday.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByOrderByIdAsc();
    List<Student> getStudentByNameContainsIgnoreCase(String name);
}
