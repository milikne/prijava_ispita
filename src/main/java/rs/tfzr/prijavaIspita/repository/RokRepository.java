package rs.tfzr.prijavaIspita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.tfzr.prijavaIspita.model.Rok;

@Repository
public interface RokRepository extends JpaRepository<Rok, Long> {
}
