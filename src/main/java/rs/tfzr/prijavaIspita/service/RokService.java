package rs.tfzr.prijavaIspita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.tfzr.prijavaIspita.model.Rok;
import rs.tfzr.prijavaIspita.repository.RokRepository;

import java.util.List;

@Service
public class RokService {
    private RokRepository rokRepository;

    @Autowired
    public RokService(RokRepository rokRepository) {
        this.rokRepository = rokRepository;
    }

    public List<Rok> findAll() {
        return rokRepository.findAll();
    }

    public Rok findOne(Long id) {
        return rokRepository.getOne(id);
    }

    public Rok save(Rok rok) {
        return rokRepository.save(rok);
    }

    public void delete(Long id) {
        rokRepository.deleteById(id);
    }

}
