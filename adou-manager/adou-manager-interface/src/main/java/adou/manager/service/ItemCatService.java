package adou.manager.service;

import java.util.List;

import adou.common.pojo.EasyUITreeNode;

public interface ItemCatService {

	public List<EasyUITreeNode> getItemCatList(long parentId);
}
