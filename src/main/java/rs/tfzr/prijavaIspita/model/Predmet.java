package rs.tfzr.prijavaIspita.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="predmet")
public class Predmet extends BazniEntitet {

    public Predmet(String naziv, String profesor, String ects, String oznaka) {
        this.naziv = naziv;
        this.profesor = profesor;
        this.ects = ects;
        this.oznaka = oznaka;
    }

    public Predmet() {
    }

    @Column(name="naziv", nullable = false, unique = true)
    private String naziv;

    @Column(name="profesor", nullable = false, unique = false)
    private String profesor;

    @Column(name="ects", nullable = false, unique = false)
    private String ects;

    @Column(name="oznaka", nullable = false, unique = true)
    private String oznaka;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getEcts() {
        return ects;
    }

    public void setEcts(String ects) {
        this.ects = ects;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }
}
