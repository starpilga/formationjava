package bf.sonabel.dao;

import bf.sonabel.utils.ConnectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenericDAO<T> {

    private EntityManager em = ConnectionUtils.getEm();
    private Class<T> var;


    public List<T> getAll() {
        return em.createQuery("select x from "+ var.getSimpleName() + " x").getResultList();
    }


    /**public T getByID(T t) {
        return em.find(var.getClass(), t);
    }*/

    public T getByID(Long id) {
        return (T) em.find(var.getClass(), id.intValue());
    }

    public void deletePatientHibernate(T p) {

        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public T savePatientHibernate(T p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }

    public T updatePatientHibernate(T p) {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        return p;
    }
}
