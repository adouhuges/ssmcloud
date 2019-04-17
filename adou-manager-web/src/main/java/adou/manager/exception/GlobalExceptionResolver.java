package adou.manager.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import adou.common.utils.MailUtils;




/**
 * 全局异常处理器
 * @author lenovo
 *  dao 以及service 层出现了bug，往外抛，作用1： 事物回滚，数据库操作无效，
 *  作用2：回到controller层使用该全局异常处理器捕获，邮件通知通过。
 */

public class GlobalExceptionResolver implements HandlerExceptionResolver {

	
	private static final Logger logger=LoggerFactory.getLogger(GlobalExceptionResolver.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		//TODO Auto-generated method stub
		//进到该方法里，就已经发生了异常，会把异常pao给springmvc框架。 该框架会查看是否有全局异常处理器，如果有，交给其
	// 处理。
		//打印控制台
		exception.printStackTrace();
		// 写日志
		logger.debug("测试输出日志"); //级别最低
		logger.info("系统发生异常");
		logger.error("系统发生异常", exception);//  级别最高
		// 发邮件，发短信
		// 使用jmail工具包    jmail相当于邮箱的客户端， 说的仿佛很简单的样子。
		
		String emailMsg="注册成功，请点击下面的链接进行激活<a href='http://localhost:8083/active?activeCode='></a>";
		try{
			MailUtils.sendMail("a549007747@126.com", emailMsg);
			MailUtils.sendMail("549007747@qq.com", emailMsg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		// 发短信   使用第三方的webservice  没有什么技术含量  给你接口，例子，自己试着。 要花钱买短信
		// 显示一个友好错误页面
		ModelAndView model=new ModelAndView();
		// 视图解析器   webinf/jsp/error/exception.jsp
		model.setViewName("error/exception");
		
		return model;
	}

}
