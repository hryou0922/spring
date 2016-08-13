package study.hry.spring.mybatis.springmybatis.simple.mapper;

import java.util.List;

import study.hry.spring.mybatis.springmybatis.interceptor.page.Page;
import study.hry.spring.mybatis.springmybatis.simple.model.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(String userId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String userId);
    
    List<Users> queryList(Page<Users> page);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}