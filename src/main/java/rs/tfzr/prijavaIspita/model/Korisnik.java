package rs.tfzr.prijavaIspita.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="korisnik")
public class Korisnik extends BazniEntitet implements Serializable {

    @Column(name="korisnickoIme", nullable = false, unique = true)
    private String korisnickoIme;

    @Column(name="lozinka", nullable = false)
    private String lozinka;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="korisnikRola",
            joinColumns = @JoinColumn(name = "korisnikId"),
            inverseJoinColumns = @JoinColumn(name= "roleId"))
    private List<Role> role;

    public Korisnik(String korisnickoIme, String lozinka, List<Role> role) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.role = role;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
