package rs.tfzr.prijavaIspita.repository;

import rs.tfzr.prijavaIspita.model.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredmetRepository extends JpaRepository<Predmet, Long> {
}
