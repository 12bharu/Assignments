package bookrecord.orm;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@DiscriminatorValue("ar")
@Entity
public class Article extends Book{
	
	private String articleurl;
	private String articlename;
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Article(String url, String name) {
		super();
		this.articleurl = url;
		this.articlename = name;
	}
	
	public String getUrl() {
		return articleurl;
	}
	public void setUrl(String url) {
		this.articleurl = url;
	}
	public String getName() {
		return articlename;
	}
	public void setName(String name) {
		this.articlename = name;
	}
	
	
	

}
