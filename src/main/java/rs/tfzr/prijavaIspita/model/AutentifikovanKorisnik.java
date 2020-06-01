package rs.tfzr.prijavaIspita.model;

import java.util.List;

public class AutentifikovanKorisnik {

    private String korisnickoIme;
    private List<String> role;

    public AutentifikovanKorisnik() {

    }

    public AutentifikovanKorisnik(String korisnickoIme, List<String> role) {
        this.korisnickoIme = korisnickoIme;
        this.role = role;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

}
