package bookrecord.orm;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AuthorAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String street;
	private String state;
	private long zipCode;
	@OneToOne(targetEntity=Author.class,cascade={CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="author_id",referencedColumnName="id")
   private Author author;
	public AuthorAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AuthorAddress(String street, String state, long zipCode) {
		super();
		this.street = street;
		this.state = state;
		this.zipCode = zipCode;
	}

	public AuthorAddress(int id, String street, String state, long zipCode) {
		super();
		this.id = id;
		this.street = street;
		this.state = state;
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	

}
