package adou.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import adou.common.pojo.EasyUITreeNode;
import adou.manager.service.ItemCatService;

/**
 * 商品分类管理
 * @author lenovo
 *
 */

@Controller
public class ItemCatController {

	
	@Autowired
	private ItemCatService itemCatService;
	
	
	/**
	 * 调用服务查询节点列表
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(@RequestParam(name="id",defaultValue="0")Long parentId)
	{
		
		
		
		
		List<EasyUITreeNode> treeList=itemCatService.getItemCatList(parentId);
		return treeList;
	}
	
	/*
		@RequestMapping("/item/cat/list")
		@ResponseBody
		public List<EasyUITreeNode> getItemCatList(@RequestParam(name="id",defaultValue="0")Long parentId)
		{
			List<EasyUITreeNode> treeList=itemCatService.getItemCatList(parentId);
			return treeList;
		}	 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


















