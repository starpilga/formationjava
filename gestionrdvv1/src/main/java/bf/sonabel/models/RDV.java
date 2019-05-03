/**
 * La classe Patient
 * créé par : DevSonabel
 * date : 02/05/2019
 **/
package bf.sonabel.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Rdvs")
public class RDV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRdv;
    private Date dateRDV;

    @ManyToOne
    //@JoinColumn(name="idPatient")
    private Patient patient;
    @ManyToOne
    //@JoinColumn(name="idMedecin")
    private Medecin medecin;

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Long getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(Long idRdv) {
        this.idRdv = idRdv;
    }
}