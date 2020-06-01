package rs.tfzr.prijavaIspita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.tfzr.prijavaIspita.model.Ispit;
import rs.tfzr.prijavaIspita.repository.IspitRepository;

import java.util.List;

@Service
public class IspitService {
    private IspitRepository ispitRepository;

    @Autowired
    public IspitService(IspitRepository ispitRepository) {
        this.ispitRepository = ispitRepository;
    }

    public List<Ispit> findAll() {
        return ispitRepository.findAll();
    }

    public Ispit findOne(Long id) {
        return ispitRepository.getOne(id);
    }

    public Ispit save(Ispit ispit) {
        return ispitRepository.save(ispit);
    }

    public void delete(Long id) {
        ispitRepository.deleteById(id);
    }
}
