package bf.sonabel.utils;

import org.hibernate.tuple.entity.EntityTuplizer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionUtils {


    private static EntityManager em;



    public static Statement getConnection() {
        Statement s = null;
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionrdv","root","");
            s= c.createStatement();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return s;

    }

    // Singleton
    public static EntityManager getEm() {
        if(em == null) {
            em = Persistence.createEntityManagerFactory("SONABELDB").createEntityManager();
        }
        return em;
    }

}
