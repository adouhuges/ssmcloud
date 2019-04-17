package adou.manager.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adou.common.pojo.SearchItem;
import adou.manager.mapper.TestItemMapper;
import adou.manager.mapper.TestUserMapper;
import adou.manager.pojo.TbUser;
import adou.manager.service.TestMybatisService;

@Service
public class TestMybatisServiceImpl implements TestMybatisService{

	@Autowired
	private TestItemMapper itemMapper;
	
	@Autowired
	private TestUserMapper userMapper;
	
	
//	public TbUser getUserById2(Long itemId) {
//		// TODO Auto-generated method stub
//		TbUser user=userMapper.getUserById2(itemId);
//		return user;
//	}

	
	
	
	
	@Override
	public SearchItem getItemById(Long itemId) {
		// TODO Auto-generated method stub
		SearchItem searchItem=itemMapper.getItemById(itemId);
		return searchItem;
	}





	@Override
	public List<TbUser> findUserByUserLikeName(String username) {
		// TODO Auto-generated method stub
		List<TbUser> userList=(List<TbUser>) userMapper.findUserByUserLikeName(username);
		return userList;
	}





	@Override
	public List<TbUser> findUserByUserLikeName2(TbUser user) {
		// TODO Auto-generated method stub
		List<TbUser> userList=(List<TbUser>)userMapper.findUserByUserLikeName2(user);
		return userList;
	}
	
}
