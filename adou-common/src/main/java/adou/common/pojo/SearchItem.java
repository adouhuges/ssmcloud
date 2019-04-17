package adou.common.pojo;

import java.io.Serializable;

public class SearchItem implements Serializable{

	private String	id;
	private String	title;
	private String	sell_point;
	private long	price;
	private String	image;
	private String	category_name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSell_point() {
		return sell_point;
	}
	public void setSell_point(String sell_point) {
		this.sell_point = sell_point;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long l) {
		this.price = l;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_nam) {
		this.category_name = category_nam;
	} 
	//该pojo没有image属性，用该pojo对象.images  则调用该getimages方法。 item.images[0]  就是调用该方法取返回的
	//第一个字符串
	public String[] getImages() {
		if (image != null && !"".equals(image)) {
			String[] strings = image.split(",");  //image以，号分割
			return strings;
		}
		return null;
	}
	
	
	
}
