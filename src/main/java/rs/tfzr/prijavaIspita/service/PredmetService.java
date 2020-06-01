package rs.tfzr.prijavaIspita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.tfzr.prijavaIspita.model.Predmet;
import rs.tfzr.prijavaIspita.repository.PredmetRepository;

import java.util.List;

@Service
public class PredmetService {
    private PredmetRepository predmetRepository;

    @Autowired
    public PredmetService(PredmetRepository predmetRepository) {
        this.predmetRepository = predmetRepository;
    }

    public List<Predmet> findAll() {
        return predmetRepository.findAll();
    }

    public Predmet findOne(Long id) {
        return predmetRepository.getOne(id);
    }

    public Predmet save(Predmet predmet) {
        return predmetRepository.save(predmet);
    }

    public void delete(Long id) {
        predmetRepository.deleteById(id);
    }
}
