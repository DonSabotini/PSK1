package usecases;

import entities.Album;
import entities.Song;

import lombok.Getter;
import lombok.Setter;
import persistence.AlbumDAO;
import persistence.SongDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;
@Model
public class SongsForAlbum implements Serializable {
    @Inject
    private AlbumDAO albumDAO;

    @Inject
    private SongDAO songDAO;

    @Getter
    @Setter
    private Album album;

    @Getter @Setter
    private Song songToCreate = new Song();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer teamId = Integer.parseInt(requestParameters.get("albumId"));
        this.album = albumDAO.findOne(teamId);
    }

    @Transactional
    public String createSong() {
        songToCreate.setAlbum(this.album);
        songDAO.persist(songToCreate);
        return "albums.xhtml?albumId=" + album.getId() +"&faces-redirect=true";
    }

    @Transactional
    public String removeSong(Song song){
        songDAO.remove(song);
        return "albums.xhtml?albumId=" + album.getId() +"&faces-redirect=true";
    }

    @Transactional
    public String updateAlbum(){
        albumDAO.update(album);
        return "albums.xhtml?albumId=" + album.getId() +"&faces-redirect=true";
    }


}
