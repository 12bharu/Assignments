package bookrecord.orm;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String publisherName;
	private String address;
	private long publisherPhone;
	@OneToMany(targetEntity=Book.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.LAZY,mappedBy="publisher")
	private Set<Book> book;
	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Publisher(String publisherName, String address, long publisherPhone) {
		super();
		this.publisherName = publisherName;
		this.address = address;
		this.publisherPhone = publisherPhone;
	}

	public Publisher(int id, String publisherName, String address, long publisherPhone) {
		super();
		this.id = id;
		this.publisherName = publisherName;
		this.address = address;
		this.publisherPhone = publisherPhone;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPublisherPhone() {
		return publisherPhone;
	}
	public void setPublisherPhone(long publisherPhone) {
		this.publisherPhone = publisherPhone;
	}
	public Set<Book> getBook() {
		return book;
	}
	public void setBook(Set<Book> book) {
		this.book = book;
	}
	
	
	

}
