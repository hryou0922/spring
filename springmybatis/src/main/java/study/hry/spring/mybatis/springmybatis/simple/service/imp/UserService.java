package study.hry.spring.mybatis.springmybatis.simple.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.hry.spring.mybatis.springmybatis.simple.mapper.UsersMapper;
import study.hry.spring.mybatis.springmybatis.simple.model.Users;
import study.hry.spring.mybatis.springmybatis.simple.service.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private UsersMapper usersMapper;
	
	public void save(Users user) {
		usersMapper.insertSelective(user);
	}

	public void saveThrowException(Users user) {
		System.out.println("添加记录，抛出异常，应该回滚 = " + user.getUserId());
		usersMapper.insertSelective(user);
		
		throw new RuntimeException("在事务里抛出异常，应该回滚操作");
	}

}
