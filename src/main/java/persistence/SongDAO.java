package persistence;




import entities.Album;
import entities.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@ApplicationScoped
public class SongDAO {
    @Inject
    private EntityManager em;

    public void persist(Song song){
        this.em.persist(song);
    }

    public Song findOne(Integer id){
        return em.find(Song.class, id);
    }

    public Song update(Song song){
        return em.merge(song);
    }
    public void remove(Song song){
        this.em.remove(song);
    }

}