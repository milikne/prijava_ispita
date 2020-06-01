package rs.tfzr.prijavaIspita.repository;

import rs.tfzr.prijavaIspita.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
