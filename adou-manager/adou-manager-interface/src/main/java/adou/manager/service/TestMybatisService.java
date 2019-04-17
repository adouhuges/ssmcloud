package adou.manager.service;

import java.util.List;

import adou.common.pojo.SearchItem;
import adou.manager.pojo.TbUser;

public interface TestMybatisService {
	//public TbUser getUserById2(Long itemId);
	public SearchItem getItemById(Long itemId);
	public List<TbUser> findUserByUserLikeName(String username);
	public List<TbUser> findUserByUserLikeName2(TbUser user);
}
