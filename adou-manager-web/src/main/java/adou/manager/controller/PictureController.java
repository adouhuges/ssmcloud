package adou.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import adou.common.utils.FastDFSClient;
import adou.common.utils.JsonUtils;



/**
 * 图片上传Controller
 * @author lenovo
 *
 */




@Controller
public class PictureController {


	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;

	//图片上传好了，获取服务器中图片的地址，拼成长串。赋值给页面的一个变量，点击商品提交时，在传递到后台服务器商存储。
	@RequestMapping("/pic/upload")
	@ResponseBody  // 返回json数据，可以返回pojo，也可以返回map。 那个方便返回什么
	public String uploadFile(MultipartFile uploadFile)
	{	
		try {
			//把图片传到图片服务器
			FastDFSClient fastDFSClient =new FastDFSClient("classpath:conf/client.conf");
			//取文件扩展名
			String originalFilename=uploadFile.getOriginalFilename();
			String extendName=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			//得到一个图片的地址和文件名
			String url=fastDFSClient.uploadFile(uploadFile.getBytes(),extendName);
			//补充为完整的url
			url=IMAGE_SERVER_URL+url;
			//封装map中返回到
			Map result=new HashMap<>();
			result.put("error", 0);
			result.put("url", url);
			String str=JsonUtils.objectToJson(result);
			return str;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map result=new HashMap<>();
			result.put("error", 1);
			result.put("message","图片上传失败");
			String str=JsonUtils.objectToJson(result);
			return str;	
		}
	}
}










