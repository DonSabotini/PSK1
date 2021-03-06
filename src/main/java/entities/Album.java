package entities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
        import javax.validation.constraints.Size;
        import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Album.findAll", query = "select a from Album as a")
})
@Table(name = "ALBUM")
@Getter
@Setter
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME",unique=true,nullable = false)
    private String name;

    @Column(name = "PRICE",nullable = true)
    private double price;

    @OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE)
    private List<Song> songs = new ArrayList<>();

    public Album() {
    }

    @ManyToMany(mappedBy = "albums")
    private List<Order> orders = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) &&
                Objects.equals(name, album.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}