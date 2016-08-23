package study.hry.spring.mybatis.springmybatis.multipledata.mapper.test2;

import study.hry.spring.mybatis.springmybatis.multipledata.model.test2.UsersTest2;

public interface UsersTest2Mapper {
    int insertSelective(UsersTest2 record);
    UsersTest2 selectByPrimaryKey(String userId);
}