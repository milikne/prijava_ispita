package rs.tfzr.prijavaIspita.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="rok")
public class Rok extends BazniEntitet {

    @Column
    private String naziv;

    public Rok(String naziv) {
        this.naziv = naziv;
    }

    public Rok() { }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
