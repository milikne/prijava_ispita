package rs.tfzr.prijavaIspita.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.tfzr.prijavaIspita.model.Predmet;
import rs.tfzr.prijavaIspita.service.PredmetService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/predmeti")
@CrossOrigin(origins = "http://localhost:4200")
public class PredmetController {

    private PredmetService predmetService;

    @Autowired
    public PredmetController(PredmetService predmetService) {
        this.predmetService = predmetService;
    }

    @PreAuthorize("hasAnyRole('ZAPOSLENI', 'STUDENT')")
    @RequestMapping(method = RequestMethod.GET)
    public List<Predmet> findAll() {
        return predmetService.findAll();
    }

    @PreAuthorize("hasAnyRole('ZAPOSLENI', 'STUDENT')")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findOne(@PathVariable("id") Long id) {
        Predmet predmet = predmetService.findOne(id);
        if (predmet == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(predmet, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ZAPOSLENI')")
    @RequestMapping(method = RequestMethod.POST)
    public Predmet save(@Valid @RequestBody Predmet predmet) {
        return predmetService.save(predmet);
    }

    @PreAuthorize("hasRole('ZAPOSLENI')")
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        predmetService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ZAPOSLENI')")
    @RequestMapping(method = RequestMethod.PUT)
    public Predmet put(@Valid @RequestBody Predmet predmet) {
        return predmetService.save(predmet);
    }
}
