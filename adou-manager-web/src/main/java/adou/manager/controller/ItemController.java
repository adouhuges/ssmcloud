package adou.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import adou.common.pojo.EasyUIDataGridResult;
import adou.manager.pojo.TbItem;
import adou.manager.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	/*
	'url':'item-add'}">新增商品</li>
	<li data-options="attributes:{'url':'item-list'}">查询商品</li>
	<li data-options="attributes:{'url':'item-param-list'}">规格参数</li>
*/
	
	/**
	 * 点击跳转相应的页面
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page)
	{
		return page;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page,Integer rows)
	{
		//从service获取的result
		EasyUIDataGridResult result=itemService.getItemList(page, rows);
		//补充从service中获取的result。
		//不需要补充了
		// @ResbonseBody 传递给界面
		return result;
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("/controller/{itemId}")
	public String showindex(@PathVariable Long itemId)
	{
		TbItem item=itemService.getItemById(itemId);
		System.out.println(item);
		
		return "index";
	}
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
}
