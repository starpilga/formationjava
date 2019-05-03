/**
 * La classe Patient
 * créé par : DevSonabel
 * date : 02/05/2019
 **/
package bf.sonabel.models;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private String nomPatient;
    private Date dateNaissance;

    public List<RDV> getLstRDV() {
        return lstRDV;
    }

    public void setLstRDV(List<RDV> lstRDV) {
        this.lstRDV = lstRDV;
    }

    @OneToMany
    @JoinColumn(name="idPatient")
    private List<RDV> lstRDV;

    @Column(name="adresseComplete")
    private String adresse;

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public Long getIdPatient() {
        return this.idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "idPatient=" + idPatient +
                ", nomPatient='" + nomPatient + '\'' +
                '}';
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}