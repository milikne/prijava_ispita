package rs.tfzr.prijavaIspita.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.tfzr.prijavaIspita.model.Rok;
import rs.tfzr.prijavaIspita.service.RokService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rokovi")
@CrossOrigin(origins = "http://localhost:4200")
public class RokController {
    private RokService rokService;

    @Autowired
    public RokController(RokService rokService) {
        this.rokService = rokService;
    }

    @PreAuthorize("hasAnyRole('ZAPOSLENI', 'STUDENT')")
    @RequestMapping(method = RequestMethod.GET)
    public List<Rok> findAll() {
        return rokService.findAll();
    }

    @PreAuthorize("hasAnyRole('ZAPOSLENI', 'STUDENT')")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findOne(@PathVariable("id") Long id) {
        Rok rok = rokService.findOne(id);
        if(rok == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(rok, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ZAPOSLENI')")
    @RequestMapping(method = RequestMethod.POST)
    public Rok save(@Valid @RequestBody Rok rok) {
        return rokService.save(rok);
    }

    @PreAuthorize("hasRole('ZAPOSLENI')")
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        rokService.delete(id);
    }

    @PreAuthorize("hasRole('ZAPOSLENI')")
    @RequestMapping(method = RequestMethod.PUT)
    public Rok update(@Valid @RequestBody Rok rok) {
        return rokService.save(rok);
    }
}


