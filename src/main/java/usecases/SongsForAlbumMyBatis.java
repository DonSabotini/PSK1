package usecases;


import lombok.Getter;
import lombok.Setter;
import mybatis.dao.AlbumMapper;
import mybatis.dao.SongMapper;
import mybatis.model.Album;
import mybatis.model.Song;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class SongsForAlbumMyBatis {


    @Inject
    private AlbumMapper albumMapper;

    @Inject
    private SongMapper songMapper;

    @Getter
    @Setter
    private Album album;

    @Getter @Setter
    private Song songToCreate = new Song();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer albumId = Integer.parseInt(requestParameters.get("albumId"));
        this.album = albumMapper.selectByPrimaryKey(albumId);
    }

    @Transactional
    public String createSong() {
        songToCreate.setAlbumId(album.getId());
        songMapper.insert(songToCreate);
        return "albums.xhtml?albumId=" + album.getId() +"&faces-redirect=true";
    }

    @Transactional
    public String removeSong(Song song){
        songMapper.deleteByPrimaryKey(song.getId());
        return "albums.xhtml?albumId=" + album.getId() +"&faces-redirect=true";
    }

    @Transactional
    public String updateAlbum(){
        albumMapper.updateByPrimaryKey(album);
        return "albums.xhtml?albumId=" + album.getId() +"&faces-redirect=true";
    }






}
