package bookrecord.orm;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String authorName;
	private long authorNumber;
	@ManyToMany(targetEntity=Book.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},mappedBy="authors")
	private Set<Book> book;
	@OneToOne(targetEntity=AuthorAddress.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},mappedBy="author")
    private AuthorAddress authoraddress;
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Author(String authorName, long authorNumber) {
		super();
		this.authorName = authorName;
		this.authorNumber = authorNumber;
	}

	public Author(int id, String authorName, long authorNumber) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.authorNumber = authorNumber;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public long getAuthorNumber() {
		return authorNumber;
	}
	public void setAuthorNumber(long authorNumber) {
		this.authorNumber = authorNumber;
	}
	public Set<Book> getBook() {
		return book;
	}
	public void setBook(Set<Book> book) {
		this.book = book;
	}
	public AuthorAddress getAuthoraddress() {
		return authoraddress;
	}
	public void setAuthoraddress(AuthorAddress authoraddress) {
		this.authoraddress = authoraddress;
	}
	


}
