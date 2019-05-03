package bf.sonabel.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Commande {
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Commandes_Produits",  joinColumns = {
            @JoinColumn(name = "idCommande", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "idProduit",
                    nullable = false, updatable = false) })
    Set<Produit> lstPdt;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCommande;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Produit> getLstPdt() {
        return lstPdt;
    }

    public void setLstPdt(Set<Produit> lstPdt) {
        this.lstPdt = lstPdt;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }
}
