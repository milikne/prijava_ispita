package rs.tfzr.prijavaIspita.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends BazniEntitet {

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Ispit> ispiti = new ArrayList<>();

    public Student(List<Ispit> ispiti, String studentIme, String pol, Date datumRodjenja, String adresa, String mestoStanovanja, String telefon, @Email String email) {
        this.ispiti = ispiti;
        this.studentIme = studentIme;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.adresa = adresa;
        this.mestoStanovanja = mestoStanovanja;
        this.telefon = telefon;
        this.email = email;
    }

    public Student() {
    }

    @Column(name = "studentIme", nullable = false, unique = false)
    private String studentIme;

    @Column(name = "pol", nullable = false, unique = false)
    private String pol;

    @Column(name = "datumRodjenja", nullable = false, unique = false)
    private Date datumRodjenja;

    @Column(name = "adresa", nullable = false, unique = false)
    private String adresa;

    @Column(name = "mestoStanovanja", nullable = false, unique = false)
    private String mestoStanovanja;

    @Column(name = "telefon", nullable = false, unique = false)
    private String telefon;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    public List<Ispit> getIspiti() {
        return ispiti;
    }

    public void setIspiti(List<Ispit> ispiti) {
        this.ispiti = ispiti;
    }

    public String getStudentIme() {
        return studentIme;
    }

    public void setStudentIme(String studentIme) {
        this.studentIme = studentIme;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMestoStanovanja() {
        return mestoStanovanja;
    }

    public void setMestoStanovanja(String mestoStanovanja) {
        this.mestoStanovanja = mestoStanovanja;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
