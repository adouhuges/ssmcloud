package adou.manager.mapper;

import java.util.List;

import adou.common.pojo.SearchItem;



public interface TestItemMapper {

	
	// 从数据库中取出部分数据存在solr的索引库里，不需要所有的数据，所以不能用逆向工程。要自己写sql语句，获取自己需要的数据。
	public List<SearchItem> getItemList();
	
	//根据activemq发来的商品添加消息，根据发来的消息的参数，去数据库查找这个新添加的商品，然后添加到索引库里。
	public SearchItem getItemById(Long itemId);
}
