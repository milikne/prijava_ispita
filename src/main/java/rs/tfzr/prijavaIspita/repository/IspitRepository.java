package rs.tfzr.prijavaIspita.repository;

import rs.tfzr.prijavaIspita.model.Ispit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IspitRepository extends JpaRepository<Ispit, Long> {
}
