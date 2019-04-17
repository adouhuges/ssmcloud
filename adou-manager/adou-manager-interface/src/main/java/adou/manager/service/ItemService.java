package adou.manager.service;

import adou.common.pojo.EasyUIDataGridResult;
import adou.common.utils.E3Result;
import adou.manager.pojo.TbItem;
import adou.manager.pojo.TbItemDesc;

public interface ItemService {
	public TbItem getItemById(long itemId);
	public EasyUIDataGridResult getItemList(int page,int rows);
	public E3Result addItem(TbItem itrm,String desc);
	public TbItemDesc getItemDescById(Long itemId);
}
