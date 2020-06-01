package rs.tfzr.prijavaIspita.repository;

import rs.tfzr.prijavaIspita.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    public Korisnik findByKorisnickoIme(String korisnickoime);
}
