package study.hry.spring.mybatis.springmybatis.multipledata.mapper.test1;

import study.hry.spring.mybatis.springmybatis.multipledata.model.test1.UsersTest1;

public interface UsersTest1Mapper {
    int insertSelective(UsersTest1 record);
    UsersTest1 selectByPrimaryKey(String userId);
}