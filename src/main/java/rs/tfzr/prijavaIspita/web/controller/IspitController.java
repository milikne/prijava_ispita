package rs.tfzr.prijavaIspita.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.tfzr.prijavaIspita.model.Ispit;
import rs.tfzr.prijavaIspita.service.IspitService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ispiti")
@CrossOrigin(origins = "http://localhost:4200")
public class IspitController {

    private IspitService ispitService;

    @Autowired
    public IspitController(IspitService ispitService) {
        this.ispitService = ispitService;
    }

    @PreAuthorize("hasAnyRole('ZAPOSLENI', 'STUDENT')")
    @RequestMapping(method = RequestMethod.GET)
    public List<Ispit> findAll() {
        return ispitService.findAll();
    }

    @PreAuthorize("hasAnyRole('ZAPOSLENI', 'STUDENT')")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findOne(@PathVariable("id") Long id) {
        Ispit ispit = ispitService.findOne(id);
        if (ispit == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ispit, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ZAPOSLENI')")
    @RequestMapping(method = RequestMethod.POST)
    public Ispit save(@Valid @RequestBody Ispit ispit) {
        return ispitService.save(ispit);
    }

    @PreAuthorize("hasRole('ZAPOSLENI')")
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        ispitService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ZAPOSLENI')")
    @RequestMapping(method = RequestMethod.PUT)
    public Ispit put(@Valid @RequestBody Ispit ispit) {
        return ispitService.save(ispit);
    }
}
