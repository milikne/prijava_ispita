package rs.tfzr.prijavaIspita.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ispit")
public class Ispit extends BazniEntitet{

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "predmetId")
    private Predmet predmet;

    @JoinColumn(name = "rokId")
    @ManyToOne(cascade = CascadeType.ALL)
    private Rok rok;

    @Column(name="datum", nullable = false, unique = false)
    private Date datum;

    @Column(name="brojIzlazaka", nullable = false, unique = false)
    private Integer brojIzlazaka;

    @Column(name="polozen", nullable = false, unique = false)
    private Boolean polozen;

    @Column(name="ocena", nullable = false, unique = false)
    private Integer ocena;

    public Ispit(Predmet predmet, Rok rok, Date datum, Integer brojIzlazaka, Boolean polozen, Integer ocena) {
        this.predmet = predmet;
        this.rok = rok;
        this.datum = datum;
        this.brojIzlazaka = brojIzlazaka;
        this.polozen = polozen;
        this.ocena = ocena;
    }

    public Ispit() { }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Rok getRok() {
        return rok;
    }

    public void setRok(Rok rok) {
        this.rok = rok;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getBrojIzlazaka() {
        return brojIzlazaka;
    }

    public void setBrojIzlazaka(Integer brojIzlazaka) {
        this.brojIzlazaka = brojIzlazaka;
    }

    public Boolean getPolozen() {
        return polozen;
    }

    public void setPolozen(Boolean polozen) {
        this.polozen = polozen;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }
}
