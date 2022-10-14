package bookrecord.orm;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@DiscriminatorValue("bg")
@Entity
public class Blog extends Book{
	
	private String blogname;
	private String url;
	private long visitedNo;
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Blog(String name, String url, long visitedNo) {
		super();
		this.blogname = name;
		this.url = url;
		this.visitedNo = visitedNo;
	}

	public String getName() {
		return blogname;
	}
	public void setName(String name) {
		this.blogname = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getVisitedNo() {
		return visitedNo;
	}
	public void setVisitedNo(long visitedNo) {
		this.visitedNo = visitedNo;
	}
	
	

}
