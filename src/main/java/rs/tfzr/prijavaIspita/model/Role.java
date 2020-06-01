package rs.tfzr.prijavaIspita.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends BazniEntitet  {

    @Enumerated(EnumType.STRING)
    private TipRole tipRole;

    public TipRole getTipRole() {
        return tipRole;
    }

    public void setTipRole(TipRole tipRole) {
        this.tipRole = tipRole;
    }

    public enum TipRole {
        ZAPOSLENI,
        STUDENT;


    }
}
//NEAUTORIZOVAN("NEAUTORIZOVAN");