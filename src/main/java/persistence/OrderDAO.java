package persistence;

import entities.Album;
import entities.Order;
import entities.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
@ApplicationScoped
public class OrderDAO {
    @Inject
    private EntityManager em;

    public List<Order> loadAll() {
        return em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Order findOne(Integer id) {
        return em.find(Order.class, id);
    }

    public void persist(Order order){
        this.em.persist(order);
    }

    public Order update(Order order){
        return em.merge(order);
    }

    public void remove(Order order){
        this.em.remove(order);
    }

}

