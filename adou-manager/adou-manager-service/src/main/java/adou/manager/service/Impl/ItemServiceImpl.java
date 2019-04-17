package adou.manager.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import adou.common.pojo.EasyUIDataGridResult;
import adou.common.utils.E3Result;
import adou.common.utils.IDUtils;
import adou.manager.mapper.TbItemDescMapper;
import adou.manager.mapper.TbItemMapper;
import adou.manager.pojo.TbItem;
import adou.manager.pojo.TbItemDesc;
import adou.manager.pojo.TbItemExample;
import adou.manager.pojo.TbItemExample.Criteria;
import adou.manager.service.ItemService;




//商品管理service

@Service
public class ItemServiceImpl implements ItemService {
	
		@Autowired
		private TbItemMapper itemMapper;
		
		@Autowired
		private TbItemDescMapper itemDescMapper;
		
		
		@Override
		public TbItem getItemById(long itemId) {
			// TODO Auto-generated method stub
		
			  TbItemExample example =new TbItemExample();
			  Criteria criteria=example.createCriteria();
			  // 设置查询条件
			  criteria.andIdEqualTo(itemId);
			  List<TbItem> list=itemMapper.selectByExample(example);
			return list.get(0);			
//			TbItem item=itemMapper.selectByPrimaryKey(itemId);

		}
			

		/**
		 *            显示所有的产品信息  使用分页插件
		 */
		public EasyUIDataGridResult getItemList(int page,int rows)
		{
//			// 查询jdies里是否有数据
//			try{
//				String json=jedisClient.hget(PRODUCT_LIST, "产品信息");
//				if(StringUtils.isNoneBlank(json))
//				{
//					List<TbItem> list=JsonUtils.jsonToList(json,TbItem.class);
//					
//					EasyUIDataGridResult result =new EasyUIDataGridResult();
//					result.setRows(list); //  result里面有List 成员变量。可以把这个list复制过去。
//						
//					PageInfo<TbItem> pageInfo=new PageInfo<>(list);
//					long total=pageInfo.getTotal();
//					result.setTotal(total);
//					
//					
//					return result;
//				}
//			}catch(Exception e)
//			{
//				e.printStackTrace();
//			}						
			//设置分页信息  执行查询  取分页信息
			PageHelper.startPage(page, rows); // 多少页，每页多少条信息。
			TbItemExample example=new TbItemExample();
			List<TbItem> list=itemMapper.selectByExample(example);
			
			//创建一个返回值对象
			EasyUIDataGridResult result =new EasyUIDataGridResult();
			result.setRows(list); //  result里面有List 成员变量。可以把这个list复制过去。
				
			PageInfo<TbItem> pageInfo=new PageInfo<>(list);
			long total=pageInfo.getTotal();
			result.setTotal(total);
			
			// 存入缓存
//			try{
//				jedisClient.hset(PRODUCT_LIST, "产品信息", JsonUtils.objectToJson(list));
//			}
//			catch(Exception e){
//				e.printStackTrace();
//			}
			return result;

		}


		@Override
		public E3Result addItem(TbItem item, String desc) {
			//生成商品id
			final long itemId=IDUtils.genItemId();
			//补全item属性
			item.setId(itemId);
			//1 正常 2下架 3删除
			item.setStatus((byte)1);
			item.setCreated(new Date());
			item.setUpdated(new Date());
			// 向商品表插入数据
			itemMapper.insert(item);
			// 创建一个商品描述表对应pojo
			TbItemDesc itemDesc=new TbItemDesc();
			
			// 补全属性
			itemDesc.setItemId(itemId);
			itemDesc.setItemDesc(desc);
			itemDesc.setCreated(new Date());
			itemDesc.setUpdated(new Date());
			
			// 向商品描述表插入数据  返回添加结果
			itemDescMapper.insert(itemDesc);
			
//			// 发送商品添加消息  参数传递id号即可，那边根据id查询数据库，添加到solr， 获取都传过去，直接添加到solr
//			jmsTemplate.send(topicDestination,new MessageCreator() {
//				
//				@Override
//				public Message createMessage(Session session) throws JMSException {
//					// TODO Auto-generated method stub
//					TextMessage textMessage=session.createTextMessage(itemId+"");
//					
//					return textMessage;
//				}
//			});	
			return E3Result.ok();	
			
			
		}


		@Override
		public TbItemDesc getItemDescById(Long itemId) {
			// TODO Auto-generated method stub
			return null;
		}
		

	

}
