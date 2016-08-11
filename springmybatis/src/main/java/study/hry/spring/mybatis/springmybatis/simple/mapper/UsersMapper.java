package study.hry.spring.mybatis.springmybatis.simple.mapper;

import study.hry.spring.mybatis.springmybatis.simple.model.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(String userId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}