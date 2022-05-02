package entities;

import lombok.Getter;
import lombok.Setter;
import usecases.Albums;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Order.findAll", query = "select a from Order as a")
})
@Table(name = "MYORDER")
@Getter
@Setter
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DATE")
    private Date date;
    public Order() {
    }


    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "ordered_albums",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ALBUM_ID"))
    private List<Album> albums = new ArrayList<>();

}
