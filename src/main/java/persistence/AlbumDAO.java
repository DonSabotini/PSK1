package persistence;



import entities.Album;
import entities.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class AlbumDAO {
    @Inject
    private EntityManager em;

    public List<Album> loadAll() {
        return em.createNamedQuery("Album.findAll", Album.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Album findOne(Integer id) {
        return em.find(Album.class, id);
    }

    public Album update(Album album){
        return em.merge(album);
    }

    public void persist(Album album){
        this.em.persist(album);
    }

    public void remove(Album album){
        this.em.remove(album);
    }
}