package usecases;


import lombok.Getter;
import lombok.Setter;
import mybatis.dao.MyorderMapper;
import mybatis.model.Myorder;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Model
public class OrdersMyBatis {

    @Inject
    private MyorderMapper orderMapper;


    @Getter
    @Setter
    private Myorder orderToCreate = new Myorder();

    @Getter
    private List<Myorder> allOrders;

    @PostConstruct
    public void init(){
        loadAllAlbums();
    }

    @Transactional
    public String createOrder(){
        orderToCreate.setDate(new Date(System.currentTimeMillis()));
        orderMapper.insert(orderToCreate);
        return "index?faces-redirect=true";
    }
    @Transactional
    public String removeOrder(Myorder order){
        orderMapper.deleteFromOrderedAlbums(order.getId());
        orderMapper.deleteByPrimaryKey(order.getId());
        return "index?faces-redirect=true";
    }

    private void loadAllAlbums(){
        this.allOrders = orderMapper.selectAll();
    }
}
