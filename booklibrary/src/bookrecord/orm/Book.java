package bookrecord.orm;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="allbook")
@DiscriminatorColumn(name="disc")
@DiscriminatorValue("bk")
@Entity

public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String isbn;
	private float price;
	private Date publishedDate;
	
	@ManyToOne(targetEntity=Publisher.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.EAGER)
	private Publisher publisher;
	
	@ManyToMany(targetEntity=Author.class,cascade={CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name="book_author",joinColumns=@JoinColumn(name="book_id",referencedColumnName="id"),
    inverseJoinColumns=@JoinColumn(name="author_id",referencedColumnName="id"))
	
	private Set<Author> authors;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Book(int id, String name, String isbn, float price, Date publishedDate) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
		this.price = price;
		this.publishedDate = publishedDate;
	}
	



	public Set<Author> getAuthors() {
		return authors;
	}



	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}



	public Book(String name, String isbn, float price, Date publishedDate) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.price = price;
		this.publishedDate = publishedDate;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
	
	
	
	

}
