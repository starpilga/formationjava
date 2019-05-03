package bf.sonabel.dao;

import bf.sonabel.models.Patient;
import bf.sonabel.utils.ConnectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO extends GenericDAO<Patient>{

    public static void main(String[] args) {

        PatientDAO pdao = new PatientDAO();
        System.out.println(pdao.getPatientsHibernate());
        Patient p = new Patient ();
        p.setIdPatient(3L);
        p.setNomPatient("TOTO");
        p= pdao.savePatientHibernate(p);
         /*System.out.println(pdao.getPatientsHibernate());
       // pdao.deletePatientHibernate(p);
        System.out.println(pdao.getPatientsHibernate());*/
        System.out.println((ConnectionUtils.getEm().find(Patient.class, 2L)));
    }


    public List<Patient> getPatientsHibernate() {
        //return (List<Patient>) ConnectionUtils.getEm().createNativeQuery("Select * from Patients", Patient.class).getResultList();
        return (List<Patient>) ConnectionUtils.getEm().createQuery("from Patient p").getResultList();
    }
    /*public List<Patient> getPatients() {

        List<Patient> lstRetour = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ResultSet rs = ConnectionUtils.getConnection().executeQuery("Select * from Patients");

            while (rs.next()) {
                Patient p = new Patient();
                p.setIdPatient(rs.getLong(1));
                p.setNomPatient(rs.getString(2));
                lstRetour.add(p);
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return lstRetour;
    }





    public void deletePatient(Patient p) {
        //classX.remove(p);==> Hibernate
    }

    public void savePatient(Patient p ) {
        //classX.persist(p);

    }


    public void deletePatientHibernate(Patient p) {
        ConnectionUtils.getEm().getTransaction().begin();
        ConnectionUtils.getEm().remove(p);
        ConnectionUtils.getEm().getTransaction().commit();
    }

    public Patient savePatientHibernate(Patient p ) {
        ConnectionUtils.getEm().getTransaction().begin();
        ConnectionUtils.getEm().persist(p);
        ConnectionUtils.getEm().getTransaction().commit();
        return p;
    }

    public Patient updatePatientHibernate(Patient p ) {
        ConnectionUtils.getEm().getTransaction().begin();
        ConnectionUtils.getEm().merge(p);
        ConnectionUtils.getEm().getTransaction().commit();
        return p;
    }*/
}
