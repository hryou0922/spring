package study.hry.spring.mybatis.springmybatis.simple.service;

import study.hry.spring.mybatis.springmybatis.simple.model.Users;

public interface IUserService {
	void save(Users user);
	
	void saveThrowException(Users user);
}
