package adou.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import adou.common.pojo.SearchItem;
import adou.common.utils.JsonUtils;
import adou.manager.pojo.TbUser;
import adou.manager.service.TestMybatisService;



@Controller
public class TestMybatisController {

	@Autowired
	private TestMybatisService testMybatisService;
		
//	@RequestMapping("/ad")
//	@ResponseBody
//	public String  testmy()
//	{
////		SearchItem searchItem=TestMybatisService.getItemById((long)562379);
////		System.out.println(searchItem);
//		Long itemId=(long) 2;
//		//TbUser user=testMybatisService.getUserById2(itemId);
//		//String str=JsonUtils.objectToJson(user);
//		//return str; 
//	}	
	@RequestMapping("/ad2")
	@ResponseBody
	public String  testmy2()
	{
//		SearchItem searchItem=TestMybatisService.getItemById((long)562379);
//		System.out.println(searchItem);
		Long itemId=(long) 562379;
		SearchItem item=testMybatisService.getItemById(itemId);
		String str=JsonUtils.objectToJson(item);
		return str; 
	}
	@RequestMapping("/ad3")
	@ResponseBody
	public String  testmy3()
	{
		List<TbUser> userList=testMybatisService.findUserByUserLikeName("g");
		TbUser user=new TbUser();
		user.setUsername("g");
		List<TbUser> userList2=testMybatisService.findUserByUserLikeName2(user);
		String str=JsonUtils.objectToJson(userList);
		String str2=JsonUtils.objectToJson(userList2);
		System.out.println(str);
		System.out.println(/**************************/);
		
		System.out.println(str2);
		return str; 
	}
	
	
}
