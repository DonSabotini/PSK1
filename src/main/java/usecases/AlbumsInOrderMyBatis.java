package usecases;

import mybatis.model.Album;
import mybatis.model.Myorder;
import mybatis.model.Song;

import lombok.Getter;
import lombok.Setter;
import mybatis.dao.AlbumMapper;
import mybatis.dao.MyorderMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class AlbumsInOrderMyBatis implements Serializable {
    @Inject
    private AlbumMapper albumMapper;

    @Inject
    private MyorderMapper orderMapper;

    @Getter
    @Setter
    private Myorder order;

    @Getter @Setter
    private Song songToCreate = new Song();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer orderId = Integer.parseInt(requestParameters.get("orderId"));
        this.order = orderMapper.selectByPrimaryKey(orderId);
    }

    @Transactional
    public String addToOrder(Album album) {

        orderMapper.insertAlbumToOrder(order.getId(), album.getId());
        return "orderPage.xhtml?orderId=" + order.getId() +"&faces-redirect=true";
    }
    @Transactional
    public String removeFromOrder(Album album) {
        orderMapper.deleteAlbumFromOrder(album);


        return "orderPage.xhtml?orderId=" + order.getId() +"&faces-redirect=true";
    }
}
