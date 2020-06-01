package rs.tfzr.prijavaIspita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rs.tfzr.prijavaIspita.model.Korisnik;
import rs.tfzr.prijavaIspita.model.Role;
import rs.tfzr.prijavaIspita.repository.KorisnikRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class KorisnikService implements UserDetailsService {

    private KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikService(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String korisnickoIme) throws UsernameNotFoundException {
        try {
            Korisnik korisnik = korisnikRepository.findByKorisnickoIme(korisnickoIme);
            if (korisnik == null) {
                return null;
            }
            return new User(korisnik.getKorisnickoIme(), korisnik.getLozinka(), getAuthorities(korisnik));
        } catch (Exception e) {
            throw new UsernameNotFoundException("Korisnik nije pronadjen");
        }
    }

    private Set<GrantedAuthority> getAuthorities(Korisnik korisnik){
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Role role : korisnik.getRole()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getTipRole().toString());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }

}
