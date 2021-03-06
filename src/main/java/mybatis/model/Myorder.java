package mybatis.model;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Myorder {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.MYORDER.ID
     *
     * @mbg.generated Mon May 02 19:03:51 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.MYORDER.DATE
     *
     * @mbg.generated Mon May 02 19:03:51 EEST 2022
     */
    private Date date;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.MYORDER.ID
     *
     * @return the value of PUBLIC.MYORDER.ID
     *
     * @mbg.generated Mon May 02 19:03:51 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.MYORDER.ID
     *
     * @param id the value for PUBLIC.MYORDER.ID
     *
     * @mbg.generated Mon May 02 19:03:51 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.MYORDER.DATE
     *
     * @return the value of PUBLIC.MYORDER.DATE
     *
     * @mbg.generated Mon May 02 19:03:51 EEST 2022
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.MYORDER.DATE
     *
     * @param date the value for PUBLIC.MYORDER.DATE
     *
     * @mbg.generated Mon May 02 19:03:51 EEST 2022
     */

    // Added manually
    public void setDate(Date date) {
        this.date = date;
    }

    private List<Album> albums = new ArrayList<>();

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}