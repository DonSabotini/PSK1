package usecases;


import lombok.Getter;
import lombok.Setter;
import mybatis.dao.AlbumMapper;
import mybatis.dao.SongMapper;
import mybatis.model.Album;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
@Model
public class AlbumsMyBatis {
    @Inject
    private AlbumMapper albumMapper;

    @Inject
    private SongMapper songMapper;

    @Getter
    private List<Album> allAlbums;

    @Getter @Setter
    private Album albumToCreate = new Album();

    @PostConstruct
    public void init() {
        this.loadAllAlbums();
    }

    private void loadAllAlbums() {
        this.allAlbums = albumMapper.selectAll();
    }

    @Transactional
    public String createAlbum() {
        albumMapper.insert(albumToCreate);
        return "index?faces-redirect=true";
    }

    @Transactional
    public String removeAlbum(Album album){

        songMapper.deleteByAlbumID(album.getId());
        albumMapper.deleteFromOrderedAlbums(album.getId());
        albumMapper.deleteByPrimaryKey(album.getId());
        return "index?faces-redirect=true";
    }
}
