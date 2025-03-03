package generator.mapper;

import generator.com.xinpo.pojo.TEmp;

/**
* @author Yzm
* @description 针对表【t_emp】的数据库操作Mapper
* @createDate 2025-02-28 13:53:35
* @Entity generator.com.xinpo.pojo.TEmp
*/
public interface TEmpMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TEmp record);

    int insertSelective(TEmp record);

    TEmp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TEmp record);

    int updateByPrimaryKey(TEmp record);

}
