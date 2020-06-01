package rs.tfzr.prijavaIspita.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import rs.tfzr.prijavaIspita.model.AutentifikovanKorisnik;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class KorisnikController {

    @RequestMapping("korisnik")
    public AutentifikovanKorisnik getUser(Authentication authentication) {
        List<String> role = new ArrayList<>();
        for(GrantedAuthority authority : authentication.getAuthorities()) {
            role.add(authority.getAuthority());
        }
        AutentifikovanKorisnik korisnik = new AutentifikovanKorisnik(
                authentication.getName(), role);
        return korisnik;
    }
}
