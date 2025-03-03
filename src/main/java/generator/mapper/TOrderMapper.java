package generator.mapper;

import generator.com.xinpo.pojo.TOrder;

/**
* @author Yzm
* @description 针对表【t_order】的数据库操作Mapper
* @createDate 2025-02-28 13:51:50
* @Entity generator.com.xinpo.pojo.TOrder
*/
public interface TOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);

}
