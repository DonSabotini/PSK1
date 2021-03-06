package mybatis.dao;

import java.util.List;

import mybatis.model.Album;
import mybatis.model.Myorder;
import org.mybatis.cdi.Mapper;

@Mapper
public interface MyorderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MYORDER
     *
     * @mbg.generated Mon May 02 19:03:51 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MYORDER
     *
     * @mbg.generated Mon May 02 19:03:51 EEST 2022
     */
    int insert(Myorder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MYORDER
     *
     * @mbg.generated Mon May 02 19:03:51 EEST 2022
     */
    Myorder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MYORDER
     *
     * @mbg.generated Mon May 02 19:03:51 EEST 2022
     */
    List<Myorder> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MYORDER
     *
     * @mbg.generated Mon May 02 19:03:51 EEST 2022
     */
    int updateByPrimaryKey(Myorder record);

    int deleteAlbumFromOrder(Album record);

    void insertAlbumToOrder(Integer order_id, Integer album_id);

    void deleteFromOrderedAlbums(Integer id);
}