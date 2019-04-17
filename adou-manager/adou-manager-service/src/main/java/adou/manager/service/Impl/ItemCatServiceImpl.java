package adou.manager.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adou.common.pojo.EasyUITreeNode;
import adou.manager.mapper.TbItemCatMapper;
import adou.manager.pojo.TbItemCat;
import adou.manager.pojo.TbItemCatExample;
import adou.manager.pojo.TbItemCatExample.Criteria;
import adou.manager.service.ItemCatService;



@Service
public class ItemCatServiceImpl implements ItemCatService{

	@Autowired
	private TbItemCatMapper itemCatMapper;
		
	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		// TODO Auto-generated method stub
		
		//根据parentId查询子节点列表
		TbItemCatExample example=new TbItemCatExample();
		Criteria criteria=example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list=itemCatMapper.selectByExample(example);
		//创建返回结果List		
		List<EasyUITreeNode> resultList=new ArrayList<>();
		//把列表转换成EasyUITreeNode列表	
		// 和前端沟通
		for(TbItemCat tbItemCat:list)
		{
			EasyUITreeNode node=new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"true");
			resultList.add(node);
		}
		return resultList;		
	}	
}
