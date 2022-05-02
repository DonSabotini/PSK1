package usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import entities.Album;
import entities.Order;
import lombok.Getter;
import lombok.Setter;
import persistence.AlbumDAO;


@Model
public class Albums implements Serializable {
    @Inject
    private AlbumDAO albumsDAO;


    @Getter @Setter
    private Album albumToCreate = new Album();

    @Getter
    private List<Album> allAlbums;

    @PostConstruct
    public void init(){
        loadAllAlbums();
    }

    @Transactional
    public String createAlbum(){
        this.albumsDAO.persist(albumToCreate);
        return "index?faces-redirect=true";
    }
    @Transactional
    public String removeAlbum(Album album){
        for (Order order : album.getOrders()
             ) {
                order.getAlbums().remove(album);
        }
        albumsDAO.remove(album);
        return "index?faces-redirect=true";
    }


    private void loadAllAlbums(){
        this.allAlbums = albumsDAO.loadAll();
    }

}