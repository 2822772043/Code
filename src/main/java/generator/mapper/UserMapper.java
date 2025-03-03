package generator.mapper;

import generator.com.xinpo.pojo.User;

/**
* @author Yzm
* @description 针对表【user】的数据库操作Mapper
* @createDate 2025-02-28 13:55:56
* @Entity generator.com.xinpo.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
