package usecases;

import entities.Album;
import entities.Order;
import entities.Song;
import lombok.Getter;
import lombok.Setter;
import persistence.AlbumDAO;
import persistence.OrderDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
@Model
public class AlbumsInOrder implements Serializable {
    @Inject
    private AlbumDAO albumDAO;

    @Inject
    private OrderDAO orderDAO;

    @Getter
    @Setter
    private Order order;

    @Getter @Setter
    private Song songToCreate = new Song();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer orderId = Integer.parseInt(requestParameters.get("orderId"));
        this.order = orderDAO.findOne(orderId);
    }

    @Transactional
    public String addToOrder(Album album) {
        order.getAlbums().add(album);
        orderDAO.persist(order);
        return "orderPage.xhtml?orderId=" + order.getId() +"&faces-redirect=true";
    }
    @Transactional
    public String removeFromOrder(Album album) {
        order.getAlbums().remove(album);
        orderDAO.persist(order);
        return "orderPage.xhtml?orderId=" + order.getId() +"&faces-redirect=true";
    }


}
