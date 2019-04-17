package adou.manager.mapper;

import java.util.List;

import adou.manager.pojo.TbUser;

public interface TestUserMapper {

	//通过id查询用户
	//public TbUser getUserById2(long itemId);
	
	//通过用户名模糊查询
	public List<TbUser> findUserByUserLikeName(String username);
	//通过用户名模糊查询，防止sql语句注入
	public List<TbUser> findUserByUserLikeName2(TbUser user);
}
